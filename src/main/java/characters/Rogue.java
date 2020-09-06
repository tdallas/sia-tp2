package characters;

import alleles.items.*;

public class Rogue extends Character {
    private final double performance;

    public Rogue(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        this.performance = 0.8 * getAttack(getItems()) + 0.3 * getDefense(getItems());
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
