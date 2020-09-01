package crossovers;

import items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UniformCrossover extends Crossover {

    @Override
    public List<List<Item>> crossover(List<Item> from, List<Item> to) {
        final Random random = new Random();
        final List<Item> firstAlleles = new ArrayList<>();
        final List<Item> secondAlleles = new ArrayList<>();
        for (int i = 0 ; i < MAX_ALLELES ; i++) {
            if (random.nextInt() % 2 == 0) {
                firstAlleles.add(from.get(i));
                secondAlleles.add(to.get(i));
            } else {
                firstAlleles.add(to.get(i));
                secondAlleles.add(from.get(i));
            }
        }
        return Arrays.asList(firstAlleles, secondAlleles);
    }
}