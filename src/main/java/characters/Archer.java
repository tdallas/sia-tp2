package characters;

import items.*;

import java.util.List;

public class Archer extends Character {

    public Archer(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    @Override
    public double getPerformance() {
        List<Item> items = getItems();
        return 0.9 * getAttack(items) + 0.1 * getDefense(items);
    }
}
