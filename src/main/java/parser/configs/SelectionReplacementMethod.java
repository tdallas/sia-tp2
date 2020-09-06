package parser.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SelectionReplacementMethod {
    private final String type;
    private final double percentage;
    private final double parameter;
}
