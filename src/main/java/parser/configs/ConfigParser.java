package parser.configs;

import crossovers.*;
import cutConditions.*;
import engine.implementation.FillAll;
import engine.implementation.FillParent;
import engine.implementation.Implementation;
import mutations.*;
import selections.*;

import java.util.Properties;
import java.util.Random;

public class ConfigParser {

    private static int tryParseInt(String string, String errorMessage) {
        int result = -1;
        try {
            result = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            System.exit(1);
        }
        return result;
    }

    private static long tryParseLong(String string, String errorMessage) {
        long result = -1;
        try {
            result = Long.parseLong(string);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            System.exit(1);
        }
        return result;
    }

    private static double tryParseDouble(String string, String errorMessage) {
        double result = -1;
        try {
            result = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            System.exit(1);
        }
        return result;
    }

    public static long parseRandom(Properties properties, Random random) {
        long seed = Math.abs(random.nextLong());
        String randomSeedString = (String) properties.get(ConfigKeys.RANDOM_SEED);
        if (randomSeedString != null && !randomSeedString.equals("")) {
            seed = Long.parseLong(randomSeedString);
        }
        random.setSeed(seed);
        return seed;
    }

    public static CutCondition parseCutCondition(Properties properties) {
        String cutConditionString = (String) properties.get(ConfigKeys.CUT_CONDITION);
        long longCutParam;
        double doubleCutParam;
        int intCutParam1;
        int intCutParam2;
        if (cutConditionString.equals("TIME")) {
            longCutParam = tryParseLong((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_1), "Invalid time parameter 1, must be a long");
            if (longCutParam < 0) {
                errorMsgAndClose("Invalid time parameter 1, must be positive number");
            }
            return new TimeCutCondition(longCutParam);
        } else if (cutConditionString.equals("ACCEPTABLE")) {
            doubleCutParam = tryParseDouble((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_1), "Invalid acceptable fitness parameter 1, must be double");
            if (doubleCutParam < 0.0) {
                errorMsgAndClose("Invalid acceptable fitness parameter 1, must be positive number");
            }
            return new AcceptableCutCondition(doubleCutParam);
        } else if (cutConditionString.equals("CONTENT")) {
            intCutParam1 = tryParseInt((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_1), "Invalid content generations parameter 1, must be integer");
            if (intCutParam1 < 1) {
                errorMsgAndClose("Invalid content generations parameter 1, must be positive number");
            }
            return new ContentCutCondition(intCutParam1);
        } else if (cutConditionString.equals("GENERATION")) {
            intCutParam1 = tryParseInt((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_1), "Invalid max generations parameter 1, must be integer");
            if (intCutParam1 < 1) {
                errorMsgAndClose("Invalid max generations parameter 1, must be positive number");
            }
            return new GenerationCutCondition(intCutParam1);
        } else if (cutConditionString.equals("STRUCTURE")) {
            intCutParam1 = tryParseInt((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_1), "Invalid structure population in common parameter 1, must be integer");
            intCutParam2 = tryParseInt((String) properties.get(ConfigKeys.CUT_CONDITION_PARAMETER_2), "Invalid structure generations parameter 2, must be integer");
            if (intCutParam1 < 1) {
                errorMsgAndClose("Invalid structure population in common parameter 1, must be positive number");
            }
            if (intCutParam2 < 1) {
                errorMsgAndClose("Invalid structure generations parameter 2, must be positive number");
            }
            return new StructureCutCondition(intCutParam1, intCutParam2);
        } else {
            System.out.println("Invalid cut condition. Possible options: TIME, ACCEPTABLE, CONTENT, STRUCTURE");
            System.exit(1);
            return null;
        }
    }

    public static SelectionMethod parseSelectionMethod(Properties properties, String whichSelection, Random random) {
        String selectionMethodString = (String) properties.get(whichSelection);
        double percentage = tryParseDouble((String) properties.get(whichSelection + ".percentage"), "Invalid " + whichSelection + " percentage, must be double");
        double doubleParameter;
        int intParameter;
        if (selectionMethodString.equals("ELITE")) {
            return new EliteSelectionMethod(percentage);
        } else if (selectionMethodString.equals("ROULETTE")) {
            return new RouletteSelectionMethod(percentage, random);
        } else if (selectionMethodString.equals("RANKING")) {
            return new RankingSelectionMethod(percentage, random);
        } else if (selectionMethodString.equals("UNIVERSAL")) {
            return new UniversalSelectionMethod(percentage, random);
        } else if (selectionMethodString.equals("BOLTZMANN")) {
            return new BoltzmannSelectionMethod(percentage, random);
        } else if (selectionMethodString.equals("PROBABILISTIC_TOURNAMENT")) {
            doubleParameter = tryParseDouble((String) properties.get(whichSelection + ".parameter"), "Invalid " + whichSelection + " threshold parameter, must be double");
            if (doubleParameter < 0.5 || doubleParameter > 1.0) {
                errorMsgAndClose("Invalid probabilistic tournament threshold parameter, must be between 0.5 and 1.0");
            }
            return new ProbabilisticTournamentSelection(percentage, random, doubleParameter);
        } else if (selectionMethodString.equals("DETERMINISTIC_TOURNAMENT")) {
            intParameter = tryParseInt((String) properties.get(whichSelection + ".parameter"), "Invalid " + whichSelection + " m parameter, must be integer");
            if (intParameter < 0) {
                errorMsgAndClose("Invalid deterministic tournament parameter, m must be positive number");
            }
            return new DeterministicTournamentSelection(percentage, random, intParameter);
        } else {
            System.out.println("Invalid " + whichSelection + " method. Possible options: ELITE, ROULETTE, RANKING, BOLTZMANN, UNIVERSAL, PROBABILISTIC_TOURNAMENT, DETERMINISTIC_TOURNAMENT");
            System.exit(1);
            return null;
        }
    }

    public static Implementation parseImplementation(Properties properties, SelectionMethod replacementMethod1, SelectionMethod replacementMethod2, int populationSize) {
        String implementationString = (String) properties.get(ConfigKeys.IMPLEMENTATION_MODE);
        int implementationParameter = tryParseInt((String) properties.get(ConfigKeys.IMPLEMENTATION_MODE_PARAMETER), "Invalid implementation parameter, must be integer");
        if (implementationParameter < 1) {
            errorMsgAndClose("Invalid implementation parameter, must be positive number");
        }
        if (implementationString.equals("FILL_ALL")) {
            return new FillAll(replacementMethod1, replacementMethod2, populationSize, implementationParameter);
        } else if (implementationString.equals("FILL_PARENT")) {
            return new FillParent(replacementMethod1, replacementMethod2, populationSize, implementationParameter);
        } else {
            System.out.println("Invalid implementation method. Possible options: FILL_ALL, FILL_PARENT");
            System.exit(1);
            return null;
        }
    }

    public static Crossover parseCrossover(Properties properties, Random random) {
        String crossoverString = (String) properties.get(ConfigKeys.CROSSOVER_METHOD);
        if (crossoverString.equals("UNIFORM")) {
            return new UniformCrossover(random);
        } else if (crossoverString.equals("ANNULAR")) {
            return new AnnularCrossover(random);
        } else if (crossoverString.equals("DOUBLE_POINT")) {
            return new DoublePointCrossover(random);
        } else if (crossoverString.equals("SINGLE_POINT")) {
            return new SinglePointCrossover(random);
        } else {
            System.out.println("Invalid crossover method. Possible options: UNIFORM, ANNULAR, DOUBLE_POINT, SINGLE_POINT");
            System.exit(1);
            return null;
        }
    }

    public static Mutation parseMutation(Properties properties, Random random) {
        String mutationString = (String) properties.get(ConfigKeys.MUTATION_METHOD);
        double parameter;
        if (mutationString.equals("COMPLETE")) {
            parameter = tryParseDouble((String) properties.get(ConfigKeys.MUTATION_METHOD_PROBABILITY), "Invalid complete mutation probability, must be double");
            if (parameter < 0 || parameter > 1) {
                errorMsgAndClose("Invalid complete mutation probability, must be between 0.0 and 1.0");
            }
            return new CompleteMutation(parameter, random);
        } else if (mutationString.equals("ONE_GEN")) {
            parameter = tryParseDouble((String) properties.get(ConfigKeys.MUTATION_METHOD_PROBABILITY), "Invalid one gen mutation probability, must be double");
            if (parameter < 0 || parameter > 1) {
                errorMsgAndClose("Invalid one gen mutation probability, must be between 0.0 and 1.0");
            }
            return new OneGenMutation(parameter, random);
        } else if (mutationString.equals("LIMITED")) {
            parameter = tryParseDouble((String) properties.get(ConfigKeys.MUTATION_METHOD_PROBABILITY), "Invalid limited mutation probability, must be double");
            if (parameter < 0 || parameter > 1) {
                errorMsgAndClose("Invalid limited mutation probability, must be between 0.0 and 1.0");
            }
            return new LimitedMultiGenMutation(parameter, random);
        } else if (mutationString.equals("UNIFORM")) {
            parameter = tryParseDouble((String) properties.get(ConfigKeys.MUTATION_METHOD_PROBABILITY), "Invalid uniform mutation probability, must be double");
            if (parameter < 0 || parameter > 1) {
                errorMsgAndClose("Invalid uniform mutation probability, must be between 0.0 and 1.0");
            }
            return new UniformMultiGenMutation(parameter, random);
        } else {
            System.out.println("Invalid mutation method. Possible options: COMPLETE, ONE_GEN, LIMITED, UNIFORM");
            System.exit(1);
            return null;
        }
    }

    public static int parsePopulationSize(Properties properties) {
        int populationSize = tryParseInt((String) properties.get(ConfigKeys.POPULATION_SIZE), "Invalid population size parameter, must be integer");
        if (populationSize < 1) {
            errorMsgAndClose("Invalid population size parameter, must be positive number");
        }
        return populationSize;
    }

    public static int parseNumberOfItems(Properties properties) {
        int numberOfItems = tryParseInt((String) properties.get(ConfigKeys.NUMBER_OF_ITEMS), "Invalid number of items parameter, must be integer");
        if (numberOfItems < 1) {
            errorMsgAndClose("Invalid number of items parameter, must be positive number");
        }
        return numberOfItems;
    }

    private static void errorMsgAndClose(String errorMessage) {
        System.out.println(errorMessage);
        System.exit(1);
    }

}
