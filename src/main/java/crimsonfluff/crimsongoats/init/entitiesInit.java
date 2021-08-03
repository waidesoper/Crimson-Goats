package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class entitiesInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CrimsonGoats.MOD_ID);

    public static final RegistryObject<EntityType<CrimsonGoatEntity>> CRIMSON_GOAT = ENTITIES.register("crimson_goat",
        () -> EntityType.Builder.of(CrimsonGoatEntity::new, MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "crimson_goat").toString()));

    public static final RegistryObject<EntityType<CrimsonGoatShearedEntity>> CRIMSON_GOAT_SHEARED = ENTITIES.register("crimson_goat_sheared",
        () -> EntityType.Builder.of(CrimsonGoatShearedEntity::new, MobCategory.CREATURE)
            .sized(0.9F, 1.3F).clientTrackingRange(10).build(new ResourceLocation(CrimsonGoats.MOD_ID, "crimson_goat_sheared").toString()));
}
