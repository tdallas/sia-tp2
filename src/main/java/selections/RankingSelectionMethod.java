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
        double fitnessSum = 0;

        for (Character c : getPopulation()) {
            fitnessSum += c.getPerformance();
        }

        getPopulation().sort(Collections.reverseOrder());

        for (int i = 0; i < getPopulation().size(); i++) {
            relativeFitness[i] = (fitnessSum - getPopulation().get(i).getPerformance()) / fitnessSum;
        }

        return relativeFitness;
    }
}
