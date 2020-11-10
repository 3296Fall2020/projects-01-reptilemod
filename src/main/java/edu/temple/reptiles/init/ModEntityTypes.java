package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reptiles.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<GeckoEntity>> GECKO = ENTITY_TYPES
            .register("gecko",
                    () -> EntityType.Builder.create(GeckoEntity::new, EntityClassification.CREATURE)
            .size(0.25F,0.25F).build(new ResourceLocation(Reptiles.MOD_ID, "gecko").toString()));
    public static final RegistryObject<EntityType<DinosaurEntity>> DINOSAUR = ENTITY_TYPES.register("dinosaur",
            () -> EntityType.Builder.create(DinosaurEntity::new, EntityClassification.MONSTER)
                    .size(1.95f, 2.3f)
                    .build(new ResourceLocation(Reptiles.MOD_ID, "dinosaur").toString()));
    public static final RegistryObject<EntityType<CrocodileEntity>> CROCODILE = ENTITY_TYPES.register(("crocodile"),
        () -> EntityType.Builder.create(CrocodileEntity::new, EntityClassification.MONSTER)
                .size(1.0f, 1.0f)
                .build(new ResourceLocation(Reptiles.MOD_ID, "crocodile").toString()));

    public static final RegistryObject<EntityType<ChameleonEntity>> CHAMELEON = ENTITY_TYPES.register(("chameleon"),
        () -> EntityType.Builder.create(ChameleonEntity::new, EntityClassification.CREATURE)
                .size(0.6f, 0.7f)
                .build(new ResourceLocation(Reptiles.MOD_ID, "chameleon").toString()));
    public static final RegistryObject<EntityType<BeardedDragonEntity>> BEARDEDDRAGON = ENTITY_TYPES
            .register("beardeddragon",
                    () -> EntityType.Builder.create(BeardedDragonEntity::new, EntityClassification.CREATURE)
                            .size(0.25F,0.25F).build(new ResourceLocation(Reptiles.MOD_ID, "beardeddragon").toString()));
}
