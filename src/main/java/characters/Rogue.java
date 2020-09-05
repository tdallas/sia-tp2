package characters;

import items.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rogue extends Character {

    public Rogue(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    public Rogue(double height) {
        super(height);
    }

    @Override
    public double calculatePerformance(List<Item> items) {
        return 0.8 * getAttack(items) + 0.3 * getDefense(items);
    }
}
