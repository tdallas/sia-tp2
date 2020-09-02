package mutations;

import ItemProvider.ItemProvider;
import ItemProvider.ItemsProvider;
import items.Item;

import java.util.List;
import java.util.Random;

public class CompleteMutation extends Mutation {
    public CompleteMutation(double probability) {
        super(probability);
    }

    @Override
    public List<Item> mutate(List<Item> gen, ItemsProvider itemsProvider) {
        return null;
    }
}
