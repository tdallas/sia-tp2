package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;
import alleles.Height;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public abstract class Mutation {
    protected final static int MAX_ALLELES = 6;

    private final Random random;

    public Mutation(Random random) {
        this.random = random;
    }

    protected void mutateAtPosition(final AlleleType position, final List<Allele> alleles, final ItemsProvider itemsProvider) {
        Allele newAllele;
        int newRandomPosition = random.nextInt(itemsProvider.getMAX_ITEMS());
        if (position == AlleleType.HEIGHT) {
            newAllele = new Height(Height.MIN_HEIGHT + random.nextDouble() * (Height.MAX_HEIGHT - Height.MIN_HEIGHT));
        } else {
            newAllele = itemsProvider.getItemToReplace(alleles.get(position.ordinal()), newRandomPosition);
        }
        alleles.set(position.ordinal(), newAllele);
    }

    public abstract List<Allele> mutate(final List<Allele> alleles, final ItemsProvider itemsProvider);
}
