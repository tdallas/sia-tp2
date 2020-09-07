package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class DeterministicTournamentSelection extends TournamentSelectionMethod {
    public DeterministicTournamentSelection(double percentage, final Random rand, final int m) {
        super(percentage, rand, m);
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        List<Character> selectedList = new ArrayList<>();
        List<Character> populationNoRepeated = new ArrayList<>(new HashSet<>(population));
        Character selected;

        for (int i = 0; i < k; i++) {
            selected = getFittest(populationNoRepeated);
            selectedList.add(selected);
        }

        return selectedList;
    }


    @Override
    public String toString() {
        return "DETERMINISTIC_TOURNAMENT" + ", Percentage: " + getPercentage() + ", M Parameter: " + getM();
    }
}
