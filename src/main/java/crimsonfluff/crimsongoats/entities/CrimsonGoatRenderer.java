package crimsonfluff.crimsongoats.entities;

import net.minecraft.client.model.GoatModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrimsonGoatRenderer extends MobRenderer<CrimsonGoatEntity, GoatModel<CrimsonGoatEntity>> {
    private final ResourceLocation TEXTURE;

    public CrimsonGoatRenderer(EntityRendererProvider.Context p_174153_, ResourceLocation textureIn) {
        super(p_174153_, new GoatModel<>(p_174153_.bakeLayer(ModelLayers.GOAT)), 0.7F);
        TEXTURE = textureIn;
    }

    @Override
    public ResourceLocation getTextureLocation(CrimsonGoatEntity entityIn) {
        return TEXTURE;
    }
}
