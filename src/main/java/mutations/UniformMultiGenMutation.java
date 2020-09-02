package mutations;

import ItemProvider.ItemsProvider;
import items.Item;

import java.util.List;

public class UniformMultiGenMutation extends Mutation {
    public UniformMultiGenMutation(double probability) {
        super(probability);
    }

    @Override
    List<Item> mutate(List<Item> gen, ItemsProvider itemsProvider) {
        return null;
    }
}
