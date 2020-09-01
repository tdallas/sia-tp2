package crossovers;

import items.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

public class SinglePointCrossoverTest {

    private final Weapon weapon = new Weapon(1, 1d, 1d, 1d, 1d, 1d);
    private final Chest chest = new Chest(1, 1d, 1d, 1d, 1d, 1d);
    private final Helmet helmet = new Helmet(1, 1d, 1d, 1d, 1d, 1d);
    private final Gloves gloves = new Gloves(1, 1d, 1d, 1d, 1d, 1d);
    private final Boots boots = new Boots(1, 1d, 1d, 1d, 1d, 1d);

    private final List<Item> dad = Arrays.asList(weapon, chest, helmet, gloves, boots);

    private final Weapon weapon2 = new Weapon(2, 2d, 2d, 2d, 2d, 2d);
    private final Chest chest2 = new Chest(2, 2d, 2d, 2d, 2d, 2d);
    private final Helmet helmet2 = new Helmet(2, 2d, 2d, 2d, 2d, 2d);
    private final Gloves gloves2 = new Gloves(2, 2d, 2d, 2d, 2d, 2d);
    private final Boots boots2 = new Boots(2, 2d, 2d, 2d, 2d, 2d);

    private final List<Item> mom = Arrays.asList(weapon2, chest2, helmet2, gloves2, boots2);

    private SinglePointCrossover singlePointCrossover;

    @Before
    public void setup() {
        singlePointCrossover = Mockito.mock(SinglePointCrossover.class);
        when(singlePointCrossover.crossover(dad, mom)).thenCallRealMethod();
        when(singlePointCrossover.getAlleles(anyListOf(Item.class), anyListOf(Item.class), anyInt())).thenCallRealMethod();
    }

    @Test
    public void singlePointCrossoverAtPosition2Test() {
        when(singlePointCrossover.getCrossoverPoint()).thenReturn(2);
        final List<List<Item>> result = singlePointCrossover.crossover(dad, mom);
        for (int i = 0; i < result.get(0).size(); i++) {
            if (i < 2) {
                assertEquals("First two alleles should be from dad",1, result.get(0).get(i).getId());
            } else {
                assertEquals("The last alleles should be from mom", 2, result.get(0).get(i).getId());
            }
        }
        for (int i = 0; i < result.get(1).size(); i++) {
            if (i < 2) {
                assertEquals("First two alleles should be from mom",2, result.get(1).get(i).getId());
            } else {
                assertEquals("The last alleles should be from dad", 1, result.get(1).get(i).getId());
            }
        }
    }
}
