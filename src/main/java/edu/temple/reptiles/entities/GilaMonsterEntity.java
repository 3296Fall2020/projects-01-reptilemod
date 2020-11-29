package edu.temple.reptiles.entities;

import edu.temple.reptiles.blocks.GilaHideBlock;
import edu.temple.reptiles.entities.ai.BaskGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import java.util.EnumSet;

public class GilaMonsterEntity extends CreatureEntity implements IAnimatedEntity {
    private EntityAnimationManager manager;
    private AnimationController controller;

    public GilaMonsterEntity(EntityType<? extends CreatureEntity> type, World worldIn){
        super(type, worldIn);
        this.manager = new EntityAnimationManager();
        this.controller = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);
        registerAnimationControllers();
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.20D);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2 ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0f, 1.2D, 1.25D));
        this.goalSelector.addGoal(4, new HideGoal(this, 2.0D));
        this.goalSelector.addGoal(5, new GilaBask(this));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player){ return 1 + this.world.rand.nextInt(4);}

    @Override
    public EntityAnimationManager getAnimationManager(){
        return this.manager;
    }

    private<E extends GilaMonsterEntity> boolean animationPredicate(AnimationTestEvent<E> event){
        if(event.isWalking()){
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.gila_monster.walk"));
            return true;
        }
        return false;
    }

    private void registerAnimationControllers(){
        this.manager.addAnimationController(this.controller);
    }

    private class GilaBask extends BaskGoal {
        public GilaBask(CreatureEntity creatureIn) {
            super(creatureIn);
        }

    }

    private class HideGoal extends RandomWalkingGoal{
        private boolean doMerge;
        private Direction facing;
        private double hideDistance;

        public HideGoal(GilaMonsterEntity gila, Double hideDistance){
            super(gila, 1.0D, 10);
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
            this.hideDistance = hideDistance;
            this.doMerge = false;
        }

        public boolean shouldExecute(){
              if(this.creature.world.getClosestPlayer(this.creature, this.hideDistance) != null && this.creature.getRNG().nextInt(5) == 0){
                this.facing = Direction.DOWN;
                BlockPos pos = (new BlockPos(this.creature.getPosX(), this.creature.getPosY() + 0.5D, this.creature.getPosZ())).offset(this.facing);
                if(GilaHideBlock.canContainGila(this.creature.world.getBlockState(pos))){
                    this.doMerge = true;
                    return true;
                }
            }
            this.doMerge = false;
            return super.shouldExecute();
        }

        public boolean shouldContinueExecuting() {return this.doMerge ? false : super.shouldContinueExecuting();}

        public void startExecuting(){
            if(!this.doMerge){
                super.startExecuting();
            } else{
                BlockPos pos = (new BlockPos(this.creature.getPosX(), this.creature.getPosY() + 0.5D, this.creature.getPosZ())).offset(this.facing);
                BlockState state = this.creature.world.getBlockState(pos);
                if(GilaHideBlock.canContainGila(state)){
                    this.creature.world.setBlockState(pos, GilaHideBlock.hide(state.getBlock()), 3);
                    this.creature.spawnExplosionParticle();
                    this.creature.remove();
                }
            }
        }
    }


}

