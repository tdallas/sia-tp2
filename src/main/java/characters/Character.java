package characters;

import alleles.Height;
import alleles.items.*;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Setter
public abstract class Character implements Comparable<Character>{
    private Boots boots;
    private Chest chest;
    private Gloves gloves;
    private Helmet helmet;
    private Weapon weapon;
    private Height height;

    public Character(final Boots boots, final Chest chest, final Gloves gloves, final Helmet helmet, final Weapon weapon, final double height) {
        this.boots = boots;
        this.chest = chest;
        this.gloves = gloves;
        this.helmet = helmet;
        this.weapon = weapon;
        this.height = new Height(height);
    }

    public double getHeight() {
        return height.getValue();
    }

    protected double calculateATM() {
        final double midTerm = (3 * getHeight() - 5);
        return 0.7 - Math.pow(midTerm, 4) + Math.pow(midTerm, 2) + (getHeight() / 4);
    }

    protected double calculateDEM() {
        final double midTerm = (2.5 * getHeight() - 4.16);
        return 1.9 + Math.pow(midTerm, 4) - Math.pow(midTerm, 2) - (3 * getHeight() / 10);
    }

    public List<Item> getItems() {
        return Arrays.asList(boots, chest, gloves, helmet, weapon);
    }

    protected double calculateStrength(final List<Item> items) {
        return 100 * Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getStrength() + aDouble,
                Double::sum));
    }

    protected double calculateAgility(final List<Item> items) {
        return Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getAgility() + aDouble,
                Double::sum));
    }

    protected double calculateExpertise(final List<Item> items) {
        return 0.6 * Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getExpertise() + aDouble,
                Double::sum));
    }

    protected double calculateResistance(final List<Item> items) {
        return Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getResistance() + aDouble,
                Double::sum));
    }

    protected double calculateVitality(final List<Item> items) {
        return 100 * Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getVitality() + aDouble,
                Double::sum));
    }

    public double getAttack(final List<Item> items) {
        return (calculateAgility(items) + calculateExpertise(items)) * calculateStrength(items) * calculateATM();
    }

    public double getDefense(final List<Item> items) {
        return (calculateResistance(items) + calculateExpertise(items)) * calculateVitality(items) * calculateDEM();
    }

    public abstract double getPerformance();

    public Boots getBoots() {
        return boots;
    }

    public Chest getChest() {
        return chest;
    }

    public Gloves getGloves() {
        return gloves;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(boots, character.boots) &&
                Objects.equals(chest, character.chest) &&
                Objects.equals(gloves, character.gloves) &&
                Objects.equals(helmet, character.helmet) &&
                Objects.equals(weapon, character.weapon) &&
                Objects.equals(height, character.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boots, chest, gloves, helmet, weapon, height);
    }

    @Override
    public int compareTo(Character character) {
        double diff = this.getPerformance() - character.getPerformance();

        if (diff < 0) {
            return -1;
        } else if (diff > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
