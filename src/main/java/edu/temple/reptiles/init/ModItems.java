package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reptiles.MOD_ID);

    public static final RegistryObject<Item> CRICKET = ITEMS.register("cricket",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC))
            );

    public static final RegistryObject<Item> MEAL_WORM = ITEMS.register("meal_worm",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC))
    );
}
