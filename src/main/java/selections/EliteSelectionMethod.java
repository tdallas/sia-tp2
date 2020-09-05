package selections;

import characters.Character;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class EliteSelectionMethod extends SelectionMethod{

    @Override
    public List<Character> select(List<Character> population, int k) {
        ArrayList<Character> elite = new ArrayList<>();

        population.sort((c1, c2) -> (int)(c2.calculatePerformance(c2.getItems()) - c1.calculatePerformance(c1.getItems())));

        for (int i = 0; i < k; i++)
            elite.add(population.get(i));

        return elite;
    }
}
