package crimsonfluff.crimsongoats.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.passive.GoatEntity;

public class initAttributes {
    public static void register() {
        FabricDefaultAttributeRegistry.register(initEntities.GOAT, GoatEntity.createGoatAttributes());
    }
}
