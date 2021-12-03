package crimsonfluff.crimsongoats.entity;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.GoatEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class CrimsonGoatRenderer extends MobEntityRenderer<CrimsonGoatEntity, GoatEntityModel<CrimsonGoatEntity>> {
    private static final CrimsonGoatShearedModel<CrimsonGoatEntity> chickenModel = new CrimsonGoatShearedModel<>(CrimsonGoatShearedModel.getTexturedModelData().createModel());

    public CrimsonGoatRenderer(EntityRendererFactory.Context context) {
        super(context, new GoatEntityModel(context.getPart(EntityModelLayers.GOAT)), 0.7F);
    }

    @Nullable
    @Override
    protected RenderLayer getRenderLayer(CrimsonGoatEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
        if (entity.getDataTracker().get(CrimsonGoatEntity.iSHEARED)) {
            Byte d = entity.getDataTracker().get(CrimsonGoatEntity.iGOAT_COLOUR);
            RenderLayer renderType = chickenModel.getLayer(new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + DyeColor.byId(d).getName() + ".png"));
            return renderType;

        } else
            return super.getRenderLayer(entity, showBody, translucent, showOutline);
    }

//    @Override
//    public void render(CrimsonGoatEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
//        if (mobEntity.getDataTracker().get(CrimsonGoatEntity.iSHEARED)) {
//            Byte d = mobEntity.getDataTracker().get(CrimsonGoatEntity.iGOAT_COLOUR);
//
//            RenderLayer renderType = chickenModel.getLayer(new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + DyeColor.byId(d).getName() + ".png"));
//            VertexConsumer vertexBuilder = vertexConsumerProvider.getBuffer(renderType);
//
//            int o = getOverlay(mobEntity, this.getAnimationCounter(mobEntity, g));
//
//            matrixStack.push();
//            //matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180));
//            chickenModel.render(matrixStack, vertexBuilder, i, o, 1, 1, 1, 1);
//            matrixStack.pop();
//
//        } else
//            super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
//    }

    @Override
    public Identifier getTexture(CrimsonGoatEntity goatEntity) {
        Byte d = goatEntity.getDataTracker().get(CrimsonGoatEntity.iGOAT_COLOUR);

        return new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + DyeColor.byId(d).getName() + ".png");
    }
}
