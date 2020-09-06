package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ProbabilisticTournamentSelection extends TournamentSelectionMethod {

    private final double threshold;

    public ProbabilisticTournamentSelection(double percentage, Random rand, double threshold) {
        super(percentage, rand, 2);
        this.threshold = threshold;
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        List<Character> selectedList = new ArrayList<>();
        List<Character> populationNoRepeated = new ArrayList<>(new HashSet<>(population));
        Character selected;
        double r;

        for (int i = 0; i < k; i++) {
            r = getRand().nextDouble();

            if (r < threshold) {
                selected = getFittest(populationNoRepeated);
            } else {
                selected = getLeastFit(populationNoRepeated);
            }
            selectedList.add(selected);
        }

        return selectedList;
    }
}
