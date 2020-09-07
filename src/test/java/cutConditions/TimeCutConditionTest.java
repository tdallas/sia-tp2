package cutConditions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TimeCutConditionTest {

    @Test
    public void eliteSelectionTest() throws InterruptedException {
        CutCondition cutCondition = new TimeCutCondition(1000);
        assertFalse(cutCondition.cutReached(null, null));
        Thread.sleep(1000);
        assertTrue(cutCondition.cutReached(null, null));
    }
}
