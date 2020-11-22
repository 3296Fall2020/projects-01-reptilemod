package edu.temple.reptiles.entities;

import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.TickRangeConverter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

import java.util.UUID;

public class SnakeEntity extends CreatureEntity implements IAngerable, IAnimatedEntity, IClimbingEntity {
    private EntityAnimationManager animManager;
    private AnimationController animController;
    private boolean attached;

    private static final DataParameter<Integer> getAngerTime = EntityDataManager.createKey(SnakeEntity.class, DataSerializers.VARINT);
    private UUID target;
    private static final RangedInteger rangedInteger = TickRangeConverter.convertRange(10, 29);

    public SnakeEntity(EntityType<? extends CreatureEntity> type, World worldIn){
        super(type, worldIn);
        this.animManager = new EntityAnimationManager();
        this.animController = new EntityAnimationController(this, "animationController", 20, this::animationPredicate);
        registerAnimationControllers();

        this.attached = false;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player){return 1 + this.world.rand.nextInt(4);}

    @Override
    public int getAngerTime() {
        return this.dataManager.get(getAngerTime);
    }

    @Override
    public void setAngerTime(int time) {
        this.dataManager.set(getAngerTime, time);
    }

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

    public EntityAnimationManager getAnimationManager(){
        return this.animManager;
    }

    private<E extends SnakeEntity> boolean animationPredicate(AnimationTestEvent<E> event){
//        if( this.isAttached()) {
//            animController.setAnimation(new AnimationBuilder().addAnimation("animation.snake.climb", true));
////            return true;
//        }
//        else
        if(event.isWalking()){
            animController.setAnimation(new AnimationBuilder().addAnimation("animation.snake.slither", true));
            return true;
        }
        return false;
    }

    private void registerAnimationControllers(){
        this.animManager.addAnimationController(this.animController);
    }

    @Override
    public boolean canAttach() {
        return !this.attached;
    }

    @Override
    public boolean isAttached() {
        return this.attached;
    }

    //TODO:  This logic should be shifted to SnakeBlock class when it is constructed
    @Override
    public void spawnCreature(World world, BlockPos pos) {
        SnakeEntity snake = ModEntityTypes.SNAKE.get().create(world);
        snake.setLocationAndAngles(pos.getX() + 1.0D, pos.getY(), pos.getZ(), 0F, 0F);
        world.addEntity(snake);
    }

    @Override
    public void setAttached(boolean in) {
        this.attached = in;
    }

}
