package crimsonfluff.crimsongoats.entities;

import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.level.Level;

public class CrimsonGoatShearedEntity extends Goat {
    private static final EntityDataAccessor<Integer> DATA_COLOUR = SynchedEntityData.defineId(CrimsonGoatShearedEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_TIMER = SynchedEntityData.defineId(CrimsonGoatShearedEntity.class, EntityDataSerializers.INT);

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_COLOUR, 0);
        this.entityData.define(DATA_TIMER, 2000 + this.level.random.nextInt(2000));
    }

    public CrimsonGoatShearedEntity(EntityType<? extends Goat> entityIn, Level levelIn) {
        super(entityIn, levelIn);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 10.0D)
            .add(Attributes.ATTACK_DAMAGE, 2.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Color", this.entityData.get(DATA_COLOUR));
        tag.putInt("Timer", this.entityData.get(DATA_TIMER));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_COLOUR, tag.getInt("Color"));
        this.entityData.set(DATA_TIMER, tag.getInt("Timer"));
    }

    @Override
    public void tick() {
        super.tick();

        this.entityData.set(DATA_TIMER, this.entityData.get(DATA_TIMER) - 1);
        if (this.entityData.get(DATA_TIMER) == 0) {
            CrimsonGoatEntity mimic;
            mimic = entitiesInit.CRIMSON_GOAT.get().create(this.level);

            if (mimic != null) {
                mimic.setColour(this.entityData.get(DATA_COLOUR));
                mimic.copyPosition(this);
                mimic.setCustomName(this.getCustomName());
                mimic.setBaby(this.isBaby());
                mimic.setInvulnerable(this.isInvulnerable());
                mimic.setHealth(this.getHealth());
                // set maximum health too

                this.level.addFreshEntity(mimic);
            }

            this.remove(RemovalReason.DISCARDED);
        }
    }

    public void setColour(int c) {
        this.entityData.set(DATA_COLOUR, c);
    }
}
