package mutations;

import items.Item;

import java.util.List;

public abstract class Mutation {
    /**
     * This function assumes there is somewhere some kind of DB to get a random Item
     * @param gen : it represents the full item list (allels)
     * @return
     */
    abstract List<Item> mutate(final List<Item> gen);
}
