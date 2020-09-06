package mutations;

import ItemProvider.*;
import alleles.Allele;
import alleles.Height;
import alleles.items.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import parser.ItemParser;
import parser.PropertiesParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LimitedMultiGenMutationTest {

    private final Weapon weapon = new Weapon(1, 1d, 1d, 1d, 1d, 1d);
    private final Chest chest = new Chest(1, 1d, 1d, 1d, 1d, 1d);
    private final Helmet helmet = new Helmet(1, 1d, 1d, 1d, 1d, 1d);
    private final Gloves gloves = new Gloves(1, 1d, 1d, 1d, 1d, 1d);
    private final Boots boots = new Boots(1, 1d, 1d, 1d, 1d, 1d);

    private final List<Allele> dad = Arrays.asList(new Height(1.6d), boots, chest, gloves, helmet, weapon);

    private ItemsProvider itemsProvider;
    private LimitedMultiGenMutation limitedMultiGenMutation;

    @Before
    public void setup() throws IOException {
        ItemParser itemParser = new ItemParser(new PropertiesParser().loadProperties(), 50);
        itemsProvider = new ItemsProvider(
                50,
                new BootsProvider(itemParser.parseItem(Boots.class)),
                new ChestProvider(itemParser.parseItem(Chest.class)),
                new GlovesProvider(itemParser.parseItem(Gloves.class)),
                new WeaponProvider(itemParser.parseItem(Weapon.class)),
                new HelmetProvider(itemParser.parseItem(Helmet.class))
        );
        Random random = mock(Random.class);
        Mockito.when(random.nextDouble())
                .thenReturn(0.3)
                .thenReturn(1d) // height will be MAX_HEIGHT
                .thenReturn(0.3)
                .thenReturn(0.6)
                .thenReturn(0.3)
                .thenReturn(0.7)
                .thenReturn(0.7);
        // this will mutate height, boots and chest,but probability will only mutate height and boots
        Mockito.when(random.nextInt(6)).thenReturn(3);
        Mockito.when(random.nextInt(50)).thenReturn(10);
        // This will only mutate height and chest
        limitedMultiGenMutation = new LimitedMultiGenMutation(0.5 , random);
    }

    @Test
    public void limitedMultiGenMutateOnlyHeightAndChest() {
        List<Allele> mutatedAlleles = limitedMultiGenMutation.mutate(dad, itemsProvider);
        assertEquals("Height should be mutated and be MAX_HEIGHT", 2d, ((Height) mutatedAlleles.get(0)).getValue(), 0);
        assertEquals("Boots should have mutated", 10, ((Item) mutatedAlleles.get(1)).getId());
        assertEquals("Chest should remain the same", 1, ((Item) mutatedAlleles.get(2)).getId());
        assertEquals("Gloves should have mutated", 10, ((Item) mutatedAlleles.get(3)).getId());
        assertEquals("Helmet should remain the same", 1, ((Item) mutatedAlleles.get(4)).getId());
        assertEquals("Weapon should remain the same", 1, ((Item) mutatedAlleles.get(5)).getId());
    }
}
