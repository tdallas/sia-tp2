package mutations;

import java.util.Random;

/**
 * Cada gen tiene una probabilidad Pm de ser mutado
 */
public class UniformMultiGenMutation extends GenMutation {
    public UniformMultiGenMutation(final double probability, final Random random) {
        super(probability, random);
    }

}
