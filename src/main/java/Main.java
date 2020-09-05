import ItemProvider.*;
import items.*;
import parser.ItemParser;

public class Main {
    public static void main(final String[] args) {
        final WeaponProvider weaponProvider = new WeaponProvider(ItemParser.parseItem(Weapon.class));
        final GlovesProvider glovesProvider = new GlovesProvider(ItemParser.parseItem(Gloves.class));
        final BootsProvider bootsProvider = new BootsProvider(ItemParser.parseItem(Boots.class));
        final ChestProvider chestProvider = new ChestProvider(ItemParser.parseItem(Chest.class));
        final HelmetProvider helmetProvider = new HelmetProvider(ItemParser.parseItem(Helmet.class));

        ItemsProvider itemsProvider = new ItemsProvider(bootsProvider, chestProvider, glovesProvider, weaponProvider, helmetProvider);
    }
}
