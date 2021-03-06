package engine;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.Height;
import alleles.items.*;
import characters.Character;
import characters.*;
import crossovers.Crossover;
import cutConditions.CutCondition;
import engine.implementation.Implementation;
import engine.utils.CharacterFactory;
import engine.utils.GenerationalGap;
import mutations.Mutation;
import selections.SelectionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static engine.utils.CharacterFactory.*;

public class GeneticsAlgorithm {
    private final long randomSeed;
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
    private int generation;
    private long totalTime;

    @Override
    public String toString() {
        return "Random seed: " + randomSeed +
                " | Character class: " + characterClass +
                " | Population size: " + populationSize +
                " | Parents and children size: " + k +
                " | Selection method 1: " + selectionMethod1 +
                " | Selection method 2: " + selectionMethod2 +
                " | Crossover: " + crossover +
                " | Mutation: " + mutation +
                " | Implementation: " + implementation +
                " | Replacement method 1: " + implementation.getReplacementMethod1() +
                " | Replacement method 2: " + implementation.getReplacementMethod2() +
                " | Cut condition: " + cutCondition;
    }

    public GeneticsAlgorithm(final long randomSeed,
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
        this.randomSeed = randomSeed;
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
        this.generation = 0;
    }

    public Character findBestCharacter() {
        Character bestCharacter = currentPopulation.get(0);
        List <Character> selectedFathers, children, nextPopulation;
        double minimumFitness, averageFitness;
        long startTime = System.currentTimeMillis();
        System.out.println("t,fMin,fAvg,fMax");
        while (!cutCondition.cutReached(currentPopulation, bestCharacter)) {
            selectedFathers = selectFromMethods(currentPopulation, k);

            children = new ArrayList<>(selectedFathers.size());

            for (int i = 0; i < selectedFathers.size() - 1; i += 2) {
                children.addAll(breeding(selectedFathers.get(i), selectedFathers.get(i + 1)));
            }

            nextPopulation = implementation.nextPopulation(currentPopulation, children);

            minimumFitness = Double.MAX_VALUE;
            averageFitness = 0;
            for (Character c : currentPopulation) {
                double fitness = c.getPerformance();
                if (fitness > bestCharacter.getPerformance()) {
                    bestCharacter = c;
                }
                if(fitness < minimumFitness){
                    minimumFitness = fitness;
                }
                averageFitness += fitness;
            }
            averageFitness = averageFitness / currentPopulation.size();
            System.out.println((System.currentTimeMillis() - startTime) + "," +minimumFitness + "," + averageFitness + "," + bestCharacter.getPerformance());

            currentPopulation = nextPopulation;
            generation++;
        }
        totalTime = System.currentTimeMillis() - startTime;
        return bestCharacter;
    }

    private List<Character> selectFromMethods(List<Character> population, int n) {
        int kMethod1 = (int) (selectionMethod1.getPercentage() * n);
        int kMethod2 = n - kMethod1;

        List<Character> selectedFromMethod1 = selectK(selectionMethod1, population, kMethod1);
        List<Character> selectedFromMethod2 = selectK(selectionMethod2, population, kMethod2);

        selectedFromMethod1.addAll(selectedFromMethod2);
        return selectedFromMethod1;
    }

    private List<Character> selectK(SelectionMethod selectionMethod, List<Character> population, int k){
        List<Character> result;
        if(k > populationSize){
            result = new ArrayList<>();
            while(k > populationSize){
                result.addAll(selectionMethod.select(population, populationSize));
                k -= populationSize;
            }
            result.addAll(selectionMethod.select(population, k));
        }
        else{
            result = selectionMethod.select(population, k);
        }
        return result;
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

    public int getGeneration(){
        return generation;
    }

    public long getTotalTime(){
        return totalTime;
    }

}
