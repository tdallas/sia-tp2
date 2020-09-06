package characters;

import items.*;

import java.util.List;

public class Rogue extends Character {

    public Rogue(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    @Override
    public double getPerformance() {
        List<Item> items = getItems();
        return 0.8 * getAttack(items) + 0.3 * getDefense(items);
    }
}
