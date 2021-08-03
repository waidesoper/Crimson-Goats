package crimsonfluff.crimsongoats;

import crimsonfluff.crimsongoats.init.blocksInit;
import crimsonfluff.crimsongoats.init.entitiesInit;
import crimsonfluff.crimsongoats.init.itemsInit;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CrimsonGoats.MOD_ID)
public class CrimsonGoats {
    public static final String MOD_ID = "crimsongoats";
    public static final Logger LOGGER = LogManager.getLogger(CrimsonGoats.MOD_ID);
    public static final ConfigBuilder CONFIGURATION = new ConfigBuilder();

    public static final ModelLayerLocation GOAT_SHEARED_MODEL_LOC = new ModelLayerLocation(new ResourceLocation(CrimsonGoats.MOD_ID, "crimson.goat"), "crimson.goat");

    public CrimsonGoats() {
        entitiesInit.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        itemsInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        blocksInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, CONFIGURATION.SERVER);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final CreativeModeTab TAB = new CreativeModeTab(CrimsonGoats.MOD_ID) {
        @OnlyIn(Dist.CLIENT)
        @Override
        public ItemStack makeIcon() { return new ItemStack(itemsInit.GOAT_MISSING_WOOL.get()); }
    };
}
