package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class DeterministicTournamentSelection extends TournamentSelectionMethod{
    public DeterministicTournamentSelection(double percentage,final Random rand, final int m) {
        super(percentage, rand);
        setM(calculateM());
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        List<Character> selectedList      = new ArrayList<>();
        List<Character> uniqueChromosomes = new ArrayList<>(new HashSet<>(population));
        Character fittestInRandomSet;

        for (int i = 0; i < k; i++) {
            fittestInRandomSet = getFittestChromosomeFromRandomSubset(uniqueChromosomes);
            selectedList.add(fittestInRandomSet);
        }

        return selectedList;
    }

    private int calculateM() {
        int max = 3, min = 2; // Specified in the genetic algorithms class .pdf
        return min + getRand().nextInt((max - min) + 1); // Added 1 because nextInt's bound is exclusive
    }

}
