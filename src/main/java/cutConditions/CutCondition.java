package cutConditions;

import characters.Character;

import java.util.List;

public abstract class CutCondition {

    public abstract boolean cutReached(List<Character> population, Character bestCharacter);
}
