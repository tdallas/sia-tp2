import ItemProvider.*;
import alleles.items.*;
import characters.*;
import characters.Character;
import crossovers.Crossover;
import cutConditions.CutCondition;
import engine.GeneticsAlgorithm;
import engine.implementation.Implementation;
import engine.utils.CharacterFactory;
import engine.utils.PopulationGenerator;
import mutations.Mutation;
import parser.ItemParser;
import parser.PropertiesParser;
import parser.configs.*;
import selections.SelectionMethod;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import static engine.utils.CharacterFactory.*;

public class Main {

    public static void main(final String[] args){
        PropertiesParser propertiesParser = new PropertiesParser();
        Properties properties = propertiesParser.loadProperties();
        GeneticsAlgorithm geneticsAlgorithm = createGeneticsAlgorithm(properties);
        geneticsAlgorithm.start();
    }

    private static GeneticsAlgorithm createGeneticsAlgorithm(final Properties properties) {
        int numberOfItems = ConfigParser.parseNumberOfItems(properties);
        int populationSize = ConfigParser.parsePopulationSize(properties);
        Random random = ConfigParser.parseRandom(properties);
        Mutation mutation = ConfigParser.parseMutation(properties, random);
        Crossover crossover = ConfigParser.parseCrossover(properties, random);
        SelectionMethod selectionMethod1 = ConfigParser.parseSelectionMethod(properties, ConfigKeys.SELECTION_METHOD_1, random);
        SelectionMethod selectionMethod2 = ConfigParser.parseSelectionMethod(properties, ConfigKeys.SELECTION_METHOD_2, random);
        SelectionMethod replacementMethod1 = ConfigParser.parseSelectionMethod(properties, ConfigKeys.REPLACEMENT_METHOD_1, random);
        SelectionMethod replacementMethod2 = ConfigParser.parseSelectionMethod(properties, ConfigKeys.REPLACEMENT_METHOD_2, random);
        if(selectionMethod1.getPercentage() + selectionMethod2.getPercentage() != 1.0){
            System.out.println("Invalid percentages of selection method 1 and selection method 2. The sum of both must be equal to 1");
            System.exit(1);
        }
        if(replacementMethod1.getPercentage() + replacementMethod2.getPercentage() != 1.0){
            System.out.println("Invalid percentages of replacement method 1 and replacement method 2. The sum of both must be equal to 1");
            System.exit(1);
        }
        Implementation implementation = ConfigParser.parseImplementation(properties, replacementMethod1, replacementMethod2, populationSize);
        CutCondition cutCondition = ConfigParser.parseCutCondition(properties);

        ItemParser itemParser = new ItemParser(properties, numberOfItems);
        final WeaponProvider weaponProvider = new WeaponProvider(itemParser.parseItem(Weapon.class));
        final GlovesProvider glovesProvider = new GlovesProvider(itemParser.parseItem(Gloves.class));
        final BootsProvider bootsProvider = new BootsProvider(itemParser.parseItem(Boots.class));
        final ChestProvider chestProvider = new ChestProvider(itemParser.parseItem(Chest.class));
        final HelmetProvider helmetProvider = new HelmetProvider(itemParser.parseItem(Helmet.class));

        ItemsProvider itemsProvider = new ItemsProvider(numberOfItems, bootsProvider, chestProvider, glovesProvider, weaponProvider, helmetProvider);

        List<Character> firstPopulation = null;

        String characterClass = (String) properties.get(ConfigKeys.CLASS);
        if(characterClass.equals(WARRIOR)){
            CharacterFactory<Warrior> factory = new CharacterFactory<>(Warrior.class);
            PopulationGenerator<Warrior> populationGenerator = new PopulationGenerator<>();
            firstPopulation = populationGenerator.generateFirstPopulation(populationSize, random, itemsProvider, factory);
        }
        else if(characterClass.equals(ARCHER)){
            CharacterFactory<Archer> factory = new CharacterFactory<>(Archer.class);
            PopulationGenerator<Archer> populationGenerator = new PopulationGenerator<>();
            firstPopulation = populationGenerator.generateFirstPopulation(populationSize, random, itemsProvider, factory);
        }
        else if(characterClass.equals(DEFENDER)){
            CharacterFactory<Defender> factory = new CharacterFactory<>(Defender.class);
            PopulationGenerator<Defender> populationGenerator = new PopulationGenerator<>();
            firstPopulation = populationGenerator.generateFirstPopulation(populationSize, random, itemsProvider, factory);
        }
        else if(characterClass.equals(ROGUE)){
            CharacterFactory<Rogue> factory = new CharacterFactory<>(Rogue.class);
            PopulationGenerator<Rogue> populationGenerator = new PopulationGenerator<>();
            firstPopulation = populationGenerator.generateFirstPopulation(populationSize, random, itemsProvider, factory);
        }
        else {
            System.out.println("Invalid character class. Possible options: WARRIOR, ARCHER, DEFENDER, ROGUE");
        }
        return new GeneticsAlgorithm(
                random,
                populationSize,
                itemsProvider,
                selectionMethod1,
                selectionMethod2,
                crossover,
                mutation,
                implementation,
                cutCondition,
                implementation.getK(),
                firstPopulation,
                characterClass
        );
    }

}
