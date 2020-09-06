package engine.implementation;

import characters.Character;
import selections.SelectionMethod;

import java.util.List;

public class FillParent extends Implementation{
    public FillParent(SelectionMethod replacementMethod1, SelectionMethod replacementMethod2) {
        super(replacementMethod1, replacementMethod2);
    }

    @Override
    public List<Character> nextPopulation(List<Character> currentPopulation, List<Character> fathers, List<Character> sons) {
        return null;
    }
}
