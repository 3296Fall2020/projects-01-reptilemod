package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.blocks.GilaHideBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockTypes {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reptiles.MOD_ID);

    public static final RegistryObject<Block> GILA_HIDE_SAND = BLOCKS.register("gila_hide_sand",
            ()-> new GilaHideBlock(Blocks.SAND, AbstractBlock.Properties.create(Material.SAND)));

}
