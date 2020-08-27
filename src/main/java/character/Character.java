package character;

import items.*;
import lombok.Data;

@Data
public class Character {
    private final Boots boots;
    private final Chest chest;
    private final Gloves gloves;
    private final Helmet helmet;
    private final Weapon weapon;
}
