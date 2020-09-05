package crossovers;

import items.Item;
import mutations.Allele;

import java.util.List;
import java.util.Random;

public abstract class Crossover {

    protected final static int MAX_ALLELES = 6;

    public abstract List<List<Allele>> crossover(final List<Allele> from, final List<Allele> to);

    protected int getCrossoverPoint() {
        return new Random().nextInt(MAX_ALLELES);
    }

}
