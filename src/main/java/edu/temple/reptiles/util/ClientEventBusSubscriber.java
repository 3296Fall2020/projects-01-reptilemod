package edu.temple.reptiles.util;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.render.*;
import edu.temple.reptiles.init.ModEntityTypes;
import edu.temple.reptiles.util.handlers.SoundsHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Reptiles.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        // Add one for each mob
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAMELEON.get(), ChameleonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CROCODILE.get(), CrocodileRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DINOSAUR.get(), DinosaurRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GECKO.get(), GeckoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BEARDEDDRAGON.get(), BeardedDragonRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.NESSIE.get(), NessieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SNAKE.get(), SnakeRenderer::new);

    }

//    public static void initRegistries(){
//        SoundsHandler.registerSounds();
//    }

}
