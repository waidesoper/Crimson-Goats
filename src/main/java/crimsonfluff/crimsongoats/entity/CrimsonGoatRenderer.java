package crimsonfluff.crimsongoats.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.GoatEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CrimsonGoatRenderer extends MobEntityRenderer<CrimsonGoatEntity, GoatEntityModel<CrimsonGoatEntity>> {
    private final Identifier TEXTURE;

    public CrimsonGoatRenderer(EntityRendererFactory.Context context, Identifier textureIn) {
        super(context, new GoatEntityModel(context.getPart(EntityModelLayers.GOAT)), 0.7F);
        TEXTURE = textureIn;
    }

    @Override
    public Identifier getTexture(CrimsonGoatEntity goatEntity) { return TEXTURE; }
}