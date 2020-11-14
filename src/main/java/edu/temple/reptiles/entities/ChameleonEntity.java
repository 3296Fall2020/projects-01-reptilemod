package edu.temple.reptiles.entities;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.render.ChameleonRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.EnumSet;
import java.util.List;

public class ChameleonEntity extends CreatureEntity {

    public ChameleonEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return CreatureEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 4.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 0.4D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.4D, false));
        this.goalSelector.addGoal(2, new FindItemsGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.4D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.4D));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ChameleonEntity.class, true));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 0;
    }

    class FindItemsGoal extends Goal {
        private ChameleonEntity chameleon;

        public FindItemsGoal(ChameleonEntity chameleon) {
            this.chameleon = chameleon;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (!chameleon.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                return false;
            } else if (chameleon.getAttackTarget() == null && chameleon.getRevengeTarget() == null) {
                if (chameleon.getRNG().nextInt(10) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = chameleon.world.getEntitiesWithinAABB(ItemEntity.class, chameleon.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
                    return !list.isEmpty() && chameleon.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            List<ItemEntity> list = chameleon.world.getEntitiesWithinAABB(ItemEntity.class, chameleon.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
            ItemStack itemstack = chameleon.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                chameleon.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
            }

        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            List<ItemEntity> list = chameleon.world.getEntitiesWithinAABB(ItemEntity.class, chameleon.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
            if (!list.isEmpty()) {
                chameleon.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
            }

        }
    }


}


