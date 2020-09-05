package crossovers;

import atributes.Height;
import items.*;
import mutations.Allele;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

public class SinglePointCrossoverTest {

    private final Weapon weapon = new Weapon(1, 1d, 1d, 1d, 1d, 1d);
    private final Chest chest = new Chest(1, 1d, 1d, 1d, 1d, 1d);
    private final Helmet helmet = new Helmet(1, 1d, 1d, 1d, 1d, 1d);
    private final Gloves gloves = new Gloves(1, 1d, 1d, 1d, 1d, 1d);
    private final Boots boots = new Boots(1, 1d, 1d, 1d, 1d, 1d);

    private final List<Allele> dad = Arrays.asList(new Height(1.6d), weapon, chest, helmet, gloves, boots);

    private final Weapon weapon2 = new Weapon(2, 2d, 2d, 2d, 2d, 2d);
    private final Chest chest2 = new Chest(2, 2d, 2d, 2d, 2d, 2d);
    private final Helmet helmet2 = new Helmet(2, 2d, 2d, 2d, 2d, 2d);
    private final Gloves gloves2 = new Gloves(2, 2d, 2d, 2d, 2d, 2d);
    private final Boots boots2 = new Boots(2, 2d, 2d, 2d, 2d, 2d);

    private final List<Allele> mom = Arrays.asList(new Height(1.5d), weapon2, chest2, helmet2, gloves2, boots2);

    private SinglePointCrossover singlePointCrossover;

    @Before
    public void setup() {
        singlePointCrossover = Mockito.mock(SinglePointCrossover.class);
        when(singlePointCrossover.crossover(dad, mom)).thenCallRealMethod();
        when(singlePointCrossover.getAlleles(anyListOf(Allele.class), anyListOf(Allele.class), anyInt())).thenCallRealMethod();
    }

    @Test
    public void singlePointCrossoverAtPosition2Test() {
        when(singlePointCrossover.getCrossoverPoint()).thenReturn(3);
        final List<List<Allele>> result = singlePointCrossover.crossover(dad, mom);
        for (int i = 0; i < result.get(0).size(); i++) {
            if (i == 0) {
                assertEquals("Height should be from dad", 1.6d, ((Height) result.get(0).get(i)).getValue(), 0);
            } else if (i <= 2) {
                assertEquals("First two items alleles should be from dad", 1, ((Item) result.get(0).get(i)).getId());
            } else {
                assertEquals("The last alleles should be from mom", 2, ((Item) result.get(0).get(i)).getId());
            }
        }
        for (int i = 0; i < result.get(1).size(); i++) {
            if (i == 0) {
                assertEquals("Height should be from mom", 1.5d, ((Height) result.get(1).get(i)).getValue(), 0);
            } else if (i <= 2) {
                assertEquals("First two items alleles should be from mom", 2, ((Item) result.get(1).get(i)).getId());
            } else {
                assertEquals("The last alleles should be from dad", 1, ((Item) result.get(1).get(i)).getId());
            }
        }
    }
}
