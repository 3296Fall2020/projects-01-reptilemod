package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.DinosaurEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reptiles.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<DinosaurEntity>> DINOSAUR = ENTITY_TYPES.register("dinosaur",
            () -> EntityType.Builder.create(DinosaurEntity::new, EntityClassification.MONSTER)
                    .size(1.95f, 2.3f)
                    .build(new ResourceLocation(Reptiles.MOD_ID, "dinosaur").toString()));
}
