package parser.configs;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Configurations {
    private final MutationMethod mutationMethod;

    private final SelectionReplacementMethod selectionMethod1;
    private final SelectionReplacementMethod selectionMethod2;

    private final SelectionReplacementMethod replacementMethod1;
    private final SelectionReplacementMethod replacementMethod2;

    private final CutCondition cutCondition;

    private final String crossoverMethod;

    private final long randomSeed;
    private final int populationSize;

}
