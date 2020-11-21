package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemTypes {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reptiles.MOD_ID);


    public static final RegistryObject<Item> CRICKET = ITEMS.register("cricket",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC))
    );

    public static final RegistryObject<Item> MEAL_WORM = ITEMS.register("meal_worm",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC))
    );

    public static final RegistryObject<Item> CLIMB_BLOCK = ITEMS.register("climb_block",
            () -> new BlockItem(ModBlockTypes.CLIMB_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
}
