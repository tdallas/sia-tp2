package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.List;

public class EliteSelectionMethod extends SelectionMethod{

    public EliteSelectionMethod(double probability) {
        super(probability);
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        List<Character> selectedList = new ArrayList<>();

        population.sort((c1, c2) -> (int)(c2.calculatePerformance(c2.getItems()) - c1.calculatePerformance(c1.getItems())));

        for (int i = 0; i < k; i++)
            selectedList.add(population.get(i));

        return selectedList;
    }
}
