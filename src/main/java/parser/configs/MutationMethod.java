package parser.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MutationMethod {
    private final String type;
    private final double probability;
}
