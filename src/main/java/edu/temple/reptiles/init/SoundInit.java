package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reptiles.MOD_ID);

    // Dinosaur sound credits: https://www.youtube.com/watch?v=5P6exEqnnt
    public static final RegistryObject<SoundEvent> ENTITY_DINOSAUR_AMBIENT = SOUNDS.register("entity.dinosaur.ambient",
            () -> new SoundEvent(new ResourceLocation(Reptiles.MOD_ID, "entity.dinosaur.ambient")));
    public static final RegistryObject<SoundEvent> ENTITY_DINOSAUR_HURT = SOUNDS.register("entity.dinosaur.hurt",
            () -> new SoundEvent(new ResourceLocation(Reptiles.MOD_ID, "entity.dinosaur.hurt")));
    public static final RegistryObject<SoundEvent> ENTITY_DINOSAUR_DEATH = SOUNDS.register("entity.dinosaur.death",
            () -> new SoundEvent(new ResourceLocation(Reptiles.MOD_ID, "entity.dinosaur.death")));


}
