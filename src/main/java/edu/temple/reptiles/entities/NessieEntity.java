package edu.temple.reptiles.entities;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class NessieEntity extends WaterMobEntity {

    public NessieEntity(EntityType<? extends WaterMobEntity> type, World worldIn) {
        super(type, worldIn);

    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return WaterMobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 400.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 0.6D)
                .createMutableAttribute(Attributes.ARMOR, 8.0D)
                .createMutableAttribute(Attributes.ARMOR_TOUGHNESS, 3.0D)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 10.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 400 + this.world.rand.nextInt(200);
    }
}
