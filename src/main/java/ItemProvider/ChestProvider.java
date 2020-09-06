package ItemProvider;

import alleles.items.Chest;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ChestProvider extends ItemProvider<Chest> {

    private final List<Chest> chests;

    @Override
    public Chest provideItem(int position) {
        return chests.get(position);
    }
}
