package crimsonfluff.crimsongoats.events;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatRenderer;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedModel;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedRenderer;
import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrimsonGoats.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusEventsClient {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(entitiesInit.CRIMSON_GOAT.get(), CrimsonGoatRenderer::new);
        event.registerEntityRenderer(entitiesInit.CRIMSON_GOAT_SHEARED.get(), CrimsonGoatShearedRenderer::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CrimsonGoats.GOAT_SHEARED_MODEL_LOC, CrimsonGoatShearedModel::createBodyLayer);
    }
}
