package edu.temple.reptiles.tileentity;


import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.IClimbingEntity;
import edu.temple.reptiles.init.ModTileEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ClimbTileEntity extends TileEntity implements ITickableTileEntity {

    private IClimbingEntity creature;
    private int tickCount = 0;

    public ClimbTileEntity(){
        this(ModTileEntityTypes.CLIMB.get());
    }

    public ClimbTileEntity(final TileEntityType<?> tileEntityType){
        super(tileEntityType);
        this.creature = null;
    }

    public void tick(){
        tickCount++;
        if(tickCount % 80 == 0){
            if(this.world.getRandom().nextInt(5) == 1) {
                detachCreature();
            }
            tickCount = 0;
        }
    }

    public void onEntityCollision(Entity entityIn){
        if(!this.hasCreature()) {
            if (entityIn instanceof IClimbingEntity) {
                Reptiles.LOGGER.debug("isClimber");
                if (((IClimbingEntity) entityIn).canAttach()) {
                    Reptiles.LOGGER.debug("attach");
                    attachCreature((IClimbingEntity) entityIn);
                }
            }
        }
    }

    public void attachCreature(IClimbingEntity entity){
        entity.setAttached(true);
        if(this.creature == null)
            this.creature = entity;
            ((Entity) entity).remove(true);
    }

    public IClimbingEntity getCreature() {
        return creature;
    }

    public void spawnCreature(World world, BlockPos pos){
        this.creature.spawnCreature(world, pos);
    }

    public boolean hasCreature(){
        return this.creature != null;
    }

    public void detachCreature(){
        if(this.hasCreature()) {
            this.creature.setAttached(false);
            this.spawnCreature(this.world, this.getPos());
            this.creature = null;
        }
    }

    @Override
    public void remove(){
        super.remove();
        detachCreature();
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
