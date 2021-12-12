package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class initSounds {
    public static final Identifier SOUND_GOATY = new Identifier(CrimsonGoats.MOD_ID, "goaty");
    public static SoundEvent SOUND_GOATY_EVENT = new SoundEvent(SOUND_GOATY);
    public static BlockSoundGroup SOUND_GOATY_GROUP = new BlockSoundGroup(1f, 1f, SOUND_GOATY_EVENT, SOUND_GOATY_EVENT, SOUND_GOATY_EVENT, SOUND_GOATY_EVENT, SOUND_GOATY_EVENT);

    public static void register() {
        Registry.register(Registry.SOUND_EVENT, SOUND_GOATY, SOUND_GOATY_EVENT);
    }
}
