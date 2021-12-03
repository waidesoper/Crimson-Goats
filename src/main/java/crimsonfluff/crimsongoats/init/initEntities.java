package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entity.CrimsonGoatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class initEntities {
    public static final EntityType<CrimsonGoatEntity> GOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(CrimsonGoats.MOD_ID, "goat"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrimsonGoatEntity::new).dimensions(EntityDimensions.fixed(0.9f, 1.3f)).build());
}
