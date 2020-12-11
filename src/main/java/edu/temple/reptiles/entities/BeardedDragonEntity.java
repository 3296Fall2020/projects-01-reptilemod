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
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import javax.annotation.Nullable;
import java.util.UUID;

public class BeardedDragonEntity extends TameableEntity implements IAngerable, IAnimatedEntity {

    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController controller = new EntityAnimationController(this, "moveController", 28, this::animationPredicate);


    private static final DataParameter<Integer> getAngerTime = EntityDataManager.createKey(BeardedDragonEntity.class, DataSerializers.VARINT);
    private UUID target;

    private static final RangedInteger field_234230_bG_ = TickRangeConverter.convertRange(20, 29);

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
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::func_233680_b_));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, BeardedDragonEntity.class, false));
        this.targetSelector.addGoal(8, new ResetAngerGoal<>(this, true));



    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(4);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_TURTLE_AMBIENT_LAND;
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TURTLE_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_TURTLE_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.10F, 1.0F);
    }


    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.BEARDEDDRAGON.get().create(this.world);
    }


    protected void registerData(){
        super.registerData();
        this.dataManager.register(getAngerTime, 0);
    }
    public int getAngerTime() {
        return this.dataManager.get(getAngerTime);
    }


    public void setAngerTime(int time) {
        this.dataManager.set(getAngerTime, time);
    }



    @Nullable
    public UUID getAngerTarget() {
        return this.target;
    }


    public void setAngerTarget(@Nullable UUID target) {
        this.target = target;
    }


    public void func_230258_H__() {
        this.setAngerTime(field_234230_bG_.func_233018_a_(this.rand));
    }
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        this.writeAngerNBT(compound);
    }
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readAngerNBT((ServerWorld)this.world, compound);
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();
            this.func_233687_w_(false);
            if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }


    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote) {
            this.func_241359_a_((ServerWorld) this.world, true);
        }

    }


    private <E extends BeardedDragonEntity> boolean animationPredicate(AnimationTestEvent<E> event){

        if(this.isAggressive()){
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.reptiles.angry", false));
            return true;
        }
        else if(event.isWalking()){
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.reptiles.walk", true));
            return true;
        }

        else{
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.reptiles.idle", true));
        }
        return true;
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

