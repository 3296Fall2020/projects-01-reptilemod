package edu.temple.reptiles.entities;

import edu.temple.reptiles.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;


public class DinosaurEntity extends MonsterEntity implements IAnimatedEntity {
    private EntityAnimationManager manager;
    private AnimationController controller = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);
    private AnimationController biteController = new EntityAnimationController(this, "biteController", 20, this::biteControllerAnim);
    private AnimationController legController = new EntityAnimationController(this, "legController", 10, this::legControllerAnim);


    public DinosaurEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.manager = new EntityAnimationManager();
        registerAnimationControllers();
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 37.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.20D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.5D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.0D)
                .createMutableAttribute(Attributes.ARMOR, 3.0D)
                .createMutableAttribute(Attributes.ARMOR_TOUGHNESS, 0.7D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D);
    }

    // tail wagging animation
    public EntityAnimationManager getAnimationManager(){
        return this.manager;
    }

    private<E extends DinosaurEntity> boolean animationPredicate(AnimationTestEvent<E> event){
        if(this.onGround){
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.dinosaur.tail", true));
            return true;
        } else{
            return false;
        }
    }

    // Dinosaur visually yelps briefly when attacked
    private<E extends DinosaurEntity> boolean biteControllerAnim(AnimationTestEvent<E> event){
        if(this.hurtTime > 0){
            biteController.setAnimation(new AnimationBuilder().addAnimation("animation.dinosaur.bite", true));
            return true;
        } else{
            return false;
        }
    }

    // Dinosaur scuffs the ground with leg preparing for an attack when a player approaches
    private<E extends DinosaurEntity> boolean legControllerAnim(AnimationTestEvent<E> event){

        if(this.isAggressive()){
            legController.setAnimation(new AnimationBuilder().addAnimation("animation.dinosaur.preAttack", true));
            return true;
        } else{
            return false;
        }
    }


    private void registerAnimationControllers(){
        this.manager.addAnimationController(this.controller);
        this.manager.addAnimationController(this.legController);
        this.manager.addAnimationController(this.biteController);
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 10 + this.world.rand.nextInt(20);
    }

    // Custom sounds called here
    @Override
    protected SoundEvent getAmbientSound() { return SoundInit.ENTITY_DINOSAUR_AMBIENT.get(); }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundInit.ENTITY_DINOSAUR_HURT.get(); }
    @Override
    protected SoundEvent getDeathSound() { return SoundInit.ENTITY_DINOSAUR_DEATH.get(); }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_RAVAGER_STEP, 0.15f, 1.0F);
    }


    // AI goals that give the entity "life"
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new SwimGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));

        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));

    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return true;
    }
}
