package crimsonfluff.crimsongoats.events;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatRenderer;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedModel;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedRenderer;
import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrimsonGoats.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusEventsClient {
    public static final ModelLayerLocation GOAT_SHEARED_MODEL_LOC = new ModelLayerLocation(new ResourceLocation(CrimsonGoats.MOD_ID, "crimson.goat"), "crimson.goat");

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(entitiesInit.GOAT_WHITE.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/white.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_ORANGE.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/orange.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_MAGENTA.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/magenta.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_LIGHT_BLUE.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/light_blue.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_YELLOW.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/yellow.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_LIME.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/lime.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_PINK.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/pink.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_GRAY.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/gray.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_LIGHT_GRAY.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/light_gray.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_CYAN.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/cyan.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_BLUE.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/blue.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_BROWN.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/brown.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_GREEN.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/green.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_RED.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/red.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_BLACK.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/black.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_PURPLE.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/purple.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_MISSING.get(), p_174153_ -> new CrimsonGoatRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/missing.png")));

        event.registerEntityRenderer(entitiesInit.GOAT_SHEARED.get(), p_174153_ -> new CrimsonGoatShearedRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/white.png")));
        event.registerEntityRenderer(entitiesInit.GOAT_SHEARED_MISSING.get(), p_174153_ -> new CrimsonGoatShearedRenderer(p_174153_, new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/missing_sheared.png")));
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GOAT_SHEARED_MODEL_LOC, CrimsonGoatShearedModel::createBodyLayer);
    }
}
