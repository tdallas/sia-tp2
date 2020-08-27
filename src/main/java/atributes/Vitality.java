package atributes;

import items.Item;

import java.util.List;

public class Vitality extends Attribute {
    public Vitality(double value) {
        super(value);
    }

    @Override
    public double evaluate(List<Item> item) {
        return item
                .parallelStream()
                .reduce(0d,
                        (aDouble, item1) -> item1.getVitality().getValue() + aDouble,
                        Double::sum);
    }
}
