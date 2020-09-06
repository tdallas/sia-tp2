package mutations;

import ItemProvider.ItemsProvider;
import alleles.Allele;
import alleles.AlleleType;
import alleles.Height;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class GenMutation {
    //FIXME this should be config field
    private final int MAX_ITEMS = 10000;

    private final Random random;

    public GenMutation(final Random random) {
        this.random = random;
    }

    protected void mutateAtPosition(final AlleleType position, final List<Allele> alleles, final ItemsProvider itemsProvider) {
        Allele newAllele = null;
        int newRandomPosition = random.nextInt(MAX_ITEMS);
        if (position == AlleleType.HEIGHT) {
            newAllele = new Height(Height.MIN_HEIGHT + random.nextDouble() * (Height.MAX_HEIGHT - Height.MIN_HEIGHT));
        } else {
            newAllele = itemsProvider.getItemToReplace(alleles.get(position.ordinal()), newRandomPosition);
        }
        alleles.set(position.ordinal(), newAllele);
    }
}
