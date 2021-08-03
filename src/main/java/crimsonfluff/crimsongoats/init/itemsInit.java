package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.CrimsonSpawnEggItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class itemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrimsonGoats.MOD_ID);

    // use vanilla goat spawn egg - it will randomise CrimsonGoats when spawned

// Spawn Eggs
    public static final RegistryObject<Item> CRIMSON_GOAT_SPAWN_EGG = ITEMS.register("goat_white_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 0, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_ORANGE_SPAWN_EGG = ITEMS.register("goat_orange_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 1, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_MAGENTA_SPAWN_EGG = ITEMS.register("goat_magenta_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 2, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_LIGHT_BLUE_SPAWN_EGG = ITEMS.register("goat_light_blue_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 3, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_YELLOW_SPAWN_EGG = ITEMS.register("goat_yellow_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 4, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_LIME_SPAWN_EGG = ITEMS.register("goat_lime_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 5, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_PINK_SPAWN_EGG = ITEMS.register("goat_pink_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 6, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_GRAY_SPAWN_EGG = ITEMS.register("goat_gray_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 7, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_LIGHT_GRAY_SPAWN_EGG = ITEMS.register("goat_light_gray_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 8, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_CYAN_SPAWN_EGG = ITEMS.register("goat_cyan_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 9, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_PURPLE_SPAWN_EGG = ITEMS.register("goat_purple_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 10,  new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_BLUE_SPAWN_EGG = ITEMS.register("goat_blue_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 11,  new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_BROWN_SPAWN_EGG = ITEMS.register("goat_brown_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 12, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_GREEN_SPAWN_EGG = ITEMS.register("goat_green_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 13, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_RED_SPAWN_EGG = ITEMS.register("goat_red_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 14, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_BLACK_SPAWN_EGG = ITEMS.register("goat_black_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT, 15, new Item.Properties().tab(CrimsonGoats.TAB)));

    public static final RegistryObject<Item> GOAT_MISSING_SPAWN_EGG = ITEMS.register("goat_missing_spawn_egg",
        ()-> new CrimsonSpawnEggItem(entitiesInit.CRIMSON_GOAT,16, new Item.Properties().tab(CrimsonGoats.TAB)));
    
    
// Misc Items
    public static final RegistryObject<Item> GOAT_STEAK = ITEMS.register("goat_steak", ()-> new Item(new Item.Properties().tab(CrimsonGoats.TAB)
        .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).meat().build())));

    public static final RegistryObject<Item> GOAT_STEAK_COOKED = ITEMS.register("goat_steak_cooked", ()-> new Item(new Item.Properties().tab(CrimsonGoats.TAB)
        .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).meat().build())));

    public static final RegistryObject<Item> GOAT_MISSING_WOOL = ITEMS.register("missing_wool", ()->
        new BlockItem(blocksInit.GOAT_MISSING_WOOL_BLOCK.get(), new Item.Properties().tab(CrimsonGoats.TAB)));
}
