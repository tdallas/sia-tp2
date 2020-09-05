package selections;

import characters.Character;

import java.util.*;

public abstract class TournamentSelectionMethod extends SelectionMethod{
    private final Random rand;
    private int m;

    public TournamentSelectionMethod(double percentage, final Random rand){
        super(percentage);
        this.rand = rand;
    }

    public void setM(int m) {
        this.m = m;
    }

    public Random getRand() {
        return rand;
    }

    Character getFittestChromosomeFromRandomSubset(final List<Character> uniqueChromosomes) {
        SortedSet<Character> randoms = createRandomSubset(uniqueChromosomes);
        return randoms.last();
    }

    Character getLeastFitChromosomeFromRandomSubset(final List<Character> uniqueChromosomes) {
        SortedSet<Character> randoms = createRandomSubset(uniqueChromosomes);
        return randoms.first();
    }

    private SortedSet<Character> createRandomSubset(final List<Character> uniqueChromosomes) {
        return uniqueChromosomes.size() < m ?
                allowToFightSelfInTournament(uniqueChromosomes) :
                getRandomsFromRandomFights(uniqueChromosomes);
    }

    private SortedSet<Character> allowToFightSelfInTournament(final List<Character> uniqueChromosomes) {
        SortedSet<Character> randoms = new TreeSet<>();

        for (int j = 0; j < m; j++)
            randoms.add(uniqueChromosomes.get(rand.nextInt(uniqueChromosomes.size())));

        return randoms;
    }

    private SortedSet<Character> getRandomsFromRandomFights(final List<Character> uniqueChromosomes) {
        SortedSet<Character> randoms = new TreeSet<>();
        Character randomChromosome;

        for (int j = 0; j < m; j++)
            do
                randomChromosome = uniqueChromosomes.get(rand.nextInt(uniqueChromosomes.size()));
            while (!randoms.add(randomChromosome));

        return randoms;
    }
}
