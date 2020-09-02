package parser;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import items.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemParser {

    private static final String weaponPath = "/home/tomas/fulldata/armas.tsv";
    private static final String bootPath = "/home/tomas/fulldata/botas.tsv";
    private static final String helmetPath = "/home/tomas/fulldata/cascos.tsv";
    private static final String glovesPath = "/home/tomas/fulldata/guantes.tsv";
    private static final String chestPath = "/home/tomas/fulldata/pecheras.tsv";

    private static final Map<Class<? extends Item>, String> classToPath = Map.of(
            Weapon.class, weaponPath,
            Boots.class, bootPath,
            Helmet.class, helmetPath,
            Gloves.class, glovesPath,
            Chest.class, chestPath
    );

    public static <T extends Item> List<T> parseItem(final Class<T> itemClass) {
        File weaponFile = new File(classToPath.get(itemClass));
        TsvParserSettings parserSettings = new TsvParserSettings();
        parserSettings.setHeaderExtractionEnabled(true);
        // csvHeader:   id      Fu      Ag      Ex      Re      Vi
        TsvParser parser = new TsvParser(parserSettings);
        List<T> items = new ArrayList<>();
        parser.parseAll(weaponFile).forEach(line -> items.add(getInstance(line, itemClass)));
        return items;
    }

    // FIXME This is NEFASTO
    // Find a way to pass a constructor as parameter and built a map
    private static <T extends Item> T getInstance(String[] line, Class<T> itemClass) {
        if (itemClass.equals(Weapon.class)) {
            return (T) new Weapon(
                    Integer.parseInt(line[0]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3]),
                    Double.parseDouble(line[4]),
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[5])
            );
        } else if (itemClass.equals(Gloves.class)) {
            return (T) new Gloves(
                    Integer.parseInt(line[0]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3]),
                    Double.parseDouble(line[4]),
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[5])
            );
        } else if (itemClass.equals(Helmet.class)) {
            return (T) new Helmet(
                    Integer.parseInt(line[0]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3]),
                    Double.parseDouble(line[4]),
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[5])
            );
        } else if (itemClass.equals(Chest.class)) {
            return (T) new Chest(
                    Integer.parseInt(line[0]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3]),
                    Double.parseDouble(line[4]),
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[5])
            );
        } else {
            return (T) new Boots(
                    Integer.parseInt(line[0]),
                    Double.parseDouble(line[2]),
                    Double.parseDouble(line[3]),
                    Double.parseDouble(line[4]),
                    Double.parseDouble(line[1]),
                    Double.parseDouble(line[5])
            );
        }
    }
}
