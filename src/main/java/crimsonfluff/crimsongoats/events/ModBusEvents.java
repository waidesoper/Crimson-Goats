package crimsonfluff.crimsongoats.events;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedEntity;
import crimsonfluff.crimsongoats.init.entitiesInit;
import crimsonfluff.crimsongoats.items.CrimsonSpawnEggItem;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrimsonGoats.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event){
        CrimsonSpawnEggItem.init();
    }

    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
        event.put(entitiesInit.GOAT_WHITE.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_ORANGE.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_MAGENTA.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_LIGHT_BLUE.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_YELLOW.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_LIME.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_PINK.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_GRAY.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_LIGHT_GRAY.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_CYAN.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_BLUE.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_BROWN.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_GREEN.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_RED.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_BLACK.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_PURPLE.get(), CrimsonGoatEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_MISSING.get(), CrimsonGoatEntity.createAttributes().build());

        event.put(entitiesInit.GOAT_SHEARED.get(), CrimsonGoatShearedEntity.createAttributes().build());
        event.put(entitiesInit.GOAT_SHEARED_MISSING.get(), CrimsonGoatShearedEntity.createAttributes().build());
    }
}
