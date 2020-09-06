package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;

import java.util.List;
import java.util.Random;

/**
 * Con una probabilidad Pm se mutan todos los alelos acorde a la funcion asociada a cada alelo
 */
public class CompleteMutation extends Mutation {
    private final double probability;

    public CompleteMutation(final double probability, final Random random) {
        super(random);
        this.probability = probability;
    }

    @Override
    public List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider) {
        for (Allele allele : alleles) {
            if (getRandom().nextDouble() < probability) {
                int indexOfAllele = alleles.indexOf(allele);
                mutateAtPosition(AlleleType.getAlleleType(indexOfAllele), alleles, itemsProvider);
            }
        }
        return alleles;
    }

}
