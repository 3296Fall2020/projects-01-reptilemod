package edu.temple.reptiles.blocks;


import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.init.ModTileEntityTypes;
import edu.temple.reptiles.tileentity.ClimbTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;



public class ClimbBlock extends Block{
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
//    public static final VoxelShape UP_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,1.0,16.0 );
//    public static final VoxelShape DOWN_SHAPE = Block.makeCuboidShape(0,15.0,0.0,16.0,16.0,16.0 );
    public static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,1.0,16.0,16.0 );
    public static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,15.0,16.0,16.0 );
    public static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,15.0 );
    public static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,1.0 );

    public ClimbBlock(){
        super(AbstractBlock.Properties.create(Material.WOOD));
//        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.UP));
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
//        Reptiles.LOGGER.debug("Entity collided");
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof ClimbTileEntity) {
            ((ClimbTileEntity)tileentity).onEntityCollision(entityIn);
        }

        super.onEntityCollision(state, worldIn, pos, entityIn);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)){
            case EAST:
                return EAST_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            default:
                return NORTH_SHAPE;
        }
//        return VoxelShapes.empty();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rot){
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn){
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(FACING);
    }



}
