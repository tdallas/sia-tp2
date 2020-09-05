package characters;

import items.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Archer extends Character {

    public Archer(Boots boots, Chest chest, Gloves gloves, Helmet helmet, Weapon weapon, double height) {
        super(boots, chest, gloves, helmet, weapon, height);
    }

    public Archer(double height) {
        super(height);
    }

    @Override
    public double calculatePerformance(List<Item> items) {
        return 0.9 * getAttack(items) + 0.1 * getDefense(items);
    }
}
