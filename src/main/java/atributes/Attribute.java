package atributes;


import lombok.Getter;

@Getter
public abstract class Attribute {
    private final double value;

    public Attribute(final double value) {
        this.value = value;
    }

}
