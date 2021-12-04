package crimsonfluff.crimsongoats;

import crimsonfluff.crimsongoats.entity.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.entity.CrimsonGoatShearedEntity;
import crimsonfluff.crimsongoats.init.initAttributes;
import crimsonfluff.crimsongoats.init.initBlocks;
import crimsonfluff.crimsongoats.init.initEntities;
import crimsonfluff.crimsongoats.init.initItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.SpawnSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CrimsonGoats implements ModInitializer {
    public static final String MOD_ID = "crimsongoats";
    public static final Logger LOGGER = LogManager.getLogger(CrimsonGoats.class);
    public static final ItemGroup CREATIVE_TAB = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tab"), () -> new ItemStack(initBlocks.MISSING_WOOL));

//    public static final CrimsonChickensConfig CONFIGURATION = AutoConfig.register(CrimsonChickensConfig.class, GsonConfigSerializer::new).getConfig();

    @Override
    public void onInitialize() {
        initItems.register();
        initBlocks.register();
        initAttributes.register();

        Identifier goatID = Registry.ENTITY_TYPE.getId(EntityType.GOAT);
        BuiltinRegistries.BIOME.forEach(biome -> {
            List<SpawnSettings.SpawnEntry> spawns = biome.getSpawnSettings().getSpawnEntries(SpawnGroup.CREATURE).getEntries();
            if (spawns.stream().anyMatch(tag -> tag.type == EntityType.GOAT)) {
                BiomeModifications.create(goatID).add(ModificationPhase.REMOVALS, BiomeSelectors.categories(biome.getCategory()), context -> {
                    context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.CHICKEN);
                });
                BiomeModifications.addSpawn(BiomeSelectors.categories(biome.getCategory()), SpawnGroup.CREATURE, initEntities.GOAT_WHITE, 5, 1, 3);
            }
        });

        // Vanilla chicken from SpawnEgg/Spawner/Summon
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity instanceof CrimsonGoatEntity) return;
            if (entity instanceof CrimsonGoatShearedEntity) return;
            
            if (entity.getType() == EntityType.GOAT) {
                entity.remove(Entity.RemovalReason.DISCARDED);

                CrimsonGoatEntity mimic;
                switch (serverWorld.random.nextInt(16)) {
                    default -> mimic = initEntities.GOAT_WHITE.create(serverWorld);
                    case 1 -> mimic = initEntities.GOAT_ORANGE.create(serverWorld);
                    case 2 -> mimic = initEntities.GOAT_MAGENTA.create(serverWorld);
                    case 3 -> mimic = initEntities.GOAT_LIGHT_BLUE.create(serverWorld);
                    case 4 -> mimic = initEntities.GOAT_YELLOW.create(serverWorld);
                    case 5 -> mimic = initEntities.GOAT_LIME.create(serverWorld);
                    case 6 -> mimic = initEntities.GOAT_PINK.create(serverWorld);
                    case 7 -> mimic = initEntities.GOAT_GRAY.create(serverWorld);
                    case 8 -> mimic = initEntities.GOAT_LIGHT_GRAY.create(serverWorld);
                    case 9 -> mimic = initEntities.GOAT_CYAN.create(serverWorld);
                    case 10 -> mimic = initEntities.GOAT_PURPLE.create(serverWorld);
                    case 11 -> mimic = initEntities.GOAT_BLUE.create(serverWorld);
                    case 12 -> mimic = initEntities.GOAT_BROWN.create(serverWorld);
                    case 13 -> mimic = initEntities.GOAT_GREEN.create(serverWorld);
                    case 14 -> mimic = initEntities.GOAT_RED.create(serverWorld);
                    case 15 -> mimic = initEntities.GOAT_BLACK.create(serverWorld);
                }
                
                if (mimic != null) {
                    NbtCompound nbtCompound = entity.writeNbt(new NbtCompound());
                    nbtCompound.remove("UUID");
                    mimic.readNbt(nbtCompound);

                    mimic.bodyYaw = entity.getYaw();
                    mimic.headYaw = entity.getHeadYaw();

                    serverWorld.spawnEntity(mimic);
                }
            }
        });
    }
}
