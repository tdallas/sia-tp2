package engine;

import ItemProvider.ItemsProvider;
import characters.Character;
import crossovers.Crossover;
import cutConditions.CutCondition;
import engine.implementation.Implementation;
import engine.utils.CharacterFactory;
import engine.utils.PopulationGenerator;
import mutations.Mutation;
import selections.SelectionMethod;

import java.util.List;
import java.util.Random;

public class GeneticsAlgorithm<T extends Character> {
    private final Random random;
    private final int populationSize;
    private final Implementation implementation;
    private final ItemsProvider itemsProvider;
    private final Crossover crossover;
    private final Mutation mutation;
    private final SelectionMethod selectionMethod1;
    private final SelectionMethod selectionMethod2;
    private final SelectionMethod repetitionMethod1;
    private final SelectionMethod repetitionMethod2;
    private final CutCondition cutCondition;
    private List<T> currentPopulation;
    private final CharacterFactory<T> characterFactory;

    public GeneticsAlgorithm(final Random random,
                             final int populationSize,
                             final Implementation implementation,
                             final ItemsProvider itemsProvider,
                             final Crossover crossover,
                             final Mutation mutation,
                             final SelectionMethod selectionMethod1,
                             final SelectionMethod selectionMethod2,
                             final SelectionMethod repetitionMethod1,
                             final SelectionMethod repetitionMethod2,
                             final CutCondition cutCondition,
                             final CharacterFactory<T> characterFactory) {
        this.random = random;
        this.populationSize = populationSize;
        this.implementation = implementation;
        this.itemsProvider = itemsProvider;
        this.crossover = crossover;
        this.mutation = mutation;
        this.selectionMethod1 = selectionMethod1;
        this.selectionMethod2 = selectionMethod2;
        this.repetitionMethod1 = repetitionMethod1;
        this.repetitionMethod2 = repetitionMethod2;
        this.cutCondition = cutCondition;
        this.characterFactory = characterFactory;
        this.currentPopulation = new PopulationGenerator<T>().generateFirstPopulation(
                populationSize,
                random,
                itemsProvider,
                characterFactory
        );
    }
}
