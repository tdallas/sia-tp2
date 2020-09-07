package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EliteSelectionMethod extends SelectionMethod {

    public EliteSelectionMethod(double percentage) {
        super(percentage);
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        List<Character> selectedList = new ArrayList<>();

        Collections.sort(population);

        for (int i = k - 1; i >= 0; i--)
            selectedList.add(population.get(i));

        return selectedList;
    }
}
