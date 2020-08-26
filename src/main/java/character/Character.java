package character;

import items.*;
import lombok.Data;

@Data
public class Character {
    private final Boots boots;
    private final Chest chest;
    private final Gloves gloves;
    private final Head head;
    private final Weapon weapon;
}
