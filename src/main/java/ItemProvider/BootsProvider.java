package ItemProvider;

import items.Boots;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BootsProvider extends ItemProvider<Boots> {
    private final List<Boots> boots;

    @Override
    public Boots provideItem(final int position) {
        return boots.get(position);
    }
}
