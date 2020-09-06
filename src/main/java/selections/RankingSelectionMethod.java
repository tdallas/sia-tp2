package selections;

import characters.Character;

import java.util.Collections;
import java.util.Random;

public class RankingSelectionMethod extends RouletteSelectionMethod {
    public RankingSelectionMethod(double percentage, Random rand) {
        super(percentage, rand);
    }

    @Override
    double[] calculateRelativeFitness() {
        double[] relativeFitness = new double[getPopulation().size()];
        double n, fitnessSum = 0;

        Collections.sort(getPopulation());
        n = getPopulation().get(getPopulation().size() - 1).getPerformance();

        for (int i = 0; i < getPopulation().size(); i++) {
            relativeFitness[i] = (n - getPopulation().get(i).getPerformance()) / n;
        }

        for (int i = 0; i < getPopulation().size(); i++) {
            fitnessSum += relativeFitness[i];
        }

        for (int i = 0; i < getPopulation().size(); i++) {
            relativeFitness[i] = relativeFitness[i] / fitnessSum;
        }

        return relativeFitness;
    }
}
