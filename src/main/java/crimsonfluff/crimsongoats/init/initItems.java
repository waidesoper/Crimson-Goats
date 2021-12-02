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
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_white_spawn_egg"), new SpawnEggItem(initEntities.GOAT_WHITE, 0xFFFFFF, MapColor.WHITE.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_orange_spawn_egg"), new SpawnEggItem(initEntities.GOAT_ORANGE, 14804727, MapColor.ORANGE.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_magenta_spawn_egg"), new SpawnEggItem(initEntities.GOAT_MAGENTA, 14804727, MapColor.MAGENTA.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_light_blue_spawn_egg"), new SpawnEggItem(initEntities.GOAT_LIGHT_BLUE, 14804727, MapColor.LIGHT_BLUE.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_yellow_spawn_egg"), new SpawnEggItem(initEntities.GOAT_YELLOW, 14804727, MapColor.YELLOW.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_lime_spawn_egg"), new SpawnEggItem(initEntities.GOAT_LIME, 14804727, MapColor.LIME.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_pink_spawn_egg"), new SpawnEggItem(initEntities.GOAT_PINK, 14804727, MapColor.PINK.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_gray_spawn_egg"), new SpawnEggItem(initEntities.GOAT_GRAY, 14804727, MapColor.GRAY.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_light_gray_spawn_egg"), new SpawnEggItem(initEntities.GOAT_LIGHT_GRAY, 14804727, MapColor.LIGHT_GRAY.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_cyan_spawn_egg"), new SpawnEggItem(initEntities.GOAT_CYAN, 14804727, MapColor.CYAN.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_blue_spawn_egg"), new SpawnEggItem(initEntities.GOAT_BLUE, 14804727, MapColor.BLUE.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_brown_spawn_egg"), new SpawnEggItem(initEntities.GOAT_BROWN, 14804727, MapColor.BROWN.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_green_spawn_egg"), new SpawnEggItem(initEntities.GOAT_GREEN, 14804727, MapColor.GREEN.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_red_spawn_egg"), new SpawnEggItem(initEntities.GOAT_RED, 14804727, MapColor.RED.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_black_spawn_egg"), new SpawnEggItem(initEntities.GOAT_BLACK, 14804727, MapColor.BLACK.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_purple_spawn_egg"), new SpawnEggItem(initEntities.GOAT_PURPLE, 14804727, MapColor.PURPLE.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "goat_missing_spawn_egg"), new SpawnEggItem(initEntities.GOAT_MISSING, MapColor.BLACK.color, MapColor.PINK.color, new Item.Settings().group(CrimsonGoats.CREATIVE_TAB)));


        // Block Items ?
        Registry.register(Registry.ITEM, new Identifier(CrimsonGoats.MOD_ID, "missing_wool"), new BlockItem(initBlocks.MISSING_WOOL,
            new FabricItemSettings()
            .group(CrimsonGoats.CREATIVE_TAB)));
    }
}
