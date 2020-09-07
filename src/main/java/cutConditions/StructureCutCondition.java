package cutConditions;

import characters.Character;

import java.util.ArrayList;
import java.util.List;

public class StructureCutCondition extends CutCondition {
    private final int populationInCommon;
    private final int maxGenerations;
    private List<Character> lastPopulation;
    private int generations;

    public StructureCutCondition(final int populationInCommon, final int maxGenerations) {
        this.populationInCommon = populationInCommon;
        this.maxGenerations = maxGenerations;
        this.generations = 0;
        this.lastPopulation = null;
    }

    @Override
    public boolean cutReached(List<Character> population, Character bestCharacter) {
        if (lastPopulation == null) {
            generations = 1;
            lastPopulation = new ArrayList<>(population);
        } else if (charactersInCommon(lastPopulation, population) >= populationInCommon) {
            generations++;
            if (generations >= maxGenerations) {
                return true;
            }
            lastPopulation = new ArrayList<>(population);
        }
        return false;
    }

    private int charactersInCommon(List<Character> population1, List<Character> population2) {
        int sum = 0;
        for (Character a : population1) {
            for (Character b : population2) {
                if (a.equals(b)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "STRUCTURE";
    }
}
