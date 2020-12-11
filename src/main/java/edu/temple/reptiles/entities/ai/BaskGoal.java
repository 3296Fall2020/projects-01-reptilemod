package edu.temple.reptiles.entities.ai;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public abstract class BaskGoal extends MoveToBlockGoal {
    private int maxStayTicks;

    public BaskGoal(CreatureEntity creatureIn){
        super(creatureIn, 1.0D, 2);
    }

    private boolean worldConditions(){
        return this.creature.isOnGround() && !this.creature.isInWater() && this.creature.world.isDaytime() && !this.creature.world.isRaining() && !this.creature.world.isThundering();
    }

    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && this.worldConditions();
    }

    @Override
    public boolean shouldContinueExecuting(){

        return this.timeoutCounter >= -this.maxStayTicks && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.creature.world, this.destinationBlock) && this.worldConditions();
    }

    @Override
    public void startExecuting(){
        func_220725_g();
        baskAction();
        this.timeoutCounter = 0;
        this.maxStayTicks = this.creature.getRNG().nextInt(this.creature.getRNG().nextInt(1200) + 1200) + 1200;
    }

    @Override
    public void tick(){
        super.tick();

    }

    @Override
    public boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos){
        return worldIn.canBlockSeeSky(pos) && !worldIn.hasWater(pos);
    }

    public void baskAction(){

    }


}