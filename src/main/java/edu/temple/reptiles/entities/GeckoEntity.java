package edu.temple.reptiles.entities;

//import edu.temple.reptiles.init.ModEntityTypes;
import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GeckoEntity extends AnimalEntity {

        private GeckoEntity.AvoidEntityGoal<PlayerEntity> field_213531_bB;
        private static final Ingredient BREEDING_ITEMS = Ingredient.fromItems(Items.APPLE);
        //Change Apple to Bugs when implemented
        private GeckoEntity.TemptGoal aiTempt;
        private static final DataParameter<Boolean> IS_TRUSTING = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BOOLEAN);

    public GeckoEntity(EntityType<? extends GeckoEntity> type, World worldIn) {
        super(type, worldIn);
        this.func_213529_dV();
    }


    private boolean isTrusting() {
            return this.dataManager.get(IS_TRUSTING);
        }


        public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
            return MobEntity.registerAttributes()
                    .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.50D)
                    .createMutableAttribute(Attributes.FOLLOW_RANGE);
        }

        @Override
        protected void registerGoals() {
            super.registerGoals();
            this.aiTempt = new GeckoEntity.TemptGoal(this, 0.6D, BREEDING_ITEMS, true);
            this.goalSelector.addGoal(1, new SwimGoal(this));
            this.goalSelector.addGoal(3, this.aiTempt);
            this.goalSelector.addGoal(9, new BreedGoal(this, 0.8D));
            this.goalSelector.addGoal(10, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
            this.goalSelector.addGoal(11, new LookAtGoal(this, PlayerEntity.class, 10.0F));
            this.goalSelector.addGoal(8, new PanicGoal(this, .6));

        }

        @Override
        protected int getExperiencePoints(PlayerEntity player) {
            return 1 + this.world.rand.nextInt(4);
        }

        @Override
        protected SoundEvent getAmbientSound() {
            return SoundEvents.ENTITY_FOX_AMBIENT;
        }


        @Override
        protected SoundEvent getDeathSound() {
            return SoundEvents.ENTITY_FOX_DEATH;
        }

        @Override
        protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
            return SoundEvents.ENTITY_FOX_HURT;
        }

        @Override
        protected void playStepSound(BlockPos pos, BlockState blockIn) {
            this.playSound(SoundEvents.ENTITY_LLAMA_STEP, 0.15F, 1.0F);
        }


        @Override
        public AgeableEntity createChild(AgeableEntity ageable) {

            return ModEntityTypes.GECKO.get().create(this.world);
        }


        static class TemptGoal extends net.minecraft.entity.ai.goal.TemptGoal {
            private final GeckoEntity gecko;

            public TemptGoal(GeckoEntity geckoIn, double speedIn, Ingredient temptItemsIn, boolean p_i50036_5_) {
                super(geckoIn, speedIn, temptItemsIn, p_i50036_5_);
                this.gecko = geckoIn;
            }
        }


    protected void func_213529_dV() {
       if (this.field_213531_bB == null) {
            this.field_213531_bB = new GeckoEntity.AvoidEntityGoal<>(this, PlayerEntity.class, 16.0F, 0.8D, 1.33D);
        }

       this.goalSelector.removeGoal(this.field_213531_bB);


    }

    static class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
        private final GeckoEntity gecko;

        public AvoidEntityGoal(GeckoEntity geckoIn, Class<T> p_i50037_2_, float p_i50037_3_, double p_i50037_4_, double p_i50037_6_) {
            super(geckoIn, p_i50037_2_, p_i50037_3_, p_i50037_4_, p_i50037_6_, EntityPredicates.CAN_AI_TARGET::test);
            this.gecko = geckoIn;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return !this.gecko.isTrusting() && super.shouldExecute();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return !this.gecko.isTrusting() && super.shouldContinueExecuting();
        }
    }
}

