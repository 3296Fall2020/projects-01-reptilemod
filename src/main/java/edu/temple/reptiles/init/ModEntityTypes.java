package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.BeardedDragonEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reptiles.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<BeardedDragonEntity>> BEARDEDDRAGON = ENTITY_TYPES
            .register("beardeddragon",
                    () -> EntityType.Builder.create(BeardedDragonEntity::new, EntityClassification.CREATURE)
            .size(0.25F,0.25F).build(new ResourceLocation(Reptiles.MOD_ID, "beardeddragon").toString()));
}
