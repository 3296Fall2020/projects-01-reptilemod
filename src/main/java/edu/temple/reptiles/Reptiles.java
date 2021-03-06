package edu.temple.reptiles;

import edu.temple.reptiles.entities.*;
import edu.temple.reptiles.init.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("reptiles")
public class Reptiles
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "reptiles";

    public Reptiles() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in

        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        //Register custom sounds
        SoundInit.SOUNDS.register(modEventBus);

        ModBlockTypes.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            // add entity attributes
            // need an entry for each entity
            GlobalEntityTypeAttributes.put(ModEntityTypes.GECKO.get(), GeckoEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DINOSAUR.get(), DinosaurEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.CHAMELEON.get(), ChameleonEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.CROCODILE.get(), CrocodileEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.BEARDEDDRAGON.get(), BeardedDragonEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.NESSIE.get(), NessieEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.GILA_MONSTER.get(), GilaMonsterEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.SNAKE.get(), SnakeEntity.setCustomAttributes().create());

        });
    }
}
