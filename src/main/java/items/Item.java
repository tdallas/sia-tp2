package items;

import atributes.*;
import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;

@Getter
public abstract class Item {
    @Parsed(field = "id")
    private final double id;
    @Parsed(field = "Ag")
    private final Agility agility;
    @Parsed(field = "Ex")
    private final Expertise expertise;
    @Parsed(field = "Re")
    private final Resistance resistance;
    @Parsed(field = "Fu")
    private final Strength strength;
    @Parsed(field = "Vi")
    private final Vitality vitality;

    public Item(final double id, final Agility agility, final Expertise expertise,
                final Resistance resistance, final Strength strength, final Vitality vitality) {
        this.id = id;
        this.agility = agility;
        this.expertise = expertise;
        this.resistance = resistance;
        this.strength = strength;
        this.vitality = vitality;
    }
}
