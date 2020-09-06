package atributes;


import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Attribute {
    private final double value;

    public Attribute(final double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Double.compare(attribute.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
