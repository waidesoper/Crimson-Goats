package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class initItems {
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_steak"), new Item(new FabricItemSettings()
            .group(CrimsonGoats.CREATIVE_TAB)
            .food(FoodComponents.CHICKEN)));

        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_steak_cooked"), new Item(new FabricItemSettings()
            .group(CrimsonGoats.CREATIVE_TAB)
            .food(FoodComponents.COOKED_CHICKEN)));

        // Spawn_Eggs
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_spawn_egg"), new SpawnEggItem(initEntities.GOAT, 0xFFFFFF, MapColor.WHITE.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));

        // Block Items ?
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "missing_wool"), new BlockItem(initBlocks.MISSING_WOOL,
            new FabricItemSettings()
            .group(CrimsonGoats.CREATIVE_TAB)));
    }
}
