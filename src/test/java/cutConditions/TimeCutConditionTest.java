package cutConditions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimeCutConditionTest {
    @Test
    public void timeCutConditionTest() throws InterruptedException {
        CutCondition cutCondition = new TimeCutCondition(1000);
        assertFalse(cutCondition.cutReached(null, null));
        Thread.sleep(1000);
        assertTrue(cutCondition.cutReached(null, null));
    }
}
