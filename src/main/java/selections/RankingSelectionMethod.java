package selections;

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
        n = getPopulation().size();

        for (int i = 0; i < getPopulation().size(); i++) {
            relativeFitness[i] = (n - i) / n;
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
