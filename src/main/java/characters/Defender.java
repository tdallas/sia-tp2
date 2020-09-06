package characters;

import items.*;

import java.util.List;

public class Defender extends Character {

    private double performance;

    public Defender(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
        List<Item> items = getItems();
        this.performance = 0.3 * getAttack(items) + 0.8 * getDefense(items);
    }

    public Defender(double height) {
        super(height);
    }

    @Override
    public double getPerformance() {
        return performance;
    }
}
