package engine.implementation;

import characters.Character;
import selections.SelectionMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Implementation {
    private final SelectionMethod replacementMethod1;
    private final SelectionMethod replacementMethod2;
    private final int populationSize;
    private final int k;

    public Implementation(final SelectionMethod replacementMethod1, final SelectionMethod replacementMethod2, final int populationSize, final int k) {
        this.replacementMethod1 = replacementMethod1;
        this.replacementMethod2 = replacementMethod2;
        this.populationSize = populationSize;
        this.k = k;
    }

    public SelectionMethod getReplacementMethod1() {
        return replacementMethod1;
    }

    public SelectionMethod getReplacementMethod2() {
        return replacementMethod2;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getK() {
        return k;
    }

    protected List<Character> selectFromMethods(List<Character> population, int n) {
        int kMethod1 = (int) (replacementMethod1.getPercentage() * n);
        int KMethod2 = n - kMethod1;

        List<Character> selectedFromMethod1 = selectK(replacementMethod1, population, kMethod1);
        List<Character> selectedFromMethod2 = selectK(replacementMethod2, population, KMethod2);

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

    public abstract List<Character> nextPopulation(List<Character> currentPopulation, List<Character> sons);
}
