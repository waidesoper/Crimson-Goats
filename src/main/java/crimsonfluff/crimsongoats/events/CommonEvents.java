package crimsonfluff.crimsongoats.events;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedEntity;
import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CrimsonGoats.MOD_ID)
public class CommonEvents {
    @SubscribeEvent
    public static void onSpawn(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof CrimsonGoatEntity) return;
        if (event.getEntity() instanceof CrimsonGoatShearedEntity) return;

        // if Minecraft:Goat spawn egg is used then randomise the CrimsonGoatEntity to spawn
        // Minecraft:Goat spawns are blocked from BiomeLoading
        // so this should only happen for Spawn Egg, Spawners etc, not natural spawns
        if (event.getEntity() instanceof Goat) {
            event.setCanceled(true);

            CrimsonGoatEntity mimic;
            mimic = entitiesInit.CRIMSON_GOAT.get().create(event.getWorld());

            if (mimic != null) {
                mimic.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                mimic.setColour(event.getWorld().random.nextInt(17));
                event.getWorld().addFreshEntity(mimic);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        List<MobSpawnSettings.SpawnerData> spawns = event.getSpawns().getSpawner(MobCategory.CREATURE);

//        spawns.forEach(mob-> {
//            if (mob.type == EntityType.GOAT)
//                CrimsonGoats.LOGGER.info("GOAT: " + mob.getWeight() + " : " + mob.minCount + " : " + mob.maxCount);
//        });

        if (spawns.removeIf(e -> e.type == EntityType.GOAT))
            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.CRIMSON_GOAT.get(), 10, 4, 6));
    }
}
