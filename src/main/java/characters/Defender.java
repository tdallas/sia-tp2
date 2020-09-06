package characters;

import items.*;

import java.util.List;

public class Defender extends Character {

    public Defender(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    public Defender(double height) {
        super(height);
    }

    @Override
    public double getPerformance() {
        List<Item> items = getItems();
        return 0.3 * getAttack(items) + 0.8 * getDefense(items);
    }
}
