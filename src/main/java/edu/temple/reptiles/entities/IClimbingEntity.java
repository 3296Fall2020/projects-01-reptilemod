package edu.temple.reptiles.entities;


import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IClimbingEntity {

    boolean canAttach();

    boolean isAttached();

    void setAttached(boolean in);

    void spawnCreature(World world, BlockPos pos);
}
