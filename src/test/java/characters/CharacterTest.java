package characters;

import items.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterTest {

    /**
     * Since all tests must be with full precision every assert should have a `delta = 0`
     */
    private final double DELTA = 0;
    private final Weapon weapon = new Weapon(1d, 1d, 1d, 5d, 1d,10d);
    private final Chest chest = new Chest(1d, 1d, 1d, 5d, 1d,10d);
    private final Helmet helmet = new Helmet(1d, 1d, 1d, 5d, 1d,10d);
    private final Gloves gloves = new Gloves(1d, 1d, 1d, 5d, 1d,10d);
    private final Boots boots = new Boots(1d, 1d, 1d, 5d, 1d,10d);

    /**
     * If height is 1.5 => ATM = 1.2625
     */
    @Test
    public void calculateATMTest() {
        // I choose any character, a warrior for example
        Warrior warrior = new Warrior(1.5);
        assertEquals("ATM Should be equal to 1.2625 when height is 1.5m", 1.2625, warrior.calculateATM(), 7);
    }

    /**
     * If height is 1.5 => DEM = 1.1.3101576099999999
     */
    @Test
    public void calculateDEMTest() {
        // I choose any character, a warrior for example
        Warrior warrior = new Warrior(1.5);
        // FIXME this delta is wrong
        assertEquals("DEM Should be equal to 1.3101576099999999 when height is 1.5m", 1.3101576099999999, warrior.calculateDEM(), DELTA);
    }

    @Test
    public void calculateStrengthTest(){
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Strength should be equal to 4.995837495787998", 4.995837495787998, warrior.calculateStrength(warrior.getItems()), DELTA);
    }

    @Test
    public void calculateAgilityTest(){
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Agility should be equal to 0.04995837495787998", 0.04995837495787998, warrior.calculateAgility(warrior.getItems()), DELTA);
    }

    @Test
    public void calculateVitalityTest(){
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Vitality should be equal to 46.211715726000975", 46.211715726000975, warrior.calculateVitality(warrior.getItems()), DELTA);
    }

    @Test
    public void calculateExpertiseTest(){
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Expertise should be equal to 0.029975024974727985", 0.029975024974727985, warrior.calculateExpertise(warrior.getItems()), DELTA);
    }

    @Test
    public void calculateResistanceTest(){
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Resistance should be equal to 0.24491866240370913", 0.24491866240370913, warrior.calculateResistance(warrior.getItems()), DELTA);
    }

    @Test
    public void calculateAttackTest() {
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Attack should be equal to 0.5041595241432901", 0.5041595241432901, warrior.getAttack(warrior.getItems()), DELTA);
    }

    @Test
    public void calculateDefenseTest() {
        Warrior warrior = new Warrior(1.5);
        warrior.setBoots(boots);
        warrior.setHelmet(helmet);
        warrior.setChest(chest);
        warrior.setGloves(gloves);
        warrior.setWeapon(weapon);
        assertEquals("Defense should be equal to 16.64333687468732", 16.64333687468732, warrior.getDefense(warrior.getItems()), DELTA);
    }
}
