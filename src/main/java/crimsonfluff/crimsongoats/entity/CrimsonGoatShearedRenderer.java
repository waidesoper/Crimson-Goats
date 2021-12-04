package crimsonfluff.crimsongoats.entity;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.client.initClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CrimsonGoatShearedRenderer extends MobEntityRenderer<CrimsonGoatShearedEntity, CrimsonGoatShearedModel<CrimsonGoatShearedEntity>> {
    private final Identifier TEXTURE;

    public CrimsonGoatShearedRenderer(EntityRendererFactory.Context context, Identifier textureIn) {
        super(context, new CrimsonGoatShearedModel(context.getPart(initClient.GOAT_SHEARED_MODEL_LOC)), 0.7F);
        TEXTURE = textureIn;
    }

    @Override
    public Identifier getTexture(CrimsonGoatShearedEntity goatEntity) { return TEXTURE; }
}
