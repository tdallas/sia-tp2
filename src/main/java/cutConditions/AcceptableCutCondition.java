package cutConditions;

import characters.Character;

import java.util.List;

public class AcceptableCutCondition extends CutCondition {
    private final double acceptableFitness;

    public AcceptableCutCondition(double acceptableFitness) {
        this.acceptableFitness = acceptableFitness;
    }

    @Override
    public boolean cutReached(List<Character> population, Character bestCharacter) {
        return bestCharacter.getPerformance() >= acceptableFitness;
    }

    @Override
    public String toString() {
        return "ACCEPTABLE, Acceptable Fitness Parameter: " + acceptableFitness;
    }
}
