package cutConditions;

import alleles.items.*;
import characters.Archer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContentCutConditionTest {
    @Test
    public void contentCutConditionTest() {
        Weapon weapon = new Weapon(1, 1d, 1d, 1d, 1d, 1d);
        Chest chest = new Chest(1, 1d, 1d, 1d, 1d, 1d);
        Helmet helmet = new Helmet(1, 1d, 1d, 1d, 1d, 1d);
        Gloves gloves = new Gloves(1, 1d, 1d, 1d, 1d, 1d);
        Boots boots = new Boots(1, 1d, 1d, 1d, 1d, 1d);
        Archer bestCharacter = new Archer(boots, chest, gloves, helmet, weapon, 1.5);

        CutCondition cutCondition = new ContentCutCondition(5);
        assertFalse(cutCondition.cutReached(null, bestCharacter));
        assertFalse(cutCondition.cutReached(null, bestCharacter));
        assertFalse(cutCondition.cutReached(null, bestCharacter));
        assertFalse(cutCondition.cutReached(null, bestCharacter));
        assertTrue(cutCondition.cutReached(null, bestCharacter));
    }
}
