package characters;

import alleles.items.*;

import java.util.List;

public class Defender extends Character {
    private final double performance;

    public Defender(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        this.performance = 0.3 * getAttack(getItems()) + 0.8 * getDefense(getItems());
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
