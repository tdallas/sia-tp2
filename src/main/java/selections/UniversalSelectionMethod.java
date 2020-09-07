package selections;

import java.util.Random;

public class UniversalSelectionMethod extends RouletteSelectionMethod {
    public UniversalSelectionMethod(double percentage, Random rand) {
        super(percentage, rand);
    }

    @Override
    double[] setRandomRArray(int k) {
        double[] randomArray = new double[k];
        double r = getRand().nextDouble();
        double rJ;

        for (int j = 1; j <= k; j++) {
            rJ = (r + j - 1) / k;
            randomArray[j - 1] = rJ;
        }
        return randomArray;
    }

    @Override
    public String toString() {
        return "UNIVERSAL";
    }
}
