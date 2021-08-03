package crimsonfluff.crimsongoats.entities;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.client.model.GoatModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrimsonGoatRenderer extends MobRenderer<CrimsonGoatEntity, GoatModel<CrimsonGoatEntity>> {
    private final ResourceLocation WHITE_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/white.png");
    private final ResourceLocation ORANGE_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/orange.png");
    private final ResourceLocation MAGENTA_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/magenta.png");
    private final ResourceLocation LIGHT_BLUE_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/light_blue.png");
    private final ResourceLocation YELLOW_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/yellow.png");
    private final ResourceLocation LIME_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/lime.png");
    private final ResourceLocation PINK_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/pink.png");
    private final ResourceLocation GRAY_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/gray.png");
    private final ResourceLocation LIGHT_GRAY_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/light_gray.png");
    private final ResourceLocation CYAN_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/cyan.png");
    private final ResourceLocation PURPLE_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/purple.png");
    private final ResourceLocation BLUE_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/blue.png");
    private final ResourceLocation BROWN_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/brown.png");
    private final ResourceLocation GREEN_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/green.png");
    private final ResourceLocation RED_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/red.png");
    private final ResourceLocation BLACK_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/black.png");
    private final ResourceLocation MISSING_LOC = new ResourceLocation(CrimsonGoats.MOD_ID, "textures/entity/missing.png");

    public CrimsonGoatRenderer(EntityRendererProvider.Context context) {
        super(context, new GoatModel<>(context.bakeLayer(ModelLayers.GOAT)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrimsonGoatEntity entityIn) {
//        CrimsonGoats.LOGGER.info("RENDER:");
        switch (entityIn.getEntityData().get(CrimsonGoatEntity.DATA_COLOUR)) {
            default -> { return WHITE_LOC; }
            case 1 -> { return ORANGE_LOC; }
            case 2 -> { return MAGENTA_LOC; }
            case 3 -> { return LIGHT_BLUE_LOC; }
            case 4 -> { return YELLOW_LOC; }
            case 5 -> { return LIME_LOC; }
            case 6 -> { return PINK_LOC; }
            case 7 -> { return GRAY_LOC; }
            case 8 -> { return LIGHT_GRAY_LOC; }
            case 9 -> { return CYAN_LOC; }
            case 10 -> { return PURPLE_LOC; }
            case 11 -> { return BLUE_LOC; }
            case 12 -> { return BROWN_LOC; }
            case 13 -> { return GREEN_LOC; }
            case 14 -> { return RED_LOC; }
            case 15 -> { return BLACK_LOC; }
            case 16 -> { return MISSING_LOC; }
        }
    }
}
