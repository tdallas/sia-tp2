package crossovers;

import mutations.Allele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoublePointCrossover extends Crossover {

    @Override
    public List<List<Allele>> crossover(final List<Allele> from, final List<Allele> to) {
        final int firstCrossoverPoint = getCrossoverPoint();
        int secondCrossoverPoint = firstCrossoverPoint;
        while (secondCrossoverPoint == firstCrossoverPoint) {
            secondCrossoverPoint = getCrossoverPoint();
        }

        final List<Allele> firstChildAlleles = getAlleles(from, to, firstCrossoverPoint, secondCrossoverPoint);
        final List<Allele> secondChildAlleles = getAlleles(to, from, firstCrossoverPoint, secondCrossoverPoint);
        return Arrays.asList(firstChildAlleles, secondChildAlleles);
    }

    private List<Allele> getAlleles(List<Allele> from, List<Allele> to, int mediumPoint, int toPoint) {
        final List<Allele> newAlleles = new ArrayList<>(from.subList(0, mediumPoint));
        newAlleles.addAll(to.subList(mediumPoint, toPoint));
        newAlleles.addAll(from.subList(toPoint, MAX_ALLELES));
        return newAlleles;
    }

}
