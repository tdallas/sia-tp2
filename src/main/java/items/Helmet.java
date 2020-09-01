package items;

import atributes.*;

public class Helmet extends Item {
    public Helmet(final long id, final double agility, final double expertise,
                  final double resistance, final double strength, final double vitality) {
        super(id, new Agility(agility), new Expertise(expertise), new Resistance(resistance),
                new Strength(strength), new Vitality(vitality));
    }
}
