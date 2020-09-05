package mutations;

import java.util.Random;

/**
 * Con una probabilidad Pm se mutan todos los alelos acorde a al funcion asociada a cada alelo
 */
public class CompleteMutation extends GenMutation {
    public CompleteMutation(final double probability, final Random random) {
        super(probability, random);
    }

}
