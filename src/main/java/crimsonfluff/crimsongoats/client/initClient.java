package crimsonfluff.crimsongoats.client;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entity.CrimsonGoatRenderer;
import crimsonfluff.crimsongoats.entity.CrimsonGoatShearedModel;
import crimsonfluff.crimsongoats.entity.CrimsonGoatShearedRenderer;
import crimsonfluff.crimsongoats.init.initEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class initClient implements ClientModInitializer {
    public static final EntityModelLayer GOAT_SHEARED_MODEL_LOC = new EntityModelLayer(new Identifier(CrimsonGoats.MOD_ID, "goat_sheared"), "goat_sheared");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(initEntities.GOAT_WHITE, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/white.png")));
        EntityRendererRegistry.register(initEntities.GOAT_ORANGE, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/orange.png")));
        EntityRendererRegistry.register(initEntities.GOAT_MAGENTA, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/magenta.png")));
        EntityRendererRegistry.register(initEntities.GOAT_LIGHT_BLUE, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/light_blue.png")));
        EntityRendererRegistry.register(initEntities.GOAT_YELLOW, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/yellow.png")));
        EntityRendererRegistry.register(initEntities.GOAT_LIME, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/lime.png")));
        EntityRendererRegistry.register(initEntities.GOAT_PINK, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/pink.png")));
        EntityRendererRegistry.register(initEntities.GOAT_GRAY, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/gray.png")));
        EntityRendererRegistry.register(initEntities.GOAT_LIGHT_GRAY, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/light_gray.png")));
        EntityRendererRegistry.register(initEntities.GOAT_CYAN, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/cyan.png")));
        EntityRendererRegistry.register(initEntities.GOAT_BLUE, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/blue.png")));
        EntityRendererRegistry.register(initEntities.GOAT_BROWN, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/brown.png")));
        EntityRendererRegistry.register(initEntities.GOAT_GREEN, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/green.png")));
        EntityRendererRegistry.register(initEntities.GOAT_RED, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/red.png")));
        EntityRendererRegistry.register(initEntities.GOAT_BLACK, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/black.png")));
        EntityRendererRegistry.register(initEntities.GOAT_PURPLE, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/purple.png")));
        EntityRendererRegistry.register(initEntities.GOAT_MISSING, context -> new CrimsonGoatRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/missing.png")));

        EntityRendererRegistry.register(initEntities.GOAT_SHEARED, context -> new CrimsonGoatShearedRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/white.png")));
        EntityRendererRegistry.register(initEntities.GOAT_MISSING_SHEARED, context -> new CrimsonGoatShearedRenderer(context, new Identifier(CrimsonGoats.MOD_ID, "textures/entity/missing_sheared.png")));

        EntityModelLayerRegistry.registerModelLayer(GOAT_SHEARED_MODEL_LOC, CrimsonGoatShearedModel::getTexturedModelData);
    }
}
