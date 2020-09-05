package mutations;

import ItemProvider.ItemsProvider;
import atributes.Height;
import items.Boots;

import java.util.List;
import java.util.Random;

public class GenMutation {
    //FIXME this should be config field
    private final int MAX_ITEMS = 10000;

    private final Random random;

    public GenMutation(final Random random) {
        this.random = random;
    }

    protected List<Allele> mutateAtPosition(final AlleleType position, final List<Allele> alleles, final ItemsProvider itemsProvider) {
        Allele newAllele = null;
        int newRandomPosition = random.nextInt(MAX_ITEMS);
        if (position == AlleleType.HEIGHT) {
            newAllele = new Height(1.3 + random.nextDouble() * (2 - 1.3));
        } else {
            newAllele = itemsProvider.getItemToReplace(alleles.get(position.ordinal()), newRandomPosition);
        }
        alleles.set(position.ordinal(), newAllele);
        return alleles;
    }
}
