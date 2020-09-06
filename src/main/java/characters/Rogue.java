package characters;

import items.*;

import java.util.List;


public class Rogue extends Character {

    private double performance;

    public Rogue(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        List<Item> items = getItems();
        this.performance = 0.8 * getAttack(items) + 0.3 * getDefense(items);
    }

    public Rogue(double height) {
        super(height);
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
