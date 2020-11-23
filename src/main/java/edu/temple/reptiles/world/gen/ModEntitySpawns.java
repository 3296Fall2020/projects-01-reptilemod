package edu.temple.reptiles.world.gen;

import com.google.common.eventbus.Subscribe;
import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reptiles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event){
        for (Biome biome : ForgeRegistries.BIOMES){

            if (biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.SAVANNA || biome.getCategory() == Biome.Category.MESA){
                biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntityTypes.DINOSAUR.get(), 100, 1, 6));
            }
            if(biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.MESA){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.BEARDEDDRAGON.get(), 100, 1, 2));
            }
            if(biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.SWAMP){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.CHAMELEON.get(), 100, 1, 5));
            }
            if(biome.getCategory() == Biome.Category.SWAMP || biome.getCategory() == Biome.Category.RIVER){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.CROCODILE.get(), 100, 1, 2));
            }
            if(biome.getCategory() == Biome.Category.JUNGLE){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.GECKO.get(), 100, 2, 5));
            }
            if(biome.getCategory() == Biome.Category.SWAMP || biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.DESERT){
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.SNAKE.get(), 100, 1, 1));
            }

        }
    }

}


//    EntitySpawnPlacementRegistry.register(DINOSAUR, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c());
//
//    public static void registerEntityWorldSpawns()
//    {
//        registerEntityWorldSpawn(DINOSAUR, 10, 1, 6, Biomes.DESERT, Biomes.PLAINS, Biomes.SAVANNA);
//    }
//
//    public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int min, int max, Biome... biomes)
//    {
//        for(Biome biome : biomes) {
//            if (biome != null) {
//                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, min, max));
//            }
//        }
//    }