package selections;

import characters.Character;

import java.util.List;

public abstract class SelectionMethod {
    public abstract List<Character> select(List<Character> population, final int k);
}
