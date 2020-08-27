package character;

import items.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Defender extends Character {
    public Defender(double height) {
        super(height);
    }

    @Override
    public double calculatePerformance(List<Item> items) {
        return 0.3 * getAttack(items) + 0.8 * getDefense(items);
    }
}
