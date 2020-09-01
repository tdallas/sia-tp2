package crossovers;

import items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SinglePointCrossover extends Crossover {

    @Override
    public List<List<Item>> crossover(final List<Item> from, final List<Item> to) {
        final int crossoverPoint = getCrossoverPoint();
        final List<Item> firstChildAlleles = getAlleles(from, to, crossoverPoint);
        final List<Item> secondChildAlleles = getAlleles(to, from, crossoverPoint);
        return Arrays.asList(firstChildAlleles, secondChildAlleles);
    }

    private List<Item> getAlleles(List<Item> from, List<Item> to, int toPoint) {
        final List<Item> newAlleles = new ArrayList<>(from.subList(0, toPoint));
        newAlleles.addAll(to.subList(toPoint, MAX_ALLELES));
        return newAlleles;
    }

}
