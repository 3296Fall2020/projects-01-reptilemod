package edu.temple.reptiles.world.gen;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.DinosaurEntity;
import edu.temple.reptiles.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reptiles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {


    //Natural Entity Spawning
    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event) {

        for (Biome biome : ForgeRegistries.BIOMES) {


            if (biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.SAVANNA || biome.getCategory() == Biome.Category.MESA) {
                biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntityTypes.DINOSAUR.get(), 4, 1, 2));
            }
            if (biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.MESA) {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.BEARDEDDRAGON.get(), 10, 1, 2));
            }
            if (biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.SWAMP) {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.CHAMELEON.get(), 10, 1, 5));
            }
            if (biome.getCategory() == Biome.Category.SWAMP || biome.getCategory() == Biome.Category.RIVER) {


                biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(ModEntityTypes.CROCODILE.get(), 5, 1, 2));

            }
            if (biome.getCategory() == Biome.Category.JUNGLE) {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.GECKO.get(), 10, 2, 5));
            }
            if (biome.getCategory() == Biome.Category.DESERT) {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.GILA_MONSTER.get(), 10, 2, 3));
            }
            if (biome.getCategory() == Biome.Category.SWAMP || biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.DESERT) {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModEntityTypes.SNAKE.get(), 10, 1, 2));

            }


        }
    }
}
