package ItemProvider;


import items.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemsProvider {

    public static final int MAX_ITEMS = 10000;

    private final BootsProvider bootsProvider;
    private final ChestProvider chestProvider;
    private final GlovesProvider glovesProvider;
    private final WeaponProvider weaponProvider;
    private final HelmetProvider helmetProvider;

    private Gloves getGloves(final int position) { return glovesProvider.provideItem(position);}
    private Boots getBoots(final int position) { return bootsProvider.provideItem(position);}
    private Helmet getHelmet(final int position) { return helmetProvider.provideItem(position);}
    private Chest getChest(final int position) { return chestProvider.provideItem(position);}
    private Weapon getWeapon(final int position) { return weaponProvider.provideItem(position);}

    public Item getItemToReplace(final Item item, final int position) {
        if (item instanceof Gloves) {
            return getGloves(position);
        } else if (item instanceof Chest) {
            return getChest(position);
        } else if (item instanceof Boots) {
            return getBoots(position);
        } else if (item instanceof  Helmet) {
            return getHelmet(position);
        } else {
            return getWeapon(position);
        }
    }

}
