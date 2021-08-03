package crimsonfluff.crimsongoats.entities;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrimsonGoatShearedRenderer extends MobRenderer<CrimsonGoatShearedEntity, CrimsonGoatShearedModel<CrimsonGoatShearedEntity>> {
    private final ResourceLocation TEXTURE = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/white.png");

    public CrimsonGoatShearedRenderer(EntityRendererProvider.Context p_174153_) {
        super(p_174153_, new CrimsonGoatShearedModel<>(p_174153_.bakeLayer(CrimsonGoats.GOAT_SHEARED_MODEL_LOC)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrimsonGoatShearedEntity entityIn) {
        return TEXTURE;
    }
}
