package characters;

import items.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Warrior extends Character {

    public Warrior(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    public Warrior(double height) {
        super(height);
    }

    @Override
    public double calculatePerformance(final List<Item> items) {
        return 0.6 * getAttack(items) + 0.6 * getDefense(items);
    }
}
