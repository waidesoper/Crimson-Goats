package crimsonfluff.crimsongoats.events;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedEntity;
import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrimsonGoats.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event) {
        event.put(entitiesInit.CRIMSON_GOAT.get(), CrimsonGoatEntity.createAttributes().build());

        event.put(entitiesInit.CRIMSON_GOAT_SHEARED.get(), CrimsonGoatShearedEntity.createAttributes().build());
    }
}
