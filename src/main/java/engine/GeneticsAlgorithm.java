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
        this.currentPopulation = firstPopulation;
    }

    public void start(){

    }
}
