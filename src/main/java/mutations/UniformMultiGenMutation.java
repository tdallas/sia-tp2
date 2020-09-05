package mutations;

import ItemProvider.ItemsProvider;

import java.util.List;
import java.util.Random;

/**
 * Cada gen tiene una probabilidad Pm de ser mutado
 */
public class UniformMultiGenMutation extends GenMutation {

    private final double probability;

    public UniformMultiGenMutation(final double probability, final Random random, double probability1) {
        super(random);
        this.probability = probability1;
    }

    public List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider) {
        for (Allele allele : alleles) {
            if (getRandom().nextDouble() < probability) {
                mutateAtPosition(AlleleType.getAlleleType(alleles.indexOf(allele)), alleles, itemsProvider);
            }
        }
        return alleles;
    }

}
