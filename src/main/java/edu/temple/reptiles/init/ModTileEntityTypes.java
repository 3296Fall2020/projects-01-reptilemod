package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;

import edu.temple.reptiles.tileentity.ClimbTileEntity;
import net.minecraft.tileentity.TileEntityType;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModTileEntityTypes {


    public static DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reptiles.MOD_ID);

    public static final RegistryObject<TileEntityType<ClimbTileEntity>> CLIMB = TILE_ENTITY_TYPES.register("climb",
            () -> TileEntityType.Builder.create(ClimbTileEntity::new, ModBlockTypes.CLIMB_BLOCK.get()).build(null));

}
