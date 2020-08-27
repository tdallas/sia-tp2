package character;

import items.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public abstract class Character {
    private Boots boots;
    private Chest chest;
    private Gloves gloves;
    private Helmet helmet;
    private Weapon weapon;
    private final double height;

    // We assume height is already validated
    public Character(final double height) {
        this.height = height;
    }

    private double calculateATM() {
        final double midTerm = (3 * height - 5);
        return 0.7 - Math.pow(midTerm, 4) + Math.pow(midTerm, 2) + (height / 4);
    }

    private double calculateDEM() {
        final double midTerm = (2.5 * height - 4.16);
        return 1.9 + Math.pow(midTerm, 4) - Math.pow(midTerm, 2) - (3 * height / 10);
    }

    private List<Item> getItems() {
        return Arrays.asList(boots, chest, gloves, helmet, weapon);
    }

    private static double calculateStrength(final List<Item> items) {
        return 100 * Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getStrength().getValue() + aDouble,
                Double::sum));
    }

    private double calculateAgility(final List<Item> items) {
        return Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getAgility().getValue() + aDouble,
                Double::sum));
    }

    private double calculateExpertise(final List<Item> items) {
        return 0.6 * Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getExpertise().getValue() + aDouble,
                Double::sum));
    }

    private double calculateResistance(final List<Item> items) {
        return Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getResistance().getValue() + aDouble,
                Double::sum));
    }

    private double calculateVitality(final List<Item> items) {
        return 100 * Math.tanh(0.01 * items.stream().reduce(0d,
                (aDouble, item1) -> item1.getVitality().getValue() + aDouble,
                Double::sum));
    }

    public double getAttack(final List<Item> items) {
        return (calculateAgility(items) + calculateExpertise(items)) * calculateStrength(items) * calculateATM();
    }

    public double getDefense(final List<Item> items) {
        return (calculateResistance(items) + calculateExpertise(items)) * calculateVitality(items) * calculateDEM();
    }

    public abstract double calculatePerformance(final List<Item> items);

}
