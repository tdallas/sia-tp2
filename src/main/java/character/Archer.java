package character;

import items.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Archer extends Character {
    public Archer(double height) {
        super(height);
    }

    @Override
    public double calculatePerformance(List<Item> items) {
        return 0.9 * getAttack(items) + 0.1 * getDefense(items);
    }
}
