package crimsonfluff.crimsongoats.entity;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.GoatEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

@Environment(EnvType.CLIENT)
public class CrimsonGoatRenderer extends MobEntityRenderer<CrimsonGoatEntity, GoatEntityModel<CrimsonGoatEntity>> {
    private static final CrimsonGoatShearedModel<CrimsonGoatEntity> chickenModel = new CrimsonGoatShearedModel<>(CrimsonGoatShearedModel.getTexturedModelData().createModel());

    public CrimsonGoatRenderer(EntityRendererFactory.Context context) {
        super(context, new GoatEntityModel<>(context.getPart(EntityModelLayers.GOAT)), 0.7F);
    }

//    @Nullable
//    @Override
//    protected RenderLayer getRenderLayer(CrimsonGoatEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
//        if (entity.getDataTracker().get(CrimsonGoatEntity.iSHEARED)) {
//            Byte d = entity.getDataTracker().get(CrimsonGoatEntity.iGOAT_COLOUR);
//            return chickenModel.getLayer(new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + DyeColor.byId(d).getName() + ".png"));
//
//        } else
//            return super.getRenderLayer(entity, showBody, translucent, showOutline);
//    }

    @Override
    public void render(CrimsonGoatEntity mobEntity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
        if (mobEntity.getDataTracker().get(CrimsonGoatEntity.iSHEARED)) {
//            CrimsonGoats.LOGGER.info("BABY: " + mobEntity.isBaby());

//            Byte d = mobEntity.getDataTracker().get(CrimsonGoatEntity.iGOAT_COLOUR);
//            RenderLayer renderType = chickenModel.getLayer(new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + DyeColor.byId(d).getName() + ".png"));
//            VertexConsumer vertexBuilder = vertexConsumerProvider.getBuffer(renderType);

//            int o = getOverlay(mobEntity, this.getAnimationCounter(mobEntity, tickDelta));
//            int o = getOverlay(mobEntity, 0);

//            matrixStack.push();
//            matrixStack.translate(2f,2f,2f);
//            matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180));
//            matrixStack.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(mobEntity.getHorizontalFacing().asRotation()));

//            this.getModel().copyStateTo(chickenModel);
////            chickenModel.animateModel(mobEntity, mobEntity.limbAngle, mobEntity.limbDistance, tickDelta);
//            chickenModel.setAngles(mobEntity, mobEntity.limbAngle, mobEntity.limbDistance, tickDelta, yaw, mobEntity.getHeadPitch());
//            chickenModel.render(matrixStack, vertexConsumerProvider.getBuffer(renderType), light, o, 1, 1, 1, 1);

            renderSheared(mobEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);

//            matrixStack.pop();

        } else
            super.render(mobEntity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);
    }

    @Override
    public Identifier getTexture(CrimsonGoatEntity goatEntity) {
        if (goatEntity.texture == null) {
            Byte d = goatEntity.getDataTracker().get(CrimsonGoatEntity.iGOAT_COLOUR);
            if (d == 16)
                goatEntity.texture = new Identifier(CrimsonGoats.MOD_ID, "textures/entity/missing.png");
            else
                goatEntity.texture = new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + DyeColor.byId(d).getName() + ".png");
        }

        return goatEntity.texture;
    }

    public void renderSheared(CrimsonGoatEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        chickenModel.handSwingProgress = this.getHandSwingProgress(livingEntity, g);
        chickenModel.riding = livingEntity.hasVehicle();
        chickenModel.child = livingEntity.isBaby();
        float h = MathHelper.lerpAngleDegrees(g, livingEntity.prevBodyYaw, livingEntity.bodyYaw);
        float j = MathHelper.lerpAngleDegrees(g, livingEntity.prevHeadYaw, livingEntity.headYaw);
        float k = j - h;
        float l;
        if (livingEntity.hasVehicle() && livingEntity.getVehicle() instanceof LivingEntity) {
            LivingEntity livingEntity2 = (LivingEntity)livingEntity.getVehicle();
            h = MathHelper.lerpAngleDegrees(g, livingEntity2.prevBodyYaw, livingEntity2.bodyYaw);
            k = j - h;
            l = MathHelper.wrapDegrees(k);
            if (l < -85.0F) {
                l = -85.0F;
            }

            if (l >= 85.0F) {
                l = 85.0F;
            }

            h = j - l;
            if (l * l > 2500.0F) {
                h += l * 0.2F;
            }

            k = j - h;
        }

        float livingEntity2 = MathHelper.lerp(g, livingEntity.prevPitch, livingEntity.getPitch());
        if (shouldFlipUpsideDown(livingEntity)) {
            livingEntity2 *= -1.0F;
            k *= -1.0F;
        }

        float m;
        if (livingEntity.getPose() == EntityPose.SLEEPING) {
            Direction sl = livingEntity.getSleepingDirection();
            if (sl != null) {
                m = livingEntity.getEyeHeight(EntityPose.STANDING) - 0.1F;
                matrixStack.translate((double)((float)(-sl.getOffsetX()) * m), 0.0D, (double)((float)(-sl.getOffsetZ()) * m));
            }
        }

        l = this.getAnimationProgress(livingEntity, g);
        this.setupTransforms(livingEntity, matrixStack, l, h, g);
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        this.scale(livingEntity, matrixStack, g);
        matrixStack.translate(0.0D, -1.5010000467300415D, 0.0D);
        m = 0.0F;
        float n = 0.0F;
        if (!livingEntity.hasVehicle() && livingEntity.isAlive()) {
            m = MathHelper.lerp(g, livingEntity.lastLimbDistance, livingEntity.limbDistance);
            n = livingEntity.limbAngle - livingEntity.limbDistance * (1.0F - g);
            if (livingEntity.isBaby()) {
                n *= 3.0F;
            }

            if (m > 1.0F) {
                m = 1.0F;
            }
        }

        chickenModel.animateModel(livingEntity, n, m, g);
        chickenModel.setAngles(livingEntity, n, m, l, k, livingEntity2);
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        boolean bl = this.isVisible(livingEntity);
        boolean bl2 = !bl && !livingEntity.isInvisibleTo(minecraftClient.player);
        boolean bl3 = minecraftClient.hasOutline(livingEntity);
        RenderLayer renderLayer = this.getRenderLayer(livingEntity, bl, bl2, bl3);
        if (renderLayer != null) {
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(renderLayer);
            int o = getOverlay(livingEntity, this.getAnimationCounter(livingEntity, g));
            chickenModel.render(matrixStack, vertexConsumer, i, o, 1.0F, 1.0F, 1.0F, bl2 ? 0.15F : 1.0F);
        }

//        if (!livingEntity.isSpectator()) {
//            Iterator var23 = this.features.iterator();
//
//            while(var23.hasNext()) {
//                FeatureRenderer<T, M> o = (FeatureRenderer)var23.next();
//                o.render(matrixStack, vertexConsumerProvider, i, livingEntity, n, m, g, l, k, livingEntity2);
//            }
//        }

        matrixStack.pop();
//        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
