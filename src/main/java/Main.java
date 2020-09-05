import ItemProvider.*;
import items.*;
import parser.ItemParser;
import parser.PropertiesParser;

import java.io.IOException;
import java.util.Properties;

public class Main {
    // handle exception
    public static void main(final String[] args) throws IOException {
        PropertiesParser propertiesParser = new PropertiesParser();
        Properties properties = propertiesParser.loadProperties();
        ItemParser itemParser = new ItemParser(properties);
        final WeaponProvider weaponProvider = new WeaponProvider(itemParser.parseItem(Weapon.class));
        final GlovesProvider glovesProvider = new GlovesProvider(itemParser.parseItem(Gloves.class));
        final BootsProvider bootsProvider = new BootsProvider(itemParser.parseItem(Boots.class));
        final ChestProvider chestProvider = new ChestProvider(itemParser.parseItem(Chest.class));
        final HelmetProvider helmetProvider = new HelmetProvider(itemParser.parseItem(Helmet.class));

        ItemsProvider itemsProvider = new ItemsProvider(bootsProvider, chestProvider, glovesProvider, weaponProvider, helmetProvider);
    }

}
