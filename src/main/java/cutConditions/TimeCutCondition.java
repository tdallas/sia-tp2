package cutConditions;

import characters.Character;

import java.util.List;

public class TimeCutCondition extends CutCondition {
    private final long finishTime;
    private final long timeParam;

    public TimeCutCondition(long timeMillis) {
        this.finishTime = System.currentTimeMillis() + timeMillis;
        this.timeParam = timeMillis;
    }

    @Override
    public boolean cutReached(List<Character> population, Character bestCharacter) {
        return System.currentTimeMillis() >= finishTime;
    }

    @Override
    public String toString() {
        return "TIME, Time Parameter: " + timeParam;
    }
}
