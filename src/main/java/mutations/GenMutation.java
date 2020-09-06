package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class GenMutation extends Mutation {

    private final double probability;

    public GenMutation(final double probability, final Random random) {
        super(random);
        this.probability = probability;
    }

    @Override
    public List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider) {
        if (getRandom().nextDouble() < probability) {
            int randomAllele = getRandom().nextInt(MAX_ALLELES);
            mutateAtPosition(AlleleType.getAlleleType(randomAllele), alleles, itemsProvider);
        }
        return alleles;
    }
}
