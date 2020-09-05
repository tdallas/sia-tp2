package mutations;

import java.util.Random;

/**
 * Se selecciona una cantidad azarosa [1, M] de genes para mutar, con probabilidad Pm (todos? cada uno?)
 */
public class LimitedMultiGenMutation extends GenMutation {

    public LimitedMultiGenMutation(final Random random) {
        super( random);
    }

}
