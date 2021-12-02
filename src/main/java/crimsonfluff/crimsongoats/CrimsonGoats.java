package crimsonfluff.crimsongoats;

import crimsonfluff.crimsongoats.entity.CrimsonGoatEntity;
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

//  /summon crimsonchickens:blaze ~ ~ ~ {Age:-24000,analyzed:1,strength:10,gain:10,growth:10}
//  /summon crimsonchickens:blaze ~ ~ ~ {analyzed:1,strength:10,gain:10,growth:10}
//  /summon crimsonchickens:angry ~ ~ ~ {analyzed:1,strength:10,gain:10,growth:10}

public class CrimsonGoats implements ModInitializer {
    public static final String MOD_ID = "crimsongoats";
    public static final Logger LOGGER = LogManager.getLogger(CrimsonGoats.class);
    public static final ItemGroup CREATIVE_TAB = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tab"), () -> new ItemStack(initBlocks.MISSING_WOOL));

    public static final EntityModelLayer GOAT_SHEARED_MODEL_LOC = new EntityModelLayer(new Identifier(CrimsonGoats.MOD_ID, "crimson.goat"), "crimson.goat");

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

                BiomeModifications.addSpawn(BiomeSelectors.categories(biome.getCategory()), SpawnGroup.CREATURE, initEntities.GOAT_WHITE, 10, 1, 2);
            }
        });

        // Vanilla chicken from SpawnEgg/Spawner/Summon
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity.getType() == EntityType.GOAT) {
                entity.remove(Entity.RemovalReason.DISCARDED);

                CrimsonGoatEntity mimic = initEntities.GOAT_WHITE.create(serverWorld);
                if (mimic != null) {
//                    entity2.copyPositionAndRotation(entity);

                    NbtCompound nbtCompound = entity.writeNbt(new NbtCompound());
                    nbtCompound.remove("Dimension");
                    nbtCompound.remove("UUID");
                    mimic.readNbt(nbtCompound);

                    serverWorld.spawnEntity(mimic);
                }
            }
        });
    }
}
