package crimsonfluff.crimsongoats.entities;

import crimsonfluff.crimsongoats.init.entitiesInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.level.Level;

public class CrimsonGoatShearedEntity extends Goat {
    public int iGOAT_COLOUR = 0;
    public int iGOAT_TIMER = random.nextInt(2000) + 2000;

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
        tag.putByte("Color", (byte)this.iGOAT_COLOUR);
        tag.putInt("Timer", this.iGOAT_TIMER);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.iGOAT_COLOUR = tag.getByte("Color");
        this.iGOAT_TIMER = tag.getInt("Timer");
    }

    @Override
    public void tick() {
        super.tick();

        iGOAT_TIMER--;
        if (iGOAT_TIMER == 0) {
            CrimsonGoatEntity mimic;
            switch (iGOAT_COLOUR) {
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
}
