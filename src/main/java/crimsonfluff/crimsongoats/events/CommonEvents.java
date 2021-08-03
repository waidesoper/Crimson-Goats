package crimsonfluff.crimsongoats.events;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entities.CrimsonGoatShearedEntity;
import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
            switch (event.getWorld().random.nextInt(16)) {
                default -> mimic = entitiesInit.GOAT_WHITE.get().create(event.getWorld());
                case 1 -> mimic = entitiesInit.GOAT_ORANGE.get().create(event.getWorld());
                case 2 -> mimic = entitiesInit.GOAT_MAGENTA.get().create(event.getWorld());
                case 3 -> mimic = entitiesInit.GOAT_LIGHT_BLUE.get().create(event.getWorld());
                case 4 -> mimic = entitiesInit.GOAT_YELLOW.get().create(event.getWorld());
                case 5 -> mimic = entitiesInit.GOAT_LIME.get().create(event.getWorld());
                case 6 -> mimic = entitiesInit.GOAT_PINK.get().create(event.getWorld());
                case 7 -> mimic = entitiesInit.GOAT_GRAY.get().create(event.getWorld());
                case 8 -> mimic = entitiesInit.GOAT_LIGHT_GRAY.get().create(event.getWorld());
                case 9 -> mimic = entitiesInit.GOAT_CYAN.get().create(event.getWorld());
                case 10 -> mimic = entitiesInit.GOAT_PURPLE.get().create(event.getWorld());
                case 11 -> mimic = entitiesInit.GOAT_BLUE.get().create(event.getWorld());
                case 12 -> mimic = entitiesInit.GOAT_BROWN.get().create(event.getWorld());
                case 13 -> mimic = entitiesInit.GOAT_GREEN.get().create(event.getWorld());
                case 14 -> mimic = entitiesInit.GOAT_RED.get().create(event.getWorld());
                case 15 -> mimic = entitiesInit.GOAT_BLACK.get().create(event.getWorld());
            }

            if (mimic != null) {
                mimic.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
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

        if (spawns.removeIf(e -> e.type == EntityType.GOAT)) {
            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_WHITE.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_ORANGE.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_MAGENTA.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_LIGHT_BLUE.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_YELLOW.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_LIME.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_PINK.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_GRAY.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_LIGHT_GRAY.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_CYAN.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_BLUE.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_BROWN.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_RED.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_BROWN.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_BLACK.get(), 10, 4, 6));
//            spawns.add(new MobSpawnSettings.SpawnerData(entitiesInit.GOAT_PURPLE.get(), 10, 4, 6));
        }
    }
}
