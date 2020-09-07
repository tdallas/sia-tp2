package engine.utils;

import ItemProvider.ItemsProvider;
import alleles.AlleleType;
import alleles.Height;
import alleles.items.*;
import characters.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopulationGenerator<T extends Character> {
    //    HEIGHT, BOOTS, CHEST, GLOVES, HELMET, WEAPON;

    public List<Character> generateFirstPopulation(int populationSize,
                                                   final Random random,
                                                   final ItemsProvider itemsProvider,
                                                   final CharacterFactory<T> characterFactory) {
        List<Character> initialPopulation = new ArrayList<>(populationSize);
        while (populationSize > 0) {
            Height height = new Height(Height.MIN_HEIGHT + random.nextDouble() * (Height.MAX_HEIGHT - Height.MIN_HEIGHT));
            Boots boots = (Boots) itemsProvider.getItemToReplace(AlleleType.BOOTS, random.nextInt(itemsProvider.getMAX_ITEMS()));
            Chest chest = (Chest) itemsProvider.getItemToReplace(AlleleType.CHEST, random.nextInt(itemsProvider.getMAX_ITEMS()));
            Gloves gloves = (Gloves) itemsProvider.getItemToReplace(AlleleType.GLOVES, random.nextInt(itemsProvider.getMAX_ITEMS()));
            Helmet helmet = (Helmet) itemsProvider.getItemToReplace(AlleleType.HELMET, random.nextInt(itemsProvider.getMAX_ITEMS()));
            Weapon weapon = (Weapon) itemsProvider.getItemToReplace(AlleleType.WEAPON, random.nextInt(itemsProvider.getMAX_ITEMS()));
            initialPopulation.add(characterFactory.characterSupplier(boots, chest, gloves, helmet, weapon, height.getValue()));
            populationSize--;
        }
        return initialPopulation;
    }
}
