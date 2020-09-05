package items;

import atributes.*;
import com.univocity.parsers.annotations.Parsed;
import mutations.Allele;

import java.util.Objects;

public abstract class Item implements Allele {
    @Parsed(field = "id")
    private final long id;
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

    public Item(final long id, final Agility agility, final Expertise expertise,
                final Resistance resistance, final Strength strength, final Vitality vitality) {
        this.id = id;
        this.agility = agility;
        this.expertise = expertise;
        this.resistance = resistance;
        this.strength = strength;
        this.vitality = vitality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(agility, item.agility) &&
                Objects.equals(expertise, item.expertise) &&
                Objects.equals(resistance, item.resistance) &&
                Objects.equals(strength, item.strength) &&
                Objects.equals(vitality, item.vitality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agility, expertise, resistance, strength, vitality);
    }

    public double getAgility() {
        return agility.getValue();
    }

    public double getExpertise() {
        return expertise.getValue();
    }

    public double getResistance() {
        return resistance.getValue();
    }

    public double getStrength() {
        return strength.getValue();
    }

    public double getVitality() {
        return vitality.getValue();
    }

    public long getId() {
        return id;
    }
}
