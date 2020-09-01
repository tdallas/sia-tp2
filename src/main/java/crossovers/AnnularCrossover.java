package crossovers;

import items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnularCrossover extends Crossover {

    @Override
    public List<List<Item>> crossover(final List<Item> from, final List<Item> to) {
        final int secondCrossoverPoint = getCrossoverPoint();
        int firstCrossoverPoint = (int) Math.ceil((double) secondCrossoverPoint/2);
        final List<Item> firstChildAlleles = getAlleles(from, to, firstCrossoverPoint, secondCrossoverPoint);
        final List<Item> secondChildAlleles = getAlleles(to, from, firstCrossoverPoint, secondCrossoverPoint);
        return Arrays.asList(firstChildAlleles, secondChildAlleles);
    }

    private List<Item> getAlleles(List<Item> from, List<Item> to, int mediumPoint, int toPoint) {
        final List<Item> newAlleles = new ArrayList<>(to.subList(0, mediumPoint));
        newAlleles.addAll(from.subList(mediumPoint, toPoint));
        newAlleles.addAll(to.subList(toPoint, MAX_ALLELES));
        return newAlleles;
    }
}
