package engine.implementation;

import characters.Character;
import selections.SelectionMethod;

import java.util.List;

public class FillAll extends Implementation{
    public FillAll(final SelectionMethod replacementMethod1, final SelectionMethod replacementMethod2, final int populationSize, final int k) {
        super(replacementMethod1, replacementMethod2, populationSize, k);
    }

    @Override
    public List<Character> nextPopulation(List<Character> currentPopulation, List<Character> sons) {
        currentPopulation.addAll(sons);
        return selectFromMethods(currentPopulation, getPopulationSize());
    }
}
