package crossovers;

import alleles.Allele;

import java.util.List;
import java.util.Random;

public abstract class Crossover {
    protected final static int MAX_ALLELES = 6;
    private final Random random;

    public Crossover(Random random) {
        this.random = random;
    }

    public abstract List<List<Allele>> crossover(final List<Allele> from, final List<Allele> to);

    protected int getCrossoverPoint() {
        return random.nextInt(MAX_ALLELES);
    }

    protected Random getRandom() {
        return random;
    }

}
