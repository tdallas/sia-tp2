package cutConditions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenerationCutConditionTest {
    @Test
    public void generationCutConditionTest() {
        CutCondition cutCondition = new GenerationCutCondition(5);
        assertFalse(cutCondition.cutReached(null, null));
        assertFalse(cutCondition.cutReached(null, null));
        assertFalse(cutCondition.cutReached(null, null));
        assertFalse(cutCondition.cutReached(null, null));
        assertTrue(cutCondition.cutReached(null, null));
    }
}
