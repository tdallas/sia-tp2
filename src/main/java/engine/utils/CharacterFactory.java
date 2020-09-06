package engine.utils;

import alleles.items.*;
import characters.Character;
import characters.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CharacterFactory<T extends Character> {

    public static final String WARRIOR ="WARRIOR";
    public static final String ARCHER ="ARCHER";
    public static final String DEFENDER ="DEFENDER";
    public static final String ROGUE="ROGUE";

    final Class<T> tClass;

    public T characterSupplier(final Boots boots,
                             final Chest chest,
                             final Gloves gloves,
                             final Helmet helmet,
                             final Weapon weapon,
                             final double height) {
        if (tClass == Archer.class) {
            return (T) new Archer(boots, chest, gloves, helmet, weapon, height);
        } else if (tClass == Defender.class) {
            return (T) new Defender(boots, chest, gloves, helmet, weapon, height);
        } else if (tClass == Rogue.class) {
            return (T) new Rogue(boots, chest, gloves, helmet, weapon, height);
        } else {
            return (T) new Warrior(boots, chest, gloves, helmet, weapon, height);
        }
    }

}
