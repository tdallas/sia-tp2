package characters;

import items.*;

import java.util.List;

public class Archer extends Character {

    private double performance;

    public Archer(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        List<Item> items = getItems();
        this.performance = 0.9 * getAttack(items) + 0.1 * getDefense(items);
    }

    public Archer(double height) {
        super(height);
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
