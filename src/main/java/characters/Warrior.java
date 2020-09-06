package characters;

import alleles.items.*;

import java.util.List;

public class Warrior extends Character {

    public Warrior(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    @Override
    public double getPerformance() {
        List<Item> items = getItems();
        return 0.6 * getAttack(items) + 0.6 * getDefense(items);
    }
}
