package selections;

import java.util.Random;

public class BoltzmannSelectionMethod extends RouletteSelectionMethod{
    private int generations = 0;
    private final int maxGenerations;
    private double[] boltzmannFitness;

    public BoltzmannSelectionMethod(double percentage, Random rand, final int maxGenerations) {
        super(percentage, rand);
        this.maxGenerations = maxGenerations;
        this.generations = 0;
    }

    @Override
    double[] calculateRelativeFitness() {
        double[] relativeFitness = new double[getPopulation().size()];
        double fitnessSum;

        calculateBoltzmannFitness();
        fitnessSum = calculateFitnessSum();

        for (int i = 0; i < getPopulation().size(); i++)
            relativeFitness[i] = boltzmannFitness[i] / fitnessSum;

        return relativeFitness;
    }

    private void calculateBoltzmannFitness() {
        double T = Math.pow(Math.E, -((double)generations / (10.0 * (double)maxGenerations)));
        double average;
        double[] exponentialFitness = calculateExponentialFitness(T);
        boltzmannFitness = new double[getPopulation().size()];

        average = calculateAverage(exponentialFitness);

        for (int i = 0; i < getPopulation().size(); i++) {
            boltzmannFitness[i] = exponentialFitness[i] / average;
        }
        generations++;
    }

    private double[] calculateExponentialFitness(final double T) {
        double[] exponentialFitness = new double[getPopulation().size()];
        double f;

        for (int i = 0; i < getPopulation().size(); i++) {
            f = getPopulation().get(i).calculatePerformance(getPopulation().get(i).getItems());
            exponentialFitness[i] = Math.exp(f / T);
        }

        return exponentialFitness;
    }

    private double calculateAverage(final double[] arr) {
        double sum = 0.0;

        for (double elem : arr)
            sum += elem;

        return sum / arr.length;
    }

    private int calculateFitnessSum() {
        int sum = 0;

        for (double x : boltzmannFitness)
            sum += x;

        return sum;
    }
}
