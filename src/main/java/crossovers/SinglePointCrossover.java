package crossovers;

import alleles.Allele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SinglePointCrossover extends Crossover {

    @Override
    public List<List<Allele>> crossover(final List<Allele> from, final List<Allele> to) {
        final int crossoverPoint = getCrossoverPoint();
        final List<Allele> firstChildAlleles = getAlleles(from, to, crossoverPoint);
        final List<Allele> secondChildAlleles = getAlleles(to, from, crossoverPoint);
        return Arrays.asList(firstChildAlleles, secondChildAlleles);
    }

    protected List<Allele> getAlleles(List<Allele> from, List<Allele> to, int toPoint) {
        final List<Allele> newAlleles = new ArrayList<>(from.subList(0, toPoint));
        newAlleles.addAll(to.subList(toPoint, MAX_ALLELES));
        return newAlleles;
    }

}
