package edu.temple.reptiles.tileentity;


import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.IClimbingEntity;
import edu.temple.reptiles.init.ModTileEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;


public class ClimbTileEntity extends TileEntity implements ITickableTileEntity {
    private IClimbingEntity creature;
    private int tickCount = 0;

    public ClimbTileEntity(){
        super(ModTileEntityTypes.CLIMB.get());
        this.creature = null;
    }

    public ClimbTileEntity(final TileEntityType<?> tileEntityType){
        super(tileEntityType);
        this.creature = null;
    }

    public void tick(){
        tickCount++;
        if(tickCount % 40 == 0){
            Reptiles.LOGGER.debug("Does this even work");
            tickCount = 0;
        }
    }

    public void onEntityCollision(Entity entityIn){
        if(entityIn instanceof IClimbingEntity){
            if(VoxelShapes.compare(VoxelShapes.create(entityIn.getCollisionBoundingBox()),
                    VoxelShapes.create(new AxisAlignedBB(this.pos, this.pos.add(1,1,1))),
                    IBooleanFunction.AND)){
                if(((IClimbingEntity) entityIn).canAttach()){
//                    attachCreature((IClimbingEntity) entityIn);
//                    initAttach();
                }
            }
        }
    }

    public IClimbingEntity attachCreature(IClimbingEntity entity){
        if(this.creature == null)
            this.creature = entity;
            initAttach();
        return this.creature;
    }

    private void initAttach(){
        this.creature.disableAI();
        this.creature.unrender();
    }

    public IClimbingEntity getCreature() {
        return creature;
    }

    //    public void read(BlockState state, CompoundNBT nbt){
//        super.read(state, nbt);
//    }
//
//    public CompoundNBT write(CompoundNBT compound){
//        super.write(compound);
////        compound.putString("creature", )
//        return compound;
//    }
}
