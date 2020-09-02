package mutations;

import ItemProvider.ItemsProvider;
import items.Item;

import java.util.List;
import java.util.Random;

public class LimitedMultiGenMutation extends Mutation {

    public LimitedMultiGenMutation(double probability) {
        super(probability);
    }

    @Override
    public List<Item> mutate(List<Item> gen, ItemsProvider itemsProvider) {
        return null;
    }
}
