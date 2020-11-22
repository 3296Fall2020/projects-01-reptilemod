package edu.temple.reptiles.entities;

import edu.temple.reptiles.entities.ai.BaskGoal;
import edu.temple.reptiles.init.ModEntityTypes;
import edu.temple.reptiles.items.ReptileItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import java.util.UUID;

public class BeardedDragonEntity extends TameableEntity implements IAngerable, IAnimatedEntity {

    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController controller = new EntityAnimationController(this, "moveController", 28, this::animationPredicate);

    private static final DataParameter<Integer> getAngerTime = EntityDataManager.createKey(BeardedDragonEntity.class, DataSerializers.VARINT);
    private UUID target;

    private static final RangedInteger rangedInteger = TickRangeConverter.convertRange(10, 29);

    public BeardedDragonEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
        registerAnimationController();
    }
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.CARROT, ReptileItems.CRICKET, ReptileItems.MEAL_WORM);




    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.registerAttributes()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0F)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.3F)
                .createMutableAttribute(Attributes.FOLLOW_RANGE)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 2.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        //this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new beardedDragonBaskGoal(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.1D, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::func_233680_b_));
      //  this.targetSelector.addGoal(5, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, TARGET_ENTITIES));
        this.targetSelector.addGoal(6, new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
        this.targetSelector.addGoal(8, new ResetAngerGoal<>(this, true));



    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(4);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_LLAMA_AMBIENT;
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_LLAMA_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_LLAMA_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_LLAMA_STEP, 0.15F, 1.0F);
    }


    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {

        return ModEntityTypes.BEARDEDDRAGON.get().create(this.world);
    }

    @Override
    public int getAngerTime() {
        return this.dataManager.get(getAngerTime);
    }

    @Override
    public void setAngerTime(int time) {
        this.dataManager.set(getAngerTime, time);
    }

    //@org.jetbrains.annotations.Nullable
    @Override
    public UUID getAngerTarget() {
        return this.target;
    }

    @Override
    public void setAngerTarget( UUID target) {
        this.target = target;
    }

    @Override
    public void func_230258_H__() {
        this.setAngerTime(rangedInteger.func_233018_a_(this.rand));
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    private <E extends BeardedDragonEntity> boolean animationPredicate(AnimationTestEvent<E> event){
        if(event.isWalking()){
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.reptiles.walk", true));
            return true;
        }
        else{
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.reptiles.idle", true));
            return true;
        }
    }
    private void registerAnimationController(){
        manager.addAnimationController(controller);
    }


    private class beardedDragonBaskGoal extends BaskGoal{

        public beardedDragonBaskGoal(CreatureEntity creatureIn) {
            super(creatureIn);
        }
    }

}

