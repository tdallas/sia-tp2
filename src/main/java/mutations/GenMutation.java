package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;
import alleles.Height;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class GenMutation extends Mutation{

    public GenMutation(Random random) {
        super(random);
    }

    @Override
    public List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider) {
        int randomAllele = getRandom().nextInt(MAX_ALLELES);
        mutateAtPosition(AlleleType.getAlleleType(randomAllele), alleles, itemsProvider);
        return alleles;
    }
}
