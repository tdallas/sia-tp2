package ItemProvider;

import alleles.items.Weapon;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class WeaponProvider extends ItemProvider<Weapon> {

    private final List<Weapon> weapons;

    @Override
    public Weapon provideItem(int position) {
        return weapons.get(position);
    }
}
