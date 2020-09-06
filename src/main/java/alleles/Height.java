package alleles;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Height implements Allele {

    public static final double MAX_HEIGHT = 2.0;
    public static final double MIN_HEIGHT = 1.3;

    private final double value;

    public Height(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return Double.compare(height.value, value) == 0;
    }

    @Override
    public String toString() {
        return "Height: " + value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
