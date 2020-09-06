package ItemProvider;

import alleles.items.Item;

public abstract class ItemProvider<T extends Item> {

    public abstract T provideItem(final int position);
}
