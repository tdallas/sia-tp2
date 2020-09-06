package engine;

import ItemProvider.ItemsProvider;
import characters.Character;
import crossovers.Crossover;
import cutConditions.CutCondition;
import engine.implementation.Implementation;
import mutations.Mutation;
import selections.SelectionMethod;

import java.util.List;
import java.util.Random;

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
                             final List<Character> firstPopulation) {
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
    }

    public void start(){
        Character bestCharacter = findBestCharacter(currentPopulation);
        while(!cutCondition.cutReached(currentPopulation, bestCharacter)){
            List<Character> selectedFathers = selectFromMethods(currentPopulation, k);
            //List<Character> children = breed(selectedFathers, crossover, mutation);
            //currentPopulation = implementation.nextPopulation(currentPopulation, children);
            bestCharacter = findBestCharacter(currentPopulation);
        }
    }

    private List<Character> selectFromMethods(List<Character> population, int n) {
        int k1 = (int) (selectionMethod1.getPercentage() * n);
        int K2 = n - k1;

        List<Character> selectedFromMethod1 = selectionMethod1.select(population, k1);
        List<Character> selectedFromMethod2 = selectionMethod2.select(population, K2);

        selectedFromMethod1.addAll(selectedFromMethod2);
        return selectedFromMethod1;
    }

    private Character findBestCharacter(List<Character> population){
        Character bestCharacter = population.get(0);
        for(Character c : population){
            if(c.getPerformance() > bestCharacter.getPerformance()){
                bestCharacter = c;
            }
        }
        return bestCharacter;
    }
}
