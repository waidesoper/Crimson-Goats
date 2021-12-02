package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class initBlocks {
    public static final Block MISSING_WOOL = new Block(AbstractBlock.Settings.of(Material.WOOL, MapColor.PINK)
        .requiresTool()
        .strength(0.5f)
        .sounds(BlockSoundGroup.WOOL)
    );

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(CrimsonGoats.MOD_ID, "missing_wool"), MISSING_WOOL);
    }
}
