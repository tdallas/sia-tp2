package crossovers;

import items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublePointCrossover extends Crossover {

    @Override
    public List<List<Item>> crossover(final List<Item> from, final List<Item> to) {
        final int firstCrossoverPoint = getCrossoverPoint();
        int secondCrossoverPoint = firstCrossoverPoint;
        while (secondCrossoverPoint == firstCrossoverPoint) {
            secondCrossoverPoint = getCrossoverPoint();
        }

        final List<Item> firstChildAlleles = getAlleles(from, to, firstCrossoverPoint, secondCrossoverPoint);
        final List<Item> secondChildAlleles = getAlleles(to, from, firstCrossoverPoint, secondCrossoverPoint);
        return Arrays.asList(firstChildAlleles, secondChildAlleles);
    }

    private List<Item> getAlleles(List<Item> from, List<Item> to, int mediumPoint, int toPoint) {
        final List<Item> newAlleles = new ArrayList<>(from.subList(0, mediumPoint));
        newAlleles.addAll(to.subList(mediumPoint, toPoint));
        newAlleles.addAll(from.subList(toPoint, MAX_ALLELES));
        return newAlleles;
    }

}
