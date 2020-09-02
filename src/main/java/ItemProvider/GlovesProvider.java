package ItemProvider;

import items.Gloves;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GlovesProvider extends ItemProvider<Gloves> {
    private final List<Gloves> gloves;

    @Override
    public Gloves provideItem(int position) {
        return gloves.get(position);
    }
}
