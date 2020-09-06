package characters;

import alleles.Allele;
import alleles.Height;
import alleles.items.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
public abstract class Character implements Comparable<Character> {
    private final Boots boots;
    private final Chest chest;
    private final Gloves gloves;
    private final Helmet helmet;
    private final Weapon weapon;
    private final Height height;
    private final List<Item> items;

    public Character(final Boots boots, final Chest chest, final Gloves gloves, final Helmet helmet, final Weapon weapon, final double height) {
        this.boots = boots;
        this.chest = chest;
        this.gloves = gloves;
        this.helmet = helmet;
        this.weapon = weapon;
        this.height = new Height(height);
        this.items = Arrays.asList(boots, chest, gloves, helmet, weapon);
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

    @Override
    public String toString() {
        return "Height: " + height.getValue() + " | Weapon: " + weapon.getId() +
                " | Chest: " + chest.getId() + " | Gloves: " + gloves.getId() +
                " | Boots: " + boots.getId() + " | Helmet: " + helmet.getId() +
                " | Fitness: " + getPerformance();
    }

    public List<Allele> getAlleles() {
        List<Allele> alleles = new ArrayList<>();
        alleles.add(height);
        alleles.addAll(getItems());
        return alleles;
    }
}
