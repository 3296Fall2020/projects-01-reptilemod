package edu.temple.reptiles.util.handlers;

import edu.temple.reptiles.Reptiles;
import net.minecraft.client.audio.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.extensions.IForgeResourcePack;
import net.minecraftforge.registries.ForgeRegistries;

// For custom sounds
public class SoundsHandler {

    public static SoundEvent ENTITY_DINOSAUR_AMBIENT, ENTITY_DINOSAUR_HURT, ENTITY_DINOSAUR_DEATH;

    public static void registerSounds(){
        ENTITY_DINOSAUR_AMBIENT = registerSound("entity.dinosaur.ambient");
        ENTITY_DINOSAUR_HURT = registerSound("entity.dinosaur.hurt");
        ENTITY_DINOSAUR_DEATH = registerSound("entity.dinosaur.death");
    }

    public static SoundEvent registerSound(String name){
                                                        //Reference.MODID ????
        ResourceLocation location = new ResourceLocation(Reptiles.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }

}
