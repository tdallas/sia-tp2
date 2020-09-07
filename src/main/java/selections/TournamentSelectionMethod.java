package selections;

import characters.Character;

import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class TournamentSelectionMethod extends SelectionMethod {
    private final Random rand;
    private final int m;

    public TournamentSelectionMethod(double percentage, final Random rand, int m) {
        super(percentage);
        this.rand = rand;
        this.m = m;
    }

    public Random getRand() {
        return rand;
    }

    public int getM(){
        return m;
    }

    Character getFittest(final List<Character> populationNoRepeated) {
        SortedSet<Character> randoms = createRandomSubset(populationNoRepeated);
        return randoms.first();
    }

    Character getLeastFit(final List<Character> populationNoRepeated) {
        SortedSet<Character> randoms = createRandomSubset(populationNoRepeated);
        return randoms.last();
    }

    private SortedSet<Character> createRandomSubset(final List<Character> populationNoRepeated) {
        SortedSet<Character> randoms = new TreeSet<>();
        int size = populationNoRepeated.size();
        if (size < m) {
            for (int i = 0; i < m; i++) {
                randoms.add(populationNoRepeated.get(rand.nextInt(size)));
            }
        } else {
            for (int i = 0; i < m; i++) {
                Character randomCharacter = populationNoRepeated.get(rand.nextInt(size));
                while (!randoms.add(randomCharacter)) {
                    randomCharacter = populationNoRepeated.get(rand.nextInt(size));
                }
            }
        }
        return randoms;
    }
}
