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

                mimic.bodyYaw = this.bodyYaw;
                mimic.headYaw = this.headYaw;

                this.world.spawnEntity(mimic);
            }

            this.remove(RemovalReason.DISCARDED);
        }
    }

    // dont work the way I want
//    @Override
//    public Text getName() {
//        CrimsonGoats.LOGGER.info("COL: " + this.iGOAT_COLOUR);
//
//        switch (this.iGOAT_COLOUR) {
//            default -> { return initEntities.GOAT_WHITE.getName(); }
//            case 1 -> { return initEntities.GOAT_ORANGE.getName(); }
//            case 2 -> { return initEntities.GOAT_MAGENTA.getName(); }
//            case 3 -> { return initEntities.GOAT_LIGHT_BLUE.getName(); }
//            case 4 -> { return initEntities.GOAT_YELLOW.getName(); }
//            case 5 -> { return initEntities.GOAT_LIME.getName(); }
//            case 6 -> { return initEntities.GOAT_PINK.getName(); }
//            case 7 -> { return initEntities.GOAT_GRAY.getName(); }
//            case 8 -> { return initEntities.GOAT_LIGHT_GRAY.getName(); }
//            case 9 -> { return initEntities.GOAT_CYAN.getName(); }
//            case 10 -> { return initEntities.GOAT_PURPLE.getName(); }
//            case 11 -> { return initEntities.GOAT_BLUE.getName(); }
//            case 12 -> { return initEntities.GOAT_BROWN.getName(); }
//            case 13 -> { return initEntities.GOAT_GREEN.getName(); }
//            case 14 -> { return initEntities.GOAT_RED.getName(); }
//            case 15 -> { return initEntities.GOAT_BLACK.getName(); }
//            case 16 -> { return initEntities.GOAT_MISSING.getName(); }
//        }
//    }
}
