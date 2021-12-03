package crimsonfluff.crimsongoats.entity;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.init.initBlocks;
import crimsonfluff.crimsongoats.init.initEntities;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.GoatBrain;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CrimsonGoatEntity extends GoatEntity {
    public static final TrackedData<Byte> iGOAT_COLOUR = DataTracker.registerData(CrimsonGoatEntity.class, TrackedDataHandlerRegistry.BYTE);
    public static final TrackedData<Boolean> iSHEARED = DataTracker.registerData(CrimsonGoatEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
//    public static final TrackedData<String> sTEXTURE = DataTracker.registerData(CrimsonGoatEntity.class, TrackedDataHandlerRegistry.STRING);
    public boolean isSheared = false;
    public Identifier texture;

    public CrimsonGoatEntity(EntityType<? extends GoatEntity> entityIn, World levelIn) {
        super(entityIn, levelIn);
    }

    public ActionResult interactMob(PlayerEntity playerIn, Hand hand) {
        ItemStack itemstack = playerIn.getStackInHand(hand);
        if (itemstack.getItem() instanceof ShearsItem) {        // allow modded shears

//            if (! CrimsonGoats.CONFIGURATION.enableShearing.get()) return InteractionResult.CONSUME;

            if (! this.world.isClient && ! this.isBaby()) {
                world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
                this.emitGameEvent(GameEvent.SHEAR, playerIn);
                itemstack.damage(1, playerIn, (p_29822_) -> { p_29822_.sendToolBreakStatus(hand); });

                ItemStack item;
                switch (this.dataTracker.get(iGOAT_COLOUR)) {
                    default -> item = new ItemStack(Items.WHITE_WOOL);
                    case 1 -> item = new ItemStack(Items.ORANGE_WOOL);
                    case 2 -> item = new ItemStack(Items.MAGENTA_WOOL);
                    case 3 -> item = new ItemStack(Items.LIGHT_BLUE_WOOL);
                    case 4 -> item = new ItemStack(Items.YELLOW_WOOL);
                    case 5 -> item = new ItemStack(Items.LIME_WOOL);
                    case 6 -> item = new ItemStack(Items.PINK_WOOL);
                    case 7 -> item = new ItemStack(Items.GRAY_WOOL);
                    case 8 -> item = new ItemStack(Items.LIGHT_GRAY_WOOL);
                    case 9 -> item = new ItemStack(Items.CYAN_WOOL);
                    case 10 -> item = new ItemStack(Items.PURPLE_WOOL);
                    case 11 -> item = new ItemStack(Items.BLUE_WOOL);
                    case 12 -> item = new ItemStack(Items.BROWN_WOOL);
                    case 13 -> item = new ItemStack(Items.GREEN_WOOL);
                    case 14 -> item = new ItemStack(Items.RED_WOOL);
                    case 15 -> item = new ItemStack(Items.BLACK_WOOL);
                    case 16 -> item = new ItemStack(initBlocks.MISSING_WOOL);
                }

                ItemEntity itemEntity = this.dropStack(item);
                if (itemEntity != null) {
                    itemEntity.setVelocity(itemEntity.getVelocity().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));

                    this.dataTracker.set(iSHEARED, true);
                }

                return ActionResult.SUCCESS;
            }
            else return ActionResult.CONSUME;

        } else if (itemstack.getItem() instanceof DyeItem) {
            if (! this.world.isClient) {
                DyeColor dd = ((DyeItem) itemstack.getItem()).getColor();
                this.dataTracker.set(iGOAT_COLOUR, (byte)dd.ordinal());
//                this.dataTracker.set(sTEXTURE, getTexture(dd.ord));
                this.texture = new Identifier(CrimsonGoats.MOD_ID, "textures/entity/goat_" + dd.getName());

                return ActionResult.SUCCESS;

            } else return ActionResult.CONSUME;

        } else return super.interactMob(playerIn, hand);
    }

    @Override
    public GoatEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        CrimsonGoatEntity mimic = initEntities.GOAT.create(this.world);

        if (mimic != null) {
            GoatBrain.resetLongJumpCooldown(mimic);     // TODO: access widener
            boolean bl = passiveEntity instanceof CrimsonGoatEntity && ((CrimsonGoatEntity)passiveEntity).isScreaming();
            mimic.setScreaming(bl || serverWorld.getRandom().nextDouble() < 0.02D);
            mimic.dataTracker.set(iGOAT_COLOUR, this.dataTracker.get(iGOAT_COLOUR));
        }

        return mimic;
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        DyeColor dd = generateDefaultColor(world.getRandom());

        this.dataTracker.set(iGOAT_COLOUR, (byte)dd.ordinal());
        this.texture = new Identifier(CrimsonGoats.MOD_ID, "textures/entity/" + dd.getName() + ".png");

        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    public DyeColor generateDefaultColor(Random random) {
        return DyeColor.byId(random.nextInt(16));
        //        int i = random.nextInt(100);
//        if (i < 5) {
//            return DyeColor.BLACK;
//        } else if (i < 10) {
//            return DyeColor.GRAY;
//        } else if (i < 15) {
//            return DyeColor.LIGHT_GRAY;
//        } else if (i < 18) {
//            return DyeColor.BROWN;
//        } else {
//            return random.nextInt(500) == 0 ? DyeColor.PINK : DyeColor.WHITE;
//        }
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Sheared", this.dataTracker.get(iSHEARED));
        nbt.putByte("Color", this.dataTracker.get(iGOAT_COLOUR));
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);

        if (nbt.contains("Sheared"))
            this.dataTracker.set(iSHEARED, nbt.getBoolean("Sheared"));

        if (nbt.contains("Color"))
            this.dataTracker.set(iGOAT_COLOUR, nbt.getByte("Color"));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(iGOAT_COLOUR, (byte)0);
        this.dataTracker.startTracking(iSHEARED, false);
    }
}
