import ItemProvider.*;
import alleles.items.*;
import parser.ItemParser;
import parser.PropertiesParser;
import parser.configs.*;

import java.io.IOException;
import java.util.Properties;

public class Main {

    // handle exception
    public static void main(final String[] args) throws IOException {
        PropertiesParser propertiesParser = new PropertiesParser();
        Properties properties = propertiesParser.loadProperties();
        Configurations configurations = getConfigsFromProperties(properties);
        ItemParser itemParser = new ItemParser(properties, 10000);
        final WeaponProvider weaponProvider = new WeaponProvider(itemParser.parseItem(Weapon.class));
        final GlovesProvider glovesProvider = new GlovesProvider(itemParser.parseItem(Gloves.class));
        final BootsProvider bootsProvider = new BootsProvider(itemParser.parseItem(Boots.class));
        final ChestProvider chestProvider = new ChestProvider(itemParser.parseItem(Chest.class));
        final HelmetProvider helmetProvider = new HelmetProvider(itemParser.parseItem(Helmet.class));

        ItemsProvider itemsProvider = new ItemsProvider(10000, bootsProvider, chestProvider, glovesProvider, weaponProvider, helmetProvider);
    }

    private static Configurations getConfigsFromProperties(final Properties properties) {
        SelectionReplacementMethod selectionMethod1 = new SelectionReplacementMethod(
                (String) properties.get(ConfigKeys.SELECTION_METHOD_1),
                Double.parseDouble((String) properties.get(ConfigKeys.SELECTION_METHOD_1_PERCENTAGE)),
                Double.parseDouble((String) properties.get(ConfigKeys.SELECTION_METHOD_1_PARAMETER))
        );

        SelectionReplacementMethod selectionMethod2 = new SelectionReplacementMethod(
                (String) properties.get(ConfigKeys.SELECTION_METHOD_2),
                Double.parseDouble((String) properties.get(ConfigKeys.SELECTION_METHOD_2_PERCENTAGE)),
                Double.parseDouble((String) properties.get(ConfigKeys.SELECTION_METHOD_2_PARAMETER))
        );

        SelectionReplacementMethod replacementMethod1 = new SelectionReplacementMethod(
                (String) properties.get(ConfigKeys.REPLACEMENT_METHOD_1),
                Double.parseDouble((String) properties.get(ConfigKeys.REPLACEMENT_METHOD_1_PERCENTAGE)),
                Double.parseDouble((String) properties.get(ConfigKeys.REPLACEMENT_METHOD_1_PARAMETER))
        );

        SelectionReplacementMethod replacementMethod2 = new SelectionReplacementMethod(
                (String) properties.get(ConfigKeys.REPLACEMENT_METHOD_2),
                Double.parseDouble((String) properties.get(ConfigKeys.REPLACEMENT_METHOD_2_PERCENTAGE)),
                Double.parseDouble((String) properties.get(ConfigKeys.REPLACEMENT_METHOD_2_PARAMETER))
        );

        CutCondition cutCondition = new CutCondition(
                (String) properties.get(ConfigKeys.CUT_CONDITION),
                Integer.parseInt((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_1)),
                Integer.parseInt((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_2))
        );

        MutationMethod mutationMethod = new MutationMethod(
                (String) properties.get(ConfigKeys.MUTATION_METHOD),
                Double.parseDouble((String) properties.get(ConfigKeys.MUTATION_METHOD_PROBABILITY))
        );

        return new Configurations(
                mutationMethod,
                selectionMethod1,
                selectionMethod2,
                replacementMethod1,
                replacementMethod2,
                cutCondition,
                (String) properties.get(ConfigKeys.CROSSOVER_METHOD),
                Long.parseLong((String) properties.get(ConfigKeys.RANDOM_SEED)),
                Integer.parseInt((String) properties.get(ConfigKeys.POPULATION_SIZE))
        );
    }

}
