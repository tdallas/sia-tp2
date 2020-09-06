package selections;

import characters.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteSelectionMethod extends SelectionMethod{
    private final Random rand;


    public RouletteSelectionMethod(final double percentage, final Random rand){
        super(percentage);
        this.rand = rand;
    }

    public Random getRand() {
        return rand;
    }

    @Override
    public List<Character> select(final List<Character> population, final int k) {
        ArrayList<Character> selectedList = new ArrayList<>();
        boolean selected;
        double[] randomArray;
        double[] relativeFitness;
        double[] accumulatedFitness;

        setPopulation(population);
        randomArray = setRandomRArray(k);
        relativeFitness = calculateRelativeFitness();
        accumulatedFitness = calculateAccumulatedFitness(relativeFitness);

        for (int j = 0; j < k; j++) {
            selected = false;

            for (int i = 1; i <= getPopulation().size() && !selected; i++) {
                if (accumulatedFitness[i - 1] <= randomArray[j] && randomArray[j] < accumulatedFitness[i]) {
                    selectedList.add(getPopulation().get(i - 1));
                    selected = true;
                }
            }
        }

        return selectedList;
    }

    double[] setRandomRArray(int k) {
        double[] randomArray = new double[k];
        for (int i = 0; i < k; i++) {
            randomArray[i] = rand.nextDouble();
        }
        return randomArray;
    }

    double[] calculateRelativeFitness() {
        double[] relativeFitness = new double[getPopulation().size()];
        int fitnessSum = 0;

        for (Character c : getPopulation()) {
            fitnessSum += c.getPerformance();
        }

        for (int i = 0; i < getPopulation().size(); i++)
            relativeFitness[i] = (getPopulation().get(i).getPerformance()) / fitnessSum;

        return relativeFitness;
    }

    private double[] calculateAccumulatedFitness(double[] relativeFitness) {
        double[] accumulatedFitness = new double[getPopulation().size() + 1];
        double accumulated;

        accumulatedFitness[0] = 0.0;

        for (int i = 1; i <= getPopulation().size(); i++) {
            accumulated = accumulatedFitness[i - 1];
            accumulatedFitness[i] = relativeFitness[i - 1] + accumulated;
        }

        return accumulatedFitness;
    }

}
