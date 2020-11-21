package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.blocks.ClimbBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockTypes {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reptiles.MOD_ID);

    public static final RegistryObject<Block> CLIMB_BLOCK = BLOCKS.register("climb_block", ClimbBlock::new);

    public static final RegistryObject<Block> TANK = BLOCKS.register("tank", () -> new Block(Block.Properties.from(Blocks.GLASS)));
}
