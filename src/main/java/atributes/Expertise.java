package atributes;

import items.Item;

import java.util.List;

public class Expertise extends Attribute {

    public Expertise(double value) {
        super(value);
    }

    @Override
    public double evaluate(List<Item> item) {
        return item
                .parallelStream()
                .reduce(0d,
                        (aDouble, item1) -> item1.getExpertise().getValue() + aDouble,
                        Double::sum);
    }
}
