package crimsonfluff.crimsongoats.items;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class GoatSteak extends Item {
    public GoatSteak() {
        super(new Properties()
            .tab(CrimsonGoats.TAB)
            .food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(0.3f)
                .meat()
                .build()
            )
        );
    }
}
