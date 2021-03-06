package edu.temple.reptiles.blocks;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.GilaMonsterEntity;
import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.IdentityHashMap;
import java.util.Map;

public class GilaHideBlock extends Block {
    private final Block hideBlock;
    private static final Map<Block, Block> normalToHideMap = new IdentityHashMap();

    public GilaHideBlock(Block blockIn, AbstractBlock.Properties properties){
        super(properties);
        this.hideBlock = blockIn;
        normalToHideMap.put(blockIn, this);
    }

    public static boolean canContainGila(BlockState state){
        return normalToHideMap.containsKey(state.getBlock());
    }

    @Override
    public void onPlayerDestroy(IWorld world, BlockPos pos, BlockState state){
        World worldIn = (World)world;
        if(!worldIn.isRemote){
            this.spawnGilaMonster(worldIn, pos);
        }
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn){
        if(!worldIn.isRemote() && worldIn.getRandom().nextInt(5) == 0){
            this.spawnGilaMonster(worldIn, pos.up());
            worldIn.removeBlock(pos, false);
        }
    }

    private void spawnGilaMonster(World world, BlockPos pos){
        GilaMonsterEntity gila = ModEntityTypes.GILA_MONSTER.get().create(world);
        gila.setLocationAndAngles(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 0.0f, 0.0f);
        world.addEntity(gila);
        gila.spawnExplosionParticle();
    }


    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn){
        if(!worldIn.isRemote){
            this.spawnGilaMonster(worldIn, pos);
        }
    }

    public static BlockState hide(Block blockIn){return normalToHideMap.get(blockIn).getDefaultState();}
}
