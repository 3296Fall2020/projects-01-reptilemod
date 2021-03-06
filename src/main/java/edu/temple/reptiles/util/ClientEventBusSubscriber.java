package edu.temple.reptiles.util;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.render.*;
import edu.temple.reptiles.init.ModEntityTypes;
import edu.temple.reptiles.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
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
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GILA_MONSTER.get(), GilaMonsterRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SNAKE.get(), SnakeRenderer::new);

    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event){
        //this is needed because normally minecraft registers items before entities, so if there are spawn eggs added into the game, they will throw
        //an exception because the entities 'don't exist'.

        ModSpawnEggItem.initSpawnEggs();
    }

}
