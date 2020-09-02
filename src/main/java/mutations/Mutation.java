package mutations;

import ItemProvider.ItemsProvider;
import items.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Mutation {

    private final double probability;

    /**
     * This function assumes there is somewhere some kind of DB to get a random Item
     * @param gen : it represents the full item list (alleles)
     * @return
     */
    abstract List<Item> mutate(List<Item> gen, final ItemsProvider itemsProvider);
}
