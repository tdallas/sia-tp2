package crossovers;

import alleles.Allele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnnularCrossover extends Crossover {

    public AnnularCrossover(Random random) {
        super(random);
    }

    @Override
    public List<List<Allele>> crossover(final List<Allele> from, final List<Allele> to) {
        final int secondCrossoverPoint = getCrossoverPoint();
        int firstCrossoverPoint = (int) Math.ceil((double) secondCrossoverPoint / 2);
        final List<Allele> firstChildAlleles = getAlleles(from, to, firstCrossoverPoint, secondCrossoverPoint);
        final List<Allele> secondChildAlleles = getAlleles(to, from, firstCrossoverPoint, secondCrossoverPoint);
        return Arrays.asList(firstChildAlleles, secondChildAlleles);
    }

    private List<Allele> getAlleles(List<Allele> from, List<Allele> to, int mediumPoint, int toPoint) {
        final List<Allele> newAlleles = new ArrayList<>(to.subList(0, mediumPoint));
        newAlleles.addAll(from.subList(mediumPoint, toPoint));
        newAlleles.addAll(to.subList(toPoint, MAX_ALLELES));
        return newAlleles;
    }
}
