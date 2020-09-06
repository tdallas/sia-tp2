package alleles.items;

import alleles.Allele;

import java.util.Objects;

public abstract class Item implements Allele {

    private final long id;
    private final double agility;
    private final double expertise;
    private final double resistance;
    private final double strength;
    private final double vitality;

    public Item(final long id, final double agility, final double expertise,
                final double resistance, final double strength, final double vitality) {
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
                Double.compare(item.agility, agility) == 0 &&
                Double.compare(item.expertise, expertise) == 0 &&
                Double.compare(item.resistance, resistance) == 0 &&
                Double.compare(item.strength, strength) == 0 &&
                Double.compare(item.vitality, vitality) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agility, expertise, resistance, strength, vitality);
    }

    @Override
    public String toString() {
        return getClass() + ": Id=" + id;
    }

    public double getAgility() {
        return agility;
    }

    public double getExpertise() {
        return expertise;
    }

    public double getResistance() {
        return resistance;
    }

    public double getStrength() {
        return strength;
    }

    public double getVitality() {
        return vitality;
    }

    public long getId() {
        return id;
    }
}
