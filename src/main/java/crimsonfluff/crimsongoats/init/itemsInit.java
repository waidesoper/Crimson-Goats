package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.items.CrimsonSpawnEggItem;
import crimsonfluff.crimsongoats.items.GoatSteak;
import crimsonfluff.crimsongoats.items.GoatSteakCooked;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class itemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrimsonGoats.MOD_ID);

    public static final RegistryObject<Item> GOAT_WHITE_SPAWN_EGG = ITEMS.register("goat_white_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_WHITE, 0xFFFFFF, MaterialColor.SNOW.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_ORANGE_SPAWN_EGG = ITEMS.register("goat_orange_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_ORANGE, 14804727, MaterialColor.COLOR_ORANGE.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_MAGENTA_SPAWN_EGG = ITEMS.register("goat_magenta_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_MAGENTA, 14804727, MaterialColor.COLOR_MAGENTA.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_LIGHT_BLUE_SPAWN_EGG = ITEMS.register("goat_light_blue_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_LIGHT_BLUE, 14804727, MaterialColor.COLOR_LIGHT_BLUE.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_YELLOW_SPAWN_EGG = ITEMS.register("goat_yellow_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_YELLOW, 14804727, MaterialColor.COLOR_YELLOW.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_LIME_SPAWN_EGG = ITEMS.register("goat_lime_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_LIME, 14804727, MaterialColor.COLOR_LIGHT_GREEN.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_PINK_SPAWN_EGG = ITEMS.register("goat_pink_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_PINK, 14804727, MaterialColor.COLOR_PINK.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_GRAY_SPAWN_EGG = ITEMS.register("goat_gray_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_GRAY, 14804727, MaterialColor.COLOR_GRAY.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_LIGHT_GRAY_SPAWN_EGG = ITEMS.register("goat_light_gray_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_LIGHT_GRAY, 14804727, MaterialColor.COLOR_LIGHT_GRAY.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_CYAN_SPAWN_EGG = ITEMS.register("goat_cyan_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_CYAN, 14804727, MaterialColor.COLOR_CYAN.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_BLUE_SPAWN_EGG = ITEMS.register("goat_blue_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_BLUE, 14804727, MaterialColor.COLOR_LIGHT_BLUE.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_BROWN_SPAWN_EGG = ITEMS.register("goat_brown_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_BROWN, 14804727, MaterialColor.COLOR_BROWN.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_GREEN_SPAWN_EGG = ITEMS.register("goat_green_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_GREEN, 14804727, MaterialColor.COLOR_GREEN.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_RED_SPAWN_EGG = ITEMS.register("goat_red_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_RED, 14804727, MaterialColor.COLOR_RED.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_BLACK_SPAWN_EGG = ITEMS.register("goat_black_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_BLACK, 14804727, MaterialColor.COLOR_BLACK.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_PURPLE_SPAWN_EGG = ITEMS.register("goat_purple_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_PURPLE, 14804727, MaterialColor.COLOR_PURPLE.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_MISSING_SPAWN_EGG = ITEMS.register("goat_missing_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.GOAT_MISSING, MaterialColor.COLOR_BLACK.col, MaterialColor.COLOR_PINK.col, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_STEAK = ITEMS.register("goat_steak", GoatSteak::new);
    public static final RegistryObject<Item> GOAT_STEAK_COOKED = ITEMS.register("goat_steak_cooked", GoatSteakCooked::new);
    public static final RegistryObject<Item> GOAT_MISSING_WOOL = ITEMS.register("missing_wool", ()->
        new BlockItem(blocksInit.GOAT_MISSING_WOOL_BLOCK.get(), new Item.Properties().tab(CrimsonGoats.TAB)));
}
