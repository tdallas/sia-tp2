package character.atributes;


import items.Item;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class Attribute {
    private final double value;

    public Attribute(final double value) {
        this.value = value;
    }

    public abstract double evaluate(final List<Item> item);
}
