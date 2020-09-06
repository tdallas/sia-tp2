package crossovers;

import alleles.Allele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UniformCrossover extends Crossover {

    public UniformCrossover(Random rand) {
        super(rand);
    }

    @Override
    public List<List<Allele>> crossover(List<Allele> from, List<Allele> to) {
        final List<Allele> firstAlleles = new ArrayList<>();
        final List<Allele> secondAlleles = new ArrayList<>();
        for (int i = 0; i < MAX_ALLELES; i++) {
            if (getRandom().nextInt() % 2 == 0) {
                firstAlleles.add(from.get(i));
                secondAlleles.add(to.get(i));
            } else {
                firstAlleles.add(to.get(i));
                secondAlleles.add(from.get(i));
            }
        }
        return Arrays.asList(firstAlleles, secondAlleles);
    }
}
