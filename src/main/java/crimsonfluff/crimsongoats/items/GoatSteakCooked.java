package crimsonfluff.crimsongoats.items;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class GoatSteakCooked extends Item {
    public GoatSteakCooked() {
        super(new Properties()
            .tab(CrimsonGoats.TAB)
            .food(new FoodProperties.Builder()
                .nutrition(8)
                .saturationMod(0.8f)
                .meat()
                .build()
            )
        );
    }
}
