package edu.temple.reptiles.blocks;


import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.init.ModTileEntityTypes;
import edu.temple.reptiles.tileentity.ClimbTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;


public class ClimbBlock extends Block{

    public ClimbBlock(){
        super(Block.Properties.create(Material.WOOD));
    }

    @Override
    public boolean hasTileEntity(BlockState state){
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world){
        return ModTileEntityTypes.CLIMB.get().create();
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        Reptiles.LOGGER.info("Entity collided:", entityIn);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof ClimbTileEntity) {
            ((ClimbTileEntity)tileentity).onEntityCollision(entityIn);
        }

        super.onEntityCollision(state, worldIn, pos, entityIn);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(0.1,0.0,0.1,15.9,16.0,15.9 );
    }


}
