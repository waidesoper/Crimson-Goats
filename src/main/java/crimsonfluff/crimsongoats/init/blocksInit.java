package crimsonfluff.crimsongoats.init;

import crimsonfluff.crimsongoats.CrimsonGoats;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class blocksInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CrimsonGoats.MOD_ID);

    public static final RegistryObject<Block> GOAT_MISSING_WOOL_BLOCK = BLOCKS.register("missing_wool", ()->
        new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_PINK).strength(0.8F).sound(SoundType.WOOL)));

}
