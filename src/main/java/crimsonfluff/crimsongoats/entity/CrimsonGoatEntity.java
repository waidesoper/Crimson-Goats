package crimsonfluff.crimsongoats.entity;

import crimsonfluff.crimsongoats.init.initBlocks;
import crimsonfluff.crimsongoats.init.initEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.GoatBrain;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CrimsonGoatEntity extends GoatEntity implements Shearable {
    public int iGOAT_COLOUR;

    public CrimsonGoatEntity(EntityType<? extends GoatEntity> entityIn, World levelIn, int GOAT_COLOUR) {
        super(entityIn, levelIn);
        this.iGOAT_COLOUR = GOAT_COLOUR;
    }

    public ActionResult interactMob(PlayerEntity playerIn, Hand hand) {
        ItemStack itemStack = playerIn.getStackInHand(hand);

        if (itemStack.getItem() instanceof ShearsItem) {
            if (! this.world.isClient) {
                this.sheared(SoundCategory.PLAYERS);
                this.emitGameEvent(GameEvent.SHEAR, playerIn);

                itemStack.damage(1, playerIn, plyr -> plyr.sendToolBreakStatus(hand));

                return ActionResult.SUCCESS;
            } else
                return ActionResult.CONSUME;

        } else if (itemStack.getItem() instanceof DyeItem) {
            if (! this.world.isClient) {
                this.remove(RemovalReason.DISCARDED);

                CrimsonGoatEntity mimic;
                switch (((DyeItem) itemStack.getItem()).getColor().getId()) {
                    default -> mimic = initEntities.GOAT_WHITE.create(this.world);
                    case 1 -> mimic = initEntities.GOAT_ORANGE.create(this.world);
                    case 2 -> mimic = initEntities.GOAT_MAGENTA.create(this.world);
                    case 3 -> mimic = initEntities.GOAT_LIGHT_BLUE.create(this.world);
                    case 4 -> mimic = initEntities.GOAT_YELLOW.create(this.world);
                    case 5 -> mimic = initEntities.GOAT_LIME.create(this.world);
                    case 6 -> mimic = initEntities.GOAT_PINK.create(this.world);
                    case 7 -> mimic = initEntities.GOAT_GRAY.create(this.world);
                    case 8 -> mimic = initEntities.GOAT_LIGHT_GRAY.create(this.world);
                    case 9 -> mimic = initEntities.GOAT_CYAN.create(this.world);
                    case 10 -> mimic = initEntities.GOAT_PURPLE.create(this.world);
                    case 11 -> mimic = initEntities.GOAT_BLUE.create(this.world);
                    case 12 -> mimic = initEntities.GOAT_BROWN.create(this.world);
                    case 13 -> mimic = initEntities.GOAT_GREEN.create(this.world);
                    case 14 -> mimic = initEntities.GOAT_RED.create(this.world);
                    case 15 -> mimic = initEntities.GOAT_BLACK.create(this.world);
                }

                if (mimic != null) {
                    NbtCompound oldGoat = this.writeNbt(new NbtCompound());
                    oldGoat.remove("UUID");
                    mimic.readNbt(oldGoat);

                    mimic.bodyYaw = this.bodyYaw;
                    mimic.headYaw = this.headYaw;

                    this.world.spawnEntity(mimic);
                }

                return ActionResult.SUCCESS;
            }
        }

        return super.interactMob(playerIn, hand);
    }

    @Override
    public GoatEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        CrimsonGoatEntity mimic;
        switch (this.iGOAT_COLOUR) {
            default -> mimic = initEntities.GOAT_WHITE.create(this.world);
            case 1 -> mimic = initEntities.GOAT_ORANGE.create(this.world);
            case 2 -> mimic = initEntities.GOAT_MAGENTA.create(this.world);
            case 3 -> mimic = initEntities.GOAT_LIGHT_BLUE.create(this.world);
            case 4 -> mimic = initEntities.GOAT_YELLOW.create(this.world);
            case 5 -> mimic = initEntities.GOAT_LIME.create(this.world);
            case 6 -> mimic = initEntities.GOAT_PINK.create(this.world);
            case 7 -> mimic = initEntities.GOAT_GRAY.create(this.world);
            case 8 -> mimic = initEntities.GOAT_LIGHT_GRAY.create(this.world);
            case 9 -> mimic = initEntities.GOAT_CYAN.create(this.world);
            case 10 -> mimic = initEntities.GOAT_PURPLE.create(this.world);
            case 11 -> mimic = initEntities.GOAT_BLUE.create(this.world);
            case 12 -> mimic = initEntities.GOAT_BROWN.create(this.world);
            case 13 -> mimic = initEntities.GOAT_GREEN.create(this.world);
            case 14 -> mimic = initEntities.GOAT_RED.create(this.world);
            case 15 -> mimic = initEntities.GOAT_BLACK.create(this.world);
            case 16 -> mimic = initEntities.GOAT_MISSING.create(this.world);
        }

        if (mimic != null) {
            GoatBrain.resetLongJumpCooldown(mimic);     // access widener

            boolean bl = passiveEntity instanceof CrimsonGoatEntity && ((CrimsonGoatEntity)passiveEntity).isScreaming();
            mimic.setScreaming(bl || serverWorld.getRandom().nextDouble() < 0.02D);
            mimic.iGOAT_COLOUR = this.iGOAT_COLOUR;
        }

        return mimic;
    }

    @Override
    public void sheared(SoundCategory shearedSoundCategory) {
//            if (! CrimsonGoats.CONFIGURATION.enableShearing.get()) return InteractionResult.CONSUME;

        this.world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);

        ItemStack item;
        switch (this.iGOAT_COLOUR) {
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

            CrimsonGoatShearedEntity mimic = this.iGOAT_COLOUR == 16
                ? initEntities.GOAT_MISSING_SHEARED.create(this.world)
                : initEntities.GOAT_SHEARED.create(this.world);

            if (mimic != null) {
                NbtCompound oldGoat = this.writeNbt(new NbtCompound());
                oldGoat.remove("UUID");
                mimic.readNbt(oldGoat);

                mimic.bodyYaw = this.bodyYaw;
                mimic.headYaw = this.headYaw;

                mimic.iGOAT_COLOUR = this.iGOAT_COLOUR;
                this.world.spawnEntity(mimic);

                this.remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    public boolean isShearable() { return this.isAlive() && !this.isBaby(); }
}
