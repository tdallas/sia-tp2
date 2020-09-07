package cutConditions;

import characters.Character;

import java.util.List;

public class ContentCutCondition extends CutCondition {
    private final int maxGenerations;
    private Character lastBestCharacter;
    private int generations;

    public ContentCutCondition(int maxGenerations) {
        this.maxGenerations = maxGenerations;
        this.generations = 0;
        this.lastBestCharacter = null;
    }

    @Override
    public boolean cutReached(List<Character> population, Character bestCharacter) {
        if (lastBestCharacter == null || !lastBestCharacter.equals(bestCharacter)) {
            lastBestCharacter = bestCharacter;
            generations = 1;
        } else {
            generations++;
            return generations >= maxGenerations;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CONTENT, Generations Parameter: " + maxGenerations;
    }
}
