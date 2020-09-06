package parser.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CutCondition {
    private final String type;
    private final int parameter1;
    private final int parameter2;
}
