package crimsonfluff.crimsongoats.client;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entity.CrimsonGoatRenderer;
import crimsonfluff.crimsongoats.entity.CrimsonGoatShearedModel;
import crimsonfluff.crimsongoats.init.initEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class initClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(initEntities.GOAT, CrimsonGoatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CrimsonGoats.GOAT_SHEARED_MODEL_LOC, CrimsonGoatShearedModel::getTexturedModelData);
    }
}
