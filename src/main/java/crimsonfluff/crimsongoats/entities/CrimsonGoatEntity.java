package crimsonfluff.crimsongoats.entities;

import crimsonfluff.crimsongoats.CrimsonGoats;
import crimsonfluff.crimsongoats.init.entitiesInit;
import crimsonfluff.crimsongoats.init.itemsInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class CrimsonGoatEntity extends Goat {
    public static final EntityDataAccessor<Integer> DATA_COLOUR = SynchedEntityData.defineId(CrimsonGoatEntity.class, EntityDataSerializers.INT);

    public CrimsonGoatEntity(EntityType<? extends Goat> entityIn, Level levelIn) {
        super(entityIn, levelIn);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_COLOUR, 0);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 10.0D)
            .add(Attributes.ATTACK_DAMAGE, 2.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    public InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if (itemstack.getItem() instanceof ShearsItem) {        // allow modded shears

            if (! CrimsonGoats.CONFIGURATION.enableShearing.get()) return InteractionResult.CONSUME;

            if (! this.level.isClientSide && ! this.isBaby()) {
                this.level.playSound(null, playerIn, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0F, 1.0F);
                this.gameEvent(GameEvent.SHEAR, playerIn);
                itemstack.hurtAndBreak(1, playerIn, (p_29822_) -> { p_29822_.broadcastBreakEvent(hand); });

                ItemStack item;
                switch (this.entityData.get(DATA_COLOUR)) {
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
                    case 16 -> item = new ItemStack(itemsInit.GOAT_MISSING_WOOL.get());
                }

                ItemEntity itementity = this.spawnAtLocation(item);
                if (itementity != null) {
                    itementity.setDeltaMovement(itementity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));

                    CrimsonGoatShearedEntity mimic = entitiesInit.CRIMSON_GOAT_SHEARED.get().create(this.level);
                    if (mimic != null) {
                        mimic.copyPosition(this);
                        mimic.setCustomName(this.getCustomName());
                        mimic.setBaby(this.isBaby());
                        mimic.setInvulnerable(this.isInvulnerable());
                        mimic.setHealth(this.getHealth());
                        // set maximum health too

                        mimic.setColour(this.entityData.get(DATA_COLOUR));
                        this.level.addFreshEntity(mimic);

                        this.remove(RemovalReason.DISCARDED);
                    }
                }

                return InteractionResult.SUCCESS;
            }
            else return InteractionResult.CONSUME;

        } else if (itemstack.getItem() instanceof DyeItem) {
            if (! this.level.isClientSide) {
                this.remove(RemovalReason.DISCARDED);

                CrimsonGoatEntity mimic;
                mimic = entitiesInit.CRIMSON_GOAT.get().create(this.level);

                if (mimic != null) {
                    mimic.setColour(((DyeItem) itemstack.getItem()).getDyeColor().ordinal());
                    mimic.copyPosition(this);
                    mimic.setCustomName(this.getCustomName());
                    mimic.setBaby(this.isBaby());
                    mimic.setInvulnerable(this.isInvulnerable());
                    mimic.setHealth(this.getHealth());
                    // set maximum health too

                    this.level.addFreshEntity(mimic);

                    itemstack.shrink(1);
                }

                return InteractionResult.SUCCESS;

            } else return InteractionResult.CONSUME;

        } else return super.mobInteract(playerIn, hand);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Color", this.entityData.get(DATA_COLOUR));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_COLOUR, tag.getInt("Color"));
    }

    public void setColour(int c) {
        this.entityData.set(DATA_COLOUR, c);
    }
}
