package atributes;

import items.Item;

import java.util.List;

public class Strength extends Attribute {
    public Strength(double value) {
        super(value);
    }

    @Override
    public double evaluate(List<Item> item) {
        return item
                .parallelStream()
                .reduce(0d,
                        (aDouble, item1) -> item1.getStrength().getValue() + aDouble,
                        Double::sum);
    }
}
