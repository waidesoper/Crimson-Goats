package crimsonfluff.crimsongoats.entity;

import crimsonfluff.crimsongoats.init.initEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class CrimsonGoatShearedEntity extends GoatEntity {
    public int iGOAT_COLOUR = 0;
    public int iGOAT_TIMER;

    public CrimsonGoatShearedEntity(EntityType<? extends GoatEntity> entityIn, World levelIn) {
        super(entityIn, levelIn);
        this.iGOAT_TIMER = random.nextInt(2000) + 2000;
    }

//    public static DefaultAttributeContainer.Builder createGoatAttributes() {
//        return MobEntity.createMobAttributes()
//            .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
//            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224D)
//            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
//    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);

        tag.putByte("Color", (byte)this.iGOAT_COLOUR);
        tag.putInt("Timer", this.iGOAT_TIMER);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);

        // else when entity is created any values set in constructor will be overwritten
        if (tag.contains("color"))
            this.iGOAT_COLOUR = tag.getByte("Color");

        if (tag.contains("Timer"))
            this.iGOAT_TIMER = tag.getInt("Timer");
    }

    @Override
    public void tick() {
        super.tick();

        if (this.world.isClient) return;

        iGOAT_TIMER--;
        if (iGOAT_TIMER == 0) {
            CrimsonGoatEntity mimic;
            switch (iGOAT_COLOUR) {
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
                NbtCompound oldGoat = this.writeNbt(new NbtCompound());
                oldGoat.remove("UUID");
                mimic.readNbt(oldGoat);

                this.world.spawnEntity(mimic);
            }

            this.remove(RemovalReason.DISCARDED);
        }
    }
}
