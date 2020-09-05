package atributes;

import lombok.Getter;
import mutations.Allele;

@Getter
public class Height extends Attribute implements Allele {
    public Height(double value) {
        super(value);
    }
}
