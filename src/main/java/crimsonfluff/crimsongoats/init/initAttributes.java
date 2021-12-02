package crimsonfluff.crimsongoats.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.passive.GoatEntity;

public class initAttributes {
    public static void register() {
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_WHITE, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_ORANGE, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_MAGENTA, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_LIGHT_BLUE, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_YELLOW, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_LIME, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_PINK, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_GRAY, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_LIGHT_GRAY, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_CYAN, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_BLUE, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_BROWN, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_GREEN, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_RED, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_BLACK, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_PURPLE, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_MISSING, GoatEntity.createGoatAttributes());

        FabricDefaultAttributeRegistry.register(initEntities.GOAT_SHEARED, GoatEntity.createGoatAttributes());
        FabricDefaultAttributeRegistry.register(initEntities.GOAT_MISSING_SHEARED, GoatEntity.createGoatAttributes());
    }
}
