package cutConditions;

import characters.Character;

import java.util.List;

public class GenerationCutCondition extends CutCondition {
    private final int maxGenerations;
    private int generation;

    public GenerationCutCondition(int maxGenerations) {
        this.maxGenerations = maxGenerations;
        this.generation = 0;
    }

    @Override
    public boolean cutReached(List<Character> population, Character bestCharacter) {
        generation++;
        return generation >= maxGenerations;
    }

    @Override
    public String toString() {
        return "GENERATION, Max Generations Parameter: " + maxGenerations;
    }
}
