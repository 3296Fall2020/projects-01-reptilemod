package edu.temple.reptiles.entities;

import edu.temple.reptiles.tileentity.ClimbTileEntity;
import net.minecraft.tileentity.TileEntityType;

public interface IClimbingEntity {

    boolean canAttach();

    boolean isAttached();

    boolean disableAI();

    void unrender();
}
