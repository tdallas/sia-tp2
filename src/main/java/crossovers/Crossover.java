package crossovers;

import items.Item;

import java.util.List;
import java.util.Random;

public abstract class Crossover {

    protected final static int MAX_ALLELES = 5;

    public abstract List<List<Item>> crossover(final List<Item> from, final List<Item> to);

    protected int getCrossoverPoint() {
        return new Random().nextInt(5);
    }

}
