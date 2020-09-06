package characters;

import alleles.items.*;

public class Archer extends Character {
    private final double performance;

    public Archer(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        this.performance = 0.9 * getAttack(getItems()) + 0.1 * getDefense(getItems());
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
