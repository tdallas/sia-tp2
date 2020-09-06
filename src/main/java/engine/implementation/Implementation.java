package engine.implementation;

import characters.Character;
import selections.SelectionMethod;

import java.util.List;

public abstract class Implementation {
    private final SelectionMethod replacementMethod1;
    private final SelectionMethod replacementMethod2;

    public Implementation(SelectionMethod replacementMethod1, SelectionMethod replacementMethod2) {
        this.replacementMethod1 = replacementMethod1;
        this.replacementMethod2 = replacementMethod2;
    }

    public SelectionMethod getReplacementMethod1() {
        return replacementMethod1;
    }

    public SelectionMethod getReplacementMethod2() {
        return replacementMethod2;
    }

    public abstract List<Character> nextPopulation(List<Character> currentPopulation, List<Character> fathers, List<Character> sons);
}
