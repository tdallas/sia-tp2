package ItemProvider;


import items.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemsProvider {
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


}
