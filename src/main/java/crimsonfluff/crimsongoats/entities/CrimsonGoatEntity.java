package crimsonfluff.crimsongoats.entities;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.init.entitiesInit;
import crimsonfluff.crimsongoats.init.itemsInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class CrimsonGoatEntity extends Goat {
    private final int iGOAT_COLOUR;
//    private int iGOAT_SHEAR_COLOUR;

    public CrimsonGoatEntity(EntityType<? extends Goat> entityIn, Level levelIn, int GOAT_COLOUR) {
        super(entityIn, levelIn);
        this.iGOAT_COLOUR = GOAT_COLOUR;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().
            add(Attributes.MAX_HEALTH, 4.0D).
            add(Attributes.ATTACK_DAMAGE, 4.0D).
            add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

//    public void addAdditionalSaveData(CompoundTag tag) {
//        super.addAdditionalSaveData(tag);
//        //tag.putBoolean("Sheared", this.isSheared());
////        tag.putByte("Color", (byte)this.iGOAT_COLOUR);
//    }
//
//    public void readAdditionalSaveData(CompoundTag tag) {
//        super.readAdditionalSaveData(tag);
//        //this.setSheared(tag.getBoolean("Sheared"));
////        this.iGOAT_COLOUR = tag.getByte("Color");
//    }

    public InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if (itemstack.getItem() == Items.SHEARS) {

            if (! CrimsonGoats.CONFIGURATION.enableShearing.get()) return InteractionResult.CONSUME;

            if (! this.level.isClientSide) {
                this.level.playSound(null, this, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);
                this.gameEvent(GameEvent.SHEAR, playerIn);
                itemstack.hurtAndBreak(1, playerIn, (p_29822_) -> { p_29822_.broadcastBreakEvent(hand); });

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
                    case 99 -> item = new ItemStack(itemsInit.GOAT_MISSING_WOOL.get());
                }

                ItemEntity itementity = this.spawnAtLocation(item);
                if (itementity != null) {
                    itementity.setDeltaMovement(itementity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));

                    this.remove(RemovalReason.DISCARDED);

                    CrimsonGoatEntity mimic = entitiesInit.GOAT_WHITE.get().create(this.level);
                    if (mimic != null) {
                        mimic.copyPosition(this);
                        this.level.addFreshEntity(mimic);

                        //mimic.getPersistentData().putInt("shearColour", iGOAT_COLOUR);
                    }
                }

                return InteractionResult.SUCCESS;
            }
            else return InteractionResult.CONSUME;

        } else if (itemstack.getItem() instanceof DyeItem) {
            if (! this.level.isClientSide) {
                this.remove(RemovalReason.DISCARDED);

                CrimsonGoatEntity mimic;
                switch (((DyeItem) itemstack.getItem()).getDyeColor().getId()) {
                    default -> mimic = entitiesInit.GOAT_WHITE.get().create(this.level);
                    case 1 -> mimic = entitiesInit.GOAT_ORANGE.get().create(this.level);
                    case 2 -> mimic = entitiesInit.GOAT_MAGENTA.get().create(this.level);
                    case 3 -> mimic = entitiesInit.GOAT_LIGHT_BLUE.get().create(this.level);
                    case 4 -> mimic = entitiesInit.GOAT_YELLOW.get().create(this.level);
                    case 5 -> mimic = entitiesInit.GOAT_LIME.get().create(this.level);
                    case 6 -> mimic = entitiesInit.GOAT_PINK.get().create(this.level);
                    case 7 -> mimic = entitiesInit.GOAT_GRAY.get().create(this.level);
                    case 8 -> mimic = entitiesInit.GOAT_LIGHT_GRAY.get().create(this.level);
                    case 9 -> mimic = entitiesInit.GOAT_CYAN.get().create(this.level);
                    case 10 -> mimic = entitiesInit.GOAT_PURPLE.get().create(this.level);
                    case 11 -> mimic = entitiesInit.GOAT_BLUE.get().create(this.level);
                    case 12 -> mimic = entitiesInit.GOAT_BROWN.get().create(this.level);
                    case 13 -> mimic = entitiesInit.GOAT_GREEN.get().create(this.level);
                    case 14 -> mimic = entitiesInit.GOAT_RED.get().create(this.level);
                    case 15 -> mimic = entitiesInit.GOAT_BLACK.get().create(this.level);
                }

                if (mimic != null) {
                    mimic.copyPosition(this);
                    this.level.addFreshEntity(mimic);
                }

                return InteractionResult.SUCCESS;

            } else return InteractionResult.CONSUME;

        } else return super.mobInteract(playerIn, hand);
    }
}
