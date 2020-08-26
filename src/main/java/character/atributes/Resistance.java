package character.atributes;

import items.Item;

import java.util.List;

public class Resistance extends Attribute {
    public Resistance(double value) {
        super(value);
    }

    @Override
    public double evaluate(List<Item> item) {
        return item
                .parallelStream()
                .reduce(0d,
                        (aDouble, item1) -> item1.getResistance().getValue() + aDouble,
                        Double::sum);
    }
}
