package selections;

import characters.Archer;
import characters.Character;
import items.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BoltzmannSelectionMethodTest {
    private final Weapon weapon = new Weapon(1, 1d, 1d, 1d, 1d, 1d);
    private final Chest chest = new Chest(1, 1d, 1d, 1d, 1d, 1d);
    private final Helmet helmet = new Helmet(1, 1d, 1d, 1d, 1d, 1d);
    private final Gloves gloves = new Gloves(1, 1d, 1d, 1d, 1d, 1d);
    private final Boots boots = new Boots(1, 1d, 1d, 1d, 1d, 1d);

    private final Archer c1 = new Archer(boots, chest, gloves, helmet, weapon, 1.5);

    private final Weapon weapon2 = new Weapon(2, 2d, 2d, 2d, 2d, 2d);
    private final Chest chest2 = new Chest(2, 2d, 2d, 2d, 2d, 2d);
    private final Helmet helmet2 = new Helmet(2, 2d, 2d, 2d, 2d, 2d);
    private final Gloves gloves2 = new Gloves(2, 2d, 2d, 2d, 2d, 2d);
    private final Boots boots2 = new Boots(2, 2d, 2d, 2d, 2d, 2d);

    private final Archer c2 = new Archer(boots2, chest2, gloves2, helmet2, weapon2, 1.5);

    private final Weapon weapon3 = new Weapon(3, 3d, 3d, 3d, 3d, 3d);
    private final Chest chest3 = new Chest(3, 3d, 3d, 3d, 3d, 3d);
    private final Helmet helmet3 = new Helmet(3, 3d, 3d, 3d, 3d, 3d);
    private final Gloves gloves3 = new Gloves(3, 3d, 3d, 3d, 3d, 3d);
    private final Boots boots3 = new Boots(3, 3d, 3d, 3d, 3d, 3d);

    private final Archer c3 = new Archer(boots3, chest3, gloves3, helmet3, weapon3, 1.5);

    private final Weapon weapon4 = new Weapon(4, 4d, 4d, 4d, 4d, 4d);
    private final Chest chest4 = new Chest(4, 4d, 4d, 4d, 4d, 4d);
    private final Helmet helmet4 = new Helmet(4, 4d, 4d, 4d, 4d, 4d);
    private final Gloves gloves4 = new Gloves(4, 4d, 4d, 4d, 4d, 4d);
    private final Boots boots4 = new Boots(4, 4d, 4d, 4d, 4d, 4d);

    private final Archer c4 = new Archer(boots4, chest4, gloves4, helmet4, weapon4, 1.5);


    @Test
    public void singlePointCrossoverAtPosition2Test() {
        BoltzmannSelectionMethod boltzmannSelectionMethod = new BoltzmannSelectionMethod(1, new Random(), 10);
        List<Character> population = Arrays.asList(c1, c2, c3, c4);
        List<Character> selected = boltzmannSelectionMethod.select(population, 2);
        System.out.println("asd");
    }
}
