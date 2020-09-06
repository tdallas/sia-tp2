package cutConditions;

import characters.Character;

import java.util.List;

public class TimeCutCondition extends CutCondition{
    private final long finishTime;

    public TimeCutCondition(long timeMillis) {
        this.finishTime = System.currentTimeMillis() + timeMillis;
    }

    @Override
    public boolean cutReached(List<Character> population, Character bestCharacter) {
        return System.currentTimeMillis() >= finishTime;
    }
}
