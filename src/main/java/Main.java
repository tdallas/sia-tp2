import items.*;
import parser.ItemParser;

import java.util.List;

public class Main {
    public static void main(final String[] args) {
        List<Weapon> weapons = ItemParser.parseItem(Weapon.class);
        System.out.printf("Weapons size %d\n", weapons.size());
        List<Gloves> gloves = ItemParser.parseItem(Gloves.class);
        System.out.printf("Gloves size %d\n", gloves.size());
        List<Boots> boots = ItemParser.parseItem(Boots.class);
        System.out.printf("Boots size %d\n", boots.size());
        List<Chest> chest = ItemParser.parseItem(Chest.class);
        System.out.printf("Chest size %d\n", chest.size());
        List<Helmet> helmet = ItemParser.parseItem(Helmet.class);
        System.out.printf("Helmet size %d\n", helmet.size());
    }
}
