package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class itemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrimsonGoats.MOD_ID);

    // use vanilla goat spawn egg - it will randomise CrimsonGoats when spawned

    public static final RegistryObject<Item> GOAT_STEAK = ITEMS.register("goat_steak", ()-> new Item(new Item.Properties().tab(CrimsonGoats.TAB)
        .food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).meat().build())));

    public static final RegistryObject<Item> GOAT_STEAK_COOKED = ITEMS.register("goat_steak_cooked", ()-> new Item(new Item.Properties().tab(CrimsonGoats.TAB)
        .food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).meat().build())));

    public static final RegistryObject<Item> GOAT_MISSING_WOOL = ITEMS.register("missing_wool", ()->
        new BlockItem(blocksInit.GOAT_MISSING_WOOL_BLOCK.get(), new Item.Properties().tab(CrimsonGoats.TAB)));
}
