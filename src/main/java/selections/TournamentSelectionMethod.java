package selections;

import characters.Character;

import java.util.*;

public abstract class TournamentSelectionMethod extends SelectionMethod{
    private final Random rand;
    private final int m;

    public TournamentSelectionMethod(double percentage, final Random rand, int m){
        super(percentage);
        this.rand = rand;
        this.m = m;
    }

    public Random getRand() {
        return rand;
    }

    Character getFittest(final List<Character> populationNoRepeated) {
        SortedSet<Character> randoms = createRandomSubset(populationNoRepeated);
        return randoms.last();
    }

    Character getLeastFit(final List<Character> populationNoRepeated) {
        SortedSet<Character> randoms = createRandomSubset(populationNoRepeated);
        return randoms.first();
    }

    private SortedSet<Character> createRandomSubset(final List<Character> populationNoRepeated) {
        SortedSet<Character> randoms = new TreeSet<>();
        int size = populationNoRepeated.size();
        if(size < m){
            for (int i = 0; i < m; i++) {
                randoms.add(populationNoRepeated.get(rand.nextInt(size)));
            }
        } else{
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
