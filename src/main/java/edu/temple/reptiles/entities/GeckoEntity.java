package edu.temple.reptiles.entities;

//import edu.temple.reptiles.init.ModEntityTypes;
import com.google.common.collect.Sets;
import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.Set;

public class GeckoEntity extends ShoulderRidingEntity {

    private static final DataParameter<Boolean> field_213428_bG = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> field_213429_bH = EntityDataManager.createKey(GeckoEntity.class, DataSerializers.BOOLEAN);
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

    public void func_213419_u(boolean p_213419_1_) {
        this.dataManager.set(field_213428_bG, p_213419_1_);
    }

    public void func_213415_v(boolean p_213415_1_) {
        this.dataManager.set(field_213429_bH, p_213415_1_);
    }
    public boolean func_213416_eg() {
        return this.dataManager.get(field_213428_bG);
    }
    public boolean func_213409_eh() {
        return this.dataManager.get(field_213429_bH);
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
            //this.goalSelector.addGoal(2, new GeckoEntity.MorningGiftGoal(this));


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
/*
    static class MorningGiftGoal extends Goal {
        private final GeckoEntity gecko;
        private PlayerEntity owner;
        private BlockPos bedPos;
        private int tickCounter;

        public MorningGiftGoal(GeckoEntity geckoIn) {
            this.gecko = geckoIn;
        }


        public boolean shouldExecute() {
            if (!this.gecko.isTamed()) {
                return false;
            } else if (this.gecko.func_233685_eM_()) {
                return false;
            } else {
                LivingEntity livingentity = this.gecko.getOwner();
                if (livingentity instanceof PlayerEntity) {
                    this.owner = (PlayerEntity)livingentity;
                    if (!livingentity.isSleeping()) {
                        return false;
                    }

                    if (this.gecko.getDistanceSq(this.owner) > 100.0D) {
                        return false;
                    }

                    BlockPos blockpos = this.owner.getPosition();
                    BlockState blockstate = this.gecko.world.getBlockState(blockpos);
                    if (blockstate.getBlock().isIn(BlockTags.BEDS)) {
                        this.bedPos = blockstate.func_235903_d_(BedBlock.HORIZONTAL_FACING).map((p_234186_1_) -> {
                            return blockpos.offset(p_234186_1_.getOpposite());
                        }).orElseGet(() -> {
                            return new BlockPos(blockpos);
                        });
                        return !this.func_220805_g();
                    }
                }

                return false;
            }
        }

        private boolean func_220805_g() {
            for(GeckoEntity geckoentity : this.gecko.world.getEntitiesWithinAABB(GeckoEntity.class, (new AxisAlignedBB(this.bedPos)).grow(2.0D))) {
                if (geckoentity != this.gecko && (geckoentity.func_213416_eg() || geckoentity.func_213409_eh())) {
                    return true;
                }
            }

            return false;
        }


        public boolean shouldContinueExecuting() {
            return this.gecko.isTamed() && !this.gecko.func_233685_eM_() && this.owner != null && this.owner.isSleeping() && this.bedPos != null && !this.func_220805_g();
        }


        public void startExecuting() {
            if (this.bedPos != null) {
                this.gecko.func_233686_v_(false);
                this.gecko.getNavigator().tryMoveToXYZ((double)this.bedPos.getX(), (double)this.bedPos.getY(), (double)this.bedPos.getZ(), (double)1.1F);
            }

        }


        public void resetTask() {
            this.gecko.func_213419_u(false);
            float f = this.gecko.world.getCelestialAngle(1.0F);
            if (this.owner.getSleepTimer() >= 100 && (double)f > 0.77D && (double)f < 0.8D && (double)this.gecko.world.getRandom().nextFloat() < 0.7D) {
                this.func_220804_h();
            }

            this.tickCounter = 0;
            this.gecko.func_213415_v(false);
            this.gecko.getNavigator().clearPath();
        }

        private void func_220804_h() {
            Random random = this.gecko.getRNG();
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            blockpos$mutable.setPos(this.gecko.getPosition());
            this.gecko.attemptTeleport((double)(blockpos$mutable.getX() + random.nextInt(11) - 5), (double)(blockpos$mutable.getY() + random.nextInt(5) - 2), (double)(blockpos$mutable.getZ() + random.nextInt(11) - 5), false);
            blockpos$mutable.setPos(this.gecko.getPosition());
            LootTable loottable = this.gecko.world.getServer().getLootTableManager().getLootTableFromLocation(LootTables.GAMEPLAY_CAT_MORNING_GIFT);
            LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.gecko.world)).withParameter(LootParameters.POSITION, blockpos$mutable).withParameter(LootParameters.THIS_ENTITY, this.gecko).withRandom(random);

            for(ItemStack itemstack : loottable.generate(lootcontext$builder.build(LootParameterSets.GIFT))) {
                this.gecko.world.addEntity(new ItemEntity(this.gecko.world, (double)blockpos$mutable.getX() - (double)MathHelper.sin(this.gecko.renderYawOffset * ((float)Math.PI / 180F)), (double)blockpos$mutable.getY(), (double)blockpos$mutable.getZ() + (double)MathHelper.cos(this.gecko.renderYawOffset * ((float)Math.PI / 180F)), itemstack));
            }

        }


        public void tick() {
            if (this.owner != null && this.bedPos != null) {
                this.gecko.func_233686_v_(false);
                this.gecko.getNavigator().tryMoveToXYZ((double)this.bedPos.getX(), (double)this.bedPos.getY(), (double)this.bedPos.getZ(), (double)1.1F);
                if (this.gecko.getDistanceSq(this.owner) < 2.5D) {
                    ++this.tickCounter;
                    if (this.tickCounter > 16) {
                        this.gecko.func_213419_u(true);
                        this.gecko.func_213415_v(false);
                    } else {
                        this.gecko.faceEntity(this.owner, 45.0F, 45.0F);
                        this.gecko.func_213415_v(true);
                    }
                } else {
                    this.gecko.func_213419_u(false);
                }
            }

        }
    }

    */


    @OnlyIn(Dist.CLIENT)
    public boolean isPartying() {
        return this.partyGecko;
    }



    }

