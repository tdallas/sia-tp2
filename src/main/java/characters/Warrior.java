package characters;

import items.*;

import java.util.List;

public class Warrior extends Character {

    private double performance;

    public Warrior(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        List<Item> items = getItems();
        this.performance = 0.6 * getAttack(items) + 0.6 * getDefense(items);
    }

    public Warrior(double height) {
        super(height);
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
