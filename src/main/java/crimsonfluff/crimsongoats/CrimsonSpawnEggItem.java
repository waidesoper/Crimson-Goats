package crimsonfluff.crimsongoats;

import crimsonfluff.crimsongoats.entities.CrimsonGoatEntity;
import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CrimsonSpawnEggItem extends net.minecraft.world.item.SpawnEggItem {
    protected static final List<CrimsonSpawnEggItem> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;
    private final int iColour;

    public CrimsonSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, int Colour, final Item.Properties properties) {
        super(null, MaterialColor.COLOR_BLACK.col, MaterialColor.COLOR_PINK.col, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier);
        UNADDED_EGGS.add(this);
        this.iColour = Colour;
    }

    public static void init() {
        final Map<EntityType<?>, net.minecraft.world.item.SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(net.minecraft.world.item.SpawnEggItem.class,null, "f_43201_");
        DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
                EntityType<?> type = ((net.minecraft.world.item.SpawnEggItem) stack.getItem()).getType(stack.getTag());

                type.spawn(source.getLevel(), stack, null, source.getPos().relative(direction), MobSpawnType.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);

                return stack;
            }
        };

        for (final net.minecraft.world.item.SpawnEggItem spawnEgg : UNADDED_EGGS) {
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerBehavior(spawnEgg, dispenseBehaviour);
        }
        UNADDED_EGGS.clear();
    }

//    // this is here to change the last egg in the registry, ie: Missing_Spawn_Egg
//    // it doesn't obey the model file
//    @Override
//    public int getColor(int color) {
//        return color == 0 ? MaterialColor.COLOR_BLACK.col : MaterialColor.COLOR_PINK.col;
//    }

    @Override
    public EntityType<?> getType(CompoundTag nbt) { return this.entityTypeSupplier.get(); }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;

        } else {
            ItemStack itemstack = context.getItemInHand();
            BlockPos blockpos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(Blocks.SPAWNER)) {
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof SpawnerBlockEntity) {
                    BaseSpawner basespawner = ((SpawnerBlockEntity)blockentity).getSpawner();
                    EntityType<?> entitytype1 = this.getType(itemstack.getTag());
                    basespawner.setEntityId(entitytype1);
                    blockentity.setChanged();
                    level.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    itemstack.shrink(1);
                    return InteractionResult.CONSUME;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }

            //CrimsonGoatEntity GOAT = entitiesInit.CRIMSON_GOAT.get().create((ServerLevel)level, null, null, p_43223_.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, ! Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
            CrimsonGoatEntity GOAT = entitiesInit.CRIMSON_GOAT.get().create(level);
            if (GOAT != null) {
                GOAT.setColour(this.iColour);
                GOAT.setPos(blockpos1.getX() + 0.5, blockpos1.getY(), blockpos1.getZ() + 0.5);
                level.addFreshEntity(GOAT);

                itemstack.shrink(1);
                level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            }

            return InteractionResult.CONSUME;
        }
    }
}