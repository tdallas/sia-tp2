package engine;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.Height;
import alleles.items.*;
import characters.*;
import characters.Character;
import crossovers.Crossover;
import cutConditions.CutCondition;
import engine.implementation.Implementation;
import engine.utils.CharacterFactory;
import mutations.Mutation;
import selections.SelectionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static engine.utils.CharacterFactory.*;

public class GeneticsAlgorithm {
    private final Random random;
    private final int populationSize;
    private final Implementation implementation;
    private final ItemsProvider itemsProvider;
    private final Crossover crossover;
    private final Mutation mutation;
    private final SelectionMethod selectionMethod1;
    private final SelectionMethod selectionMethod2;
    private final CutCondition cutCondition;
    private final int k;
    private List<Character> currentPopulation;
    private final String characterClass;

    public GeneticsAlgorithm(final Random random,
                             final int populationSize,
                             final ItemsProvider itemsProvider,
                             final SelectionMethod selectionMethod1,
                             final SelectionMethod selectionMethod2,
                             final Crossover crossover,
                             final Mutation mutation,
                             final Implementation implementation,
                             final CutCondition cutCondition,
                             final int k,
                             final List<Character> firstPopulation,
                             final String characterClass) {
        this.random = random;
        this.populationSize = populationSize;
        this.implementation = implementation;
        this.itemsProvider = itemsProvider;
        this.crossover = crossover;
        this.mutation = mutation;
        this.selectionMethod1 = selectionMethod1;
        this.selectionMethod2 = selectionMethod2;
        this.cutCondition = cutCondition;
        this.k = k;
        this.currentPopulation = firstPopulation;
        this.characterClass = characterClass;
    }

    public void start() {
        Character aux, bestCharacter = findBestCharacter(currentPopulation);
        while (!cutCondition.cutReached(currentPopulation, bestCharacter)) {
            List<Character> selectedFathers = selectFromMethods(currentPopulation, k);

            List<Character> children = new ArrayList<>(selectedFathers.size());

            for (int i = 0; i < selectedFathers.size() - 1; i += 2) {
                children.addAll(breeding(selectedFathers.get(i), selectedFathers.get(i+1)));
            }

            currentPopulation = implementation.nextPopulation(currentPopulation, children);

            aux = findBestCharacter(currentPopulation);
            if(aux.getPerformance() > bestCharacter.getPerformance()){
                bestCharacter = aux;
            }
        }
        System.out.println(bestCharacter);
    }

    private List<Character> selectFromMethods(List<Character> population, int n) {
        int kMethod1 = (int) (selectionMethod1.getPercentage() * n);
        int kMethod2 = n - kMethod1;

        List<Character> selectedFromMethod1 = selectionMethod1.select(population, kMethod1);
        List<Character> selectedFromMethod2 = selectionMethod2.select(population, kMethod2);

        selectedFromMethod1.addAll(selectedFromMethod2);
        return selectedFromMethod1;
    }

    private Character findBestCharacter(List<Character> population) {
        Character bestCharacter = population.get(0);
        for (Character c : population) {
            if (c.getPerformance() > bestCharacter.getPerformance()) {
                bestCharacter = c;
            }
        }
        return bestCharacter;
    }

    public List<Character> breeding(final Character dad, final Character mom) {
        List<List<Allele>> children = crossover.crossover(dad.getAlleles(), mom.getAlleles());
        List<List<Allele>> mutatedChildren = new ArrayList<>(2);
        children.forEach(child -> mutatedChildren.add(mutation.mutate(child, itemsProvider)));
        return mutatedChildren
                .parallelStream()
                .map(alleles -> fromAllelesToCharacter(alleles, characterClass))
                .collect(Collectors.toList());
    }

    // boots, chest, gloves, helmet, weapon
    private <T extends Character> Character fromAllelesToCharacter(List<Allele> alleles, String characterClass) {
        CharacterFactory<T> characterCharacterFactory = getFactory(characterClass);
        Height height = (Height) alleles.get(0);
        return characterCharacterFactory.characterSupplier(
                (Boots) alleles.get(1),
                (Chest) alleles.get(2),
                (Gloves) alleles.get(3),
                (Helmet) alleles.get(4),
                (Weapon) alleles.get(5),
                height.getValue()
        );
    }

    private <T extends Character> CharacterFactory<T> getFactory(String characterClass) {
        switch (characterClass) {
            case WARRIOR:
                return (CharacterFactory<T>) new CharacterFactory<Warrior>(Warrior.class);
            case ROGUE:
                return (CharacterFactory<T>) new CharacterFactory<Rogue>(Rogue.class);
            case ARCHER:
                return (CharacterFactory<T>) new CharacterFactory<Archer>(Archer.class);
            default:
                return (CharacterFactory<T>) new CharacterFactory<Defender>(Defender.class);
        }
    }

}
