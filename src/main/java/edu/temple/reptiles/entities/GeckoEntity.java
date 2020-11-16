package edu.temple.reptiles.entities;

//import edu.temple.reptiles.init.ModEntityTypes;
import com.google.common.collect.Sets;
import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Set;

public class GeckoEntity extends ShoulderRidingEntity {

    private static final Set<Item> TAME_ITEMS = Sets.newHashSet(Items.WHEAT_SEEDS);
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.VARINT);
        private GeckoEntity.AvoidEntityGoal<PlayerEntity> field_213531_bB;
        private static final Ingredient BREEDING_ITEMS = Ingredient.fromItems(Items.APPLE);
        //Change Apple to Bugs when implemented
        private GeckoEntity.TemptGoal aiTempt;
        private static final DataParameter<Boolean> IS_TRUSTING = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BOOLEAN);
    private AgeableEntity ageable;
    private boolean partyGecko;

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
            this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
            this.goalSelector.addGoal(2, new SitGoal(this));
            this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
            this.goalSelector.addGoal(3, this.aiTempt);
            this.goalSelector.addGoal(3, new LandOnOwnersShoulderGoal(this));
            this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
            this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
            this.goalSelector.addGoal(11, new LookAtGoal(this, PlayerEntity.class, 10.0F));
            this.goalSelector.addGoal(8, new PanicGoal(this, .6));
            this.goalSelector.addGoal(1, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.APPLE), false));

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
            this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
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

    public boolean canMateWith(AnimalEntity otherAnimal) {
        return false;
    }

    public int getVariant() {
        return MathHelper.clamp(this.dataManager.get(VARIANT), 0, 4);
    }

    public void setVariant(int variantIn) {
        this.dataManager.set(VARIANT, variantIn);
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setVariant(this.rand.nextInt(5));
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableEntity.AgeableData();
            ((AgeableEntity.AgeableData)spawnDataIn).setCanBabySpawn(false);
        }

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }




    public boolean canBePushed() {
        return true;
    }

    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        if (!this.isTamed() && TAME_ITEMS.contains(itemstack.getItem())) {
            if (!p_230254_1_.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.isSilent()) {
                this.world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(10) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
                    this.setTamedBy(p_230254_1_);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.world.setEntityState(this, (byte)6);
                }
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        }  else {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }




    @OnlyIn(Dist.CLIENT)
    public boolean isPartying() {
        return this.partyGecko;
    }


}

