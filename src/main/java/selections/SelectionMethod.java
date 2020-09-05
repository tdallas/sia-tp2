package selections;

import characters.Character;

import java.util.List;

public abstract class SelectionMethod {
    private List<Character> population;
    private final double probability;

    public SelectionMethod(double probability) {
        this.probability = probability;
    }

    public List<Character> getPopulation() {
        return population;
    }

    public void setPopulation(List<Character> population) {
        this.population = population;
    }

    public double getProbability() {
        return probability;
    }

    public abstract List<Character> select(final List<Character> population, final int k);
}
