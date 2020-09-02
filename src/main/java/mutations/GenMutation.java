package mutations;

import ItemProvider.ItemsProvider;
import items.Item;

import java.util.List;
import java.util.Random;

public class GenMutation extends Mutation {

    public GenMutation(double probability) {
        super(probability);
    }

    @Override
    List<Item> mutate(List<Item> gen, ItemsProvider itemsProvider) {
        if (new Random().nextDouble() < getProbability()) {
            int positionToReplace = new Random().nextInt(gen.size());
            int randomPosition = new Random().nextInt(ItemsProvider.MAX_ITEMS);
            gen.set(positionToReplace, itemsProvider.getItemToReplace(gen.get(positionToReplace), randomPosition));
        }
        return gen;
    }
}
