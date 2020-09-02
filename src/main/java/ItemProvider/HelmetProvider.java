package ItemProvider;

import items.Helmet;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class HelmetProvider extends ItemProvider<Helmet> {
    private final List<Helmet> helmets;

    @Override
    public Helmet provideItem(int position) {
        return helmets.get(position);
    }
}
