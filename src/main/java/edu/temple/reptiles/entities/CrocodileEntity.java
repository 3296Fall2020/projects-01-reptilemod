package edu.temple.reptiles.entities;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.ai.BaskGoal;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.pathfinding.WalkAndSwimNodeProcessor;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.EnumSet;

public class CrocodileEntity extends MonsterEntity {

    public CrocodileEntity(EntityType<? extends MonsterEntity> type, World worldIn){
        super(type, worldIn);
        this.moveController = new CrocodileEntity.MoveHelperController(this);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D);
    }

    public boolean canBreatheUnderwater(){return true;}


    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new FloatGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new CrocBaskGoal(this));
        this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(10, new LookRandomlyGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, CowEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

    }

    @Override
    protected int getExperiencePoints(PlayerEntity player){
        return 1 + this.world.rand.nextInt(4);
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new CrocodileEntity.Navigator(this, worldIn);
    }

    private class MoveHelperController extends MovementController{
        private final CrocodileEntity croc;

        MoveHelperController(CrocodileEntity crocIn){
            super(crocIn);
            this.croc = crocIn;
        }

        private void updateSpeed(){
            if(this.croc.areEyesInFluid(FluidTags.WATER)){
                this.croc.setMotion(this.croc.getMotion().add(0.0D, 0.005D, 0.0D));
            }
            else if(this.croc.isOnGround()){
                this.croc.setAIMoveSpeed(Math.max(this.croc.getAIMoveSpeed() / 2.0F, 0.15F));
            }
        }

        public void tick(){
            this.updateSpeed();
            if (this.action == MovementController.Action.MOVE_TO && !this.croc.getNavigator().noPath()) {
                float f1 = (float)(this.speed * this.croc.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.croc.setAIMoveSpeed(MathHelper.lerp(0.125F, this.croc.getAIMoveSpeed(), f1));
                double d0 = this.posX - this.croc.getPosX();
                double d1 = this.posY - this.croc.getPosY();
                double d2 = this.posZ - this.croc.getPosZ();
                if(d1 != 0.0D) {
                    double d3 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    this.croc.setMotion(this.croc.getMotion().add(0.0D, (double) this.croc.getAIMoveSpeed() * (d1 / d3) * 0.1D, 0.0D));
                }
                if (d0 != 0.0D || d2 != 0.0D) {
                    float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                    this.croc.rotationYaw = this.limitAngle(this.croc.rotationYaw, f, 90.0F);
                    this.croc.renderYawOffset = this.croc.rotationYaw;
                }

            } else {
                this.croc.setAIMoveSpeed(0.0F);
            }
        }

    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return true;
    }

    static class Navigator extends SwimmerPathNavigator {
        Navigator(CrocodileEntity crocodile, World worldIn) {
            super(crocodile, worldIn);
        }

        /**
         * If on ground or swimming and can swim
         */
        protected boolean canNavigate() {
            return true;
        }

        @Override
        protected PathFinder getPathFinder(int p_179679_1_) {
            this.nodeProcessor = new WalkAndSwimNodeProcessor();
            return new PathFinder(this.nodeProcessor, p_179679_1_);
        }


    }

    static class CrocBaskGoal extends BaskGoal{

        CrocBaskGoal(CrocodileEntity crocIn){
            super(crocIn);
        }

        @Override
        public void baskAction(){
            // TODO: Add a pose or animation
            // Temporary visual indicator that the goal is occurring
            this.creature.getLookController().setLookPosition(this.creature.getPosX() + 1.0D, this.creature.getPosYEye() + 1.0D, this.creature.getPosZ() + 1.0D);
        }
    }


    static class FloatGoal extends MoveToBlockGoal{
        private final CrocodileEntity croc;

        FloatGoal(CrocodileEntity crocIn, double speedIn) {
            super(crocIn, speedIn, 24);
            this.croc = crocIn;
            this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
        }

        @Override
        public boolean shouldExecute(){
            return croc.isInWater() && super.shouldExecute();
        }

        @Override
        public boolean shouldContinueExecuting(){
            return croc.isInWater() && super.shouldContinueExecuting();
        }

        @Override
        protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos){
            return worldIn.isAirBlock(pos) && worldIn.getBlockState(pos.down()).isIn(Blocks.WATER);
        }

        @Override
        public void startExecuting(){
            super.startExecuting();
        }
    }
}
