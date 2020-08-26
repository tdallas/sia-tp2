package items;

import character.atributes.*;
import lombok.Getter;

@Getter
public abstract class Item {
    private final Agility agility;
    private final Expertise expertise;
    private final Resistance resistance;
    private final Strength strength;
    private final Vitality vitality;

    public Item(Agility agility, Expertise expertise, Resistance resistance, Strength strength, Vitality vitality) {
        this.agility = agility;
        this.expertise = expertise;
        this.resistance = resistance;
        this.strength = strength;
        this.vitality = vitality;
    }
}
