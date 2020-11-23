package edu.temple.reptiles.util.handlers;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SoundRegisterListener {

        @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
        public void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(SoundsHandler.ENTITY_DINOSAUR_AMBIENT,SoundsHandler.ENTITY_DINOSAUR_HURT, SoundsHandler.ENTITY_DINOSAUR_DEATH);
        }


}
