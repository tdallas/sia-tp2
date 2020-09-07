package engine.implementation;

import characters.Character;
import selections.SelectionMethod;

import java.util.List;

public class FillParent extends Implementation {
    public FillParent(final SelectionMethod replacementMethod1, final SelectionMethod replacementMethod2, final int populationSize, final int k) {
        super(replacementMethod1, replacementMethod2, populationSize, k);
    }

    @Override
    public List<Character> nextPopulation(List<Character> currentPopulation, List<Character> sons) {
        if (getK() > getPopulationSize()) {
            return selectFromMethods(sons, getPopulationSize());
        } else {
            List<Character> fillPart = selectFromMethods(currentPopulation, getPopulationSize() - getK());
            sons.addAll(fillPart);
            return sons;
        }
    }

    @Override
    public String toString() {
        return "FILL_PARENT";
    }
}
