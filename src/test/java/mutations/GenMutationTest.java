package mutations;

import ItemProvider.*;
import alleles.Allele;
import alleles.Height;
import alleles.items.*;
import org.junit.Before;
import org.junit.Test;
import parser.ItemParser;
import parser.PropertiesParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GenMutationTest {


    private final Weapon weapon = new Weapon(1, 1d, 1d, 1d, 1d, 1d);
    private final Chest chest = new Chest(1, 1d, 1d, 1d, 1d, 1d);
    private final Helmet helmet = new Helmet(1, 1d, 1d, 1d, 1d, 1d);
    private final Gloves gloves = new Gloves(1, 1d, 1d, 1d, 1d, 1d);
    private final Boots boots = new Boots(1, 1d, 1d, 1d, 1d, 1d);

    private final List<Allele> dad = Arrays.asList(new Height(1.6d), weapon, chest, helmet, gloves, boots);

    private ItemsProvider itemsProvider;

    @Before
    public void setup() throws IOException {
        ItemParser itemParser = new ItemParser(new PropertiesParser().loadProperties(), 50);
        itemsProvider = new ItemsProvider(
                new BootsProvider(itemParser.parseItem(Boots.class)),
                new ChestProvider(itemParser.parseItem(Chest.class)),
                new GlovesProvider(itemParser.parseItem(Gloves.class)),
                new WeaponProvider(itemParser.parseItem(Weapon.class)),
                new HelmetProvider(itemParser.parseItem(Helmet.class))
        );
    }


    @Test
    public void testGenMutationAtPosition() {

    }
}
