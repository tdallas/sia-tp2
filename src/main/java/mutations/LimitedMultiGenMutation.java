package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;

import java.util.List;
import java.util.Random;

/**
 * Se selecciona una cantidad azarosa [1, M] de genes para mutar, con probabilidad Pm (todos? cada uno?)
 */
public class LimitedMultiGenMutation extends GenMutation {

    private final double probability;

    public LimitedMultiGenMutation(final double probability, final Random random) {
        super(random);
        this.probability = probability;
    }

    public List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider) {
        int amountToMutate = getRandom().nextInt(alleles.size()) - 1;
        while (amountToMutate >= 0) {
            if (getRandom().nextDouble() < probability) {
                mutateAtPosition(AlleleType.getAlleleType(amountToMutate--), alleles, itemsProvider);
            }
        }
        return alleles;
    }

}
