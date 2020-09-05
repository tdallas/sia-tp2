package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ProbabilisticTournamentSelection extends TournamentSelectionMethod {
    public ProbabilisticTournamentSelection(double percentage, Random rand) {
        super(percentage, rand);
        setM(2);
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        List<Character> selectedList      = new ArrayList<>();
        List<Character> uniqueChromosomes = new ArrayList<>(new HashSet<>(population));
        Character selectedChromosome;

        for (int i = 0; i < k; i++) {
            selectedChromosome = selectChromosome(uniqueChromosomes);
            selectedList.add(selectedChromosome);
        }

        return selectedList;
    }

    private Character selectChromosome(final List<Character> uniqueChromosomes) {
        double r = getRand().nextDouble();

        if (r < 0.75) // Specified in the genetic algorithms class .pdf
            return getFittestChromosomeFromRandomSubset(uniqueChromosomes);
        else
            return getLeastFitChromosomeFromRandomSubset(uniqueChromosomes);
    }
}
