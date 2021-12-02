package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class entitiesInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CrimsonGoats.MOD_ID);

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_WHITE = ENTITIES.register("goat_white",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 0), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_white").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_ORANGE = ENTITIES.register("goat_orange",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 1), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_orange").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_MAGENTA = ENTITIES.register("goat_magenta",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 2), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_magenta").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_LIGHT_BLUE = ENTITIES.register("goat_light_blue",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 3), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_light_blue").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_YELLOW = ENTITIES.register("goat_yellow",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 4), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_yellow").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_LIME = ENTITIES.register("goat_lime",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 5), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_lime").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_PINK = ENTITIES.register("goat_pink",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 6), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_pink").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_GRAY = ENTITIES.register("goat_gray",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 7), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_gray").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_LIGHT_GRAY = ENTITIES.register("goat_light_gray",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 8), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_light_gray").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_CYAN = ENTITIES.register("goat_cyan",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 9), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_cyan").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_PURPLE = ENTITIES.register("goat_purple",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 10), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_purple").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_BLUE = ENTITIES.register("goat_blue",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 11), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_blue").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_BROWN = ENTITIES.register("goat_brown",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 12), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_brown").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_GREEN = ENTITIES.register("goat_green",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 13), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_green").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_RED = ENTITIES.register("goat_red",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 14), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_red").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_BLACK = ENTITIES.register("goat_black",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 15), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_black").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> GOAT_MISSING = ENTITIES.register("goat_missing",
        () -> EntityType.Builder.of((EntityType<CrimsonGoatEntity> p_i48552_1_, Level p_i48552_2_) -> new CrimsonGoatEntity(p_i48552_1_, p_i48552_2_, 16), MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_missing").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatShearedEntity>> GOAT_SHEARED = ENTITIES.register("goat_sheared",
        () -> EntityType.Builder.of(CrimsonGoatShearedEntity::new, MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_sheared").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatShearedEntity>> GOAT_SHEARED_MISSING = ENTITIES.register("goat_sheared_missing",
        () -> EntityType.Builder.of(CrimsonGoatShearedEntity::new, MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "goat_sheared_missing").toString()));
}
