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
        int fitnessSum = (getPopulation().size() * (getPopulation().size() + 1)) / 2;

        Collections.sort(getPopulation());

        for (int i = 0; i < getPopulation().size(); i++)
            relativeFitness[i] = ((double) (i + 1)) / fitnessSum;

        return relativeFitness;
    }
}
