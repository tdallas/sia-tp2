package selections;

import characters.Character;

import java.util.List;

public abstract class SelectionMethod {
    private final double percentage;
    private List<Character> population;

    public SelectionMethod(double percentage) {
        this.percentage = percentage;
    }

    public List<Character> getPopulation() {
        return population;
    }

    public void setPopulation(List<Character> population) {
        this.population = population;
    }

    public double getPercentage() {
        return percentage;
    }

    public abstract List<Character> select(final List<Character> population, final int k);
}
