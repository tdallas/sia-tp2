package atributes;

import items.Item;

import java.util.List;

public class Agility extends Attribute {

    public Agility(double value) {
        super(value);
    }

    @Override
    public double evaluate(List<Item> item) {
        return item
                .parallelStream()
                .reduce(0d,
                        (aDouble, item1) -> item1.getAgility().getValue() + aDouble,
                        Double::sum);
    }
}
