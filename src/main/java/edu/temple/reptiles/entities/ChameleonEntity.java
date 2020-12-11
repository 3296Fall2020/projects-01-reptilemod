package edu.temple.reptiles.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import java.util.*;

public class ChameleonEntity extends CreatureEntity {

    private static final Map<Item, Float> preferredItems = initializePreferredItems();

    public ChameleonEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    private static Map<Item, Float> initializePreferredItems() {
        Map<Item, Float> toReturn = new HashMap<>();
        toReturn.put(Items.STICK, 10.0f);
        toReturn.put(Items.BONE, 9.0f);
        toReturn.put(Items.ARROW, 8.0f);
        toReturn.put(Items.BLAZE_ROD, 7.0f);
        toReturn.put(Items.GOLDEN_CARROT, 6.0f);
        toReturn.put(Items.CARROT, 5.0f);
        toReturn.put(Items.TRIDENT, 3.0f);
        toReturn.put(Items.NAME_TAG, 2.0f);
        return toReturn;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
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

    public boolean canPickupItem(Item item) {
        if (preferredItems.containsKey(item) && (this.getHeldItemMainhand().isEmpty() ||
                preferredItems.get(this.getHeldItemMainhand().getItem()) < preferredItems.get(item)))
        {
            return true;
        }
        return false;
    }

    public void tryPickupReplaceItem(ItemEntity itemEntity) {
        ItemStack mainHand = this.getHeldItemMainhand();
        if (canPickupItem(itemEntity.getItem().getItem())) {
            this.entityDropItem(mainHand);
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemEntity.getItem().split(1));
            itemEntity.remove();
        }
    }

    public void livingTick() {
        List<ItemEntity> list =
                this.world.getEntitiesWithinAABB(ItemEntity.class, this.getBoundingBox().grow(1.0f, 1.0f, 1.0f));
        if (!list.isEmpty()) {
            for (ItemEntity item : list) {
                tryPickupReplaceItem(item);
            }
        }
        super.livingTick();
    }

    static class FindItemsGoal extends Goal {
        private final ChameleonEntity chameleon;

        public FindItemsGoal(ChameleonEntity chameleon) {
            this.chameleon = chameleon;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (chameleon.getAttackTarget() == null && chameleon.getRevengeTarget() == null) {
                if (chameleon.getRNG().nextInt(10) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = chameleon.world.getEntitiesWithinAABB(ItemEntity.class, chameleon.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
                    return !list.isEmpty() && chameleon.canPickupItem(list.get(0).getItem().getItem());
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
            if (!list.isEmpty() && chameleon.canPickupItem(list.get(0).getItem().getItem())) {
                chameleon.getNavigator().tryMoveToEntityLiving(list.get(0), (double)0.6F);
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            List<ItemEntity> list = chameleon.world.getEntitiesWithinAABB(ItemEntity.class, chameleon.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
            if (!list.isEmpty() && chameleon.canPickupItem(list.get(0).getItem().getItem())) {
                chameleon.getNavigator().tryMoveToEntityLiving(list.get(0), (double)0.6F);
            }

        }
    }


}


