package characters;

import alleles.items.*;

public class Warrior extends Character {
    private final double performance;

    public Warrior(final Boots boots, final Chest chest, final Gloves gloves, final Helmet helmet, final Weapon weapon, final double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        this.performance = 0.6 * getAttack(getItems()) + 0.6 * getDefense(getItems());
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
