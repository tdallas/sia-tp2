package selections;

import java.util.Random;

public class BoltzmannSelectionMethod extends RouletteSelectionMethod {
    private static final double t0 = 10;
    private static final double tC = 1;

    private int iterations;

    public BoltzmannSelectionMethod(double percentage, Random rand) {
        super(percentage, rand);
        this.iterations = 0;
    }

    @Override
    double[] calculateRelativeFitness() {
        int size = getPopulation().size();
        double[] exponentialFitness = new double[size];
        double[] boltzmannFitness = new double[size];
        double[] relativeFitness = new double[size];

        double T = tC + (t0 - tC) * Math.pow(Math.E, -iterations);
        iterations++;
        double fitnessSum = 0, average = 0;
        double fitness;

        for (int i = 0; i < size; i++) {
            fitness = getPopulation().get(i).getPerformance();
            exponentialFitness[i] = Math.exp(fitness / T);
        }

        for (int i = 0; i < size; i++) {
            average += exponentialFitness[i];
        }

        average = average / size;

        for (int i = 0; i < size; i++) {
            boltzmannFitness[i] = exponentialFitness[i] / average;
        }

        for (int i = 0; i < size; i++) {
            fitnessSum += boltzmannFitness[i];
        }

        for (int i = 0; i < size; i++) {
            relativeFitness[i] = boltzmannFitness[i] / fitnessSum;
        }

        return relativeFitness;
    }

    @Override
    public String toString() {
        return "BOLTZMANN, Percentage: " + getPercentage();
    }
}
