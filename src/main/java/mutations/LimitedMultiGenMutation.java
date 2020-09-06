package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;

import java.util.List;
import java.util.Random;

/**
 * Se selecciona una cantidad azarosa [1, M] de genes para mutar, con probabilidad Pm (todos? cada uno?)
 */
public class LimitedMultiGenMutation extends Mutation {

    private final double probability;

    public LimitedMultiGenMutation(final double probability, final Random random) {
        super(random);
        this.probability = probability;
    }

    @Override
    public List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider) {
        int amountToMutate = getRandom().nextInt(MAX_ALLELES);
        for (int i = 0 ; i <= amountToMutate; i++) {
            if (getRandom().nextDouble() < probability) {
                mutateAtPosition(AlleleType.getAlleleType(i), alleles, itemsProvider);
            }
        }
        return alleles;
    }
}
