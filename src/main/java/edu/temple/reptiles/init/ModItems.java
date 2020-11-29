package edu.temple.reptiles.init;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.amor.ModArmorMaterial;
import edu.temple.reptiles.items.ModSpawnEggItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reptiles.MOD_ID);

    //Materials
    public static final RegistryObject<Item> CRICKET = ITEMS.register("cricket",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<Item> MEAL_WORM = ITEMS.register("meal_worm",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<Item> SCALE = ITEMS.register("scale",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    //Armor
    public static final RegistryObject<ArmorItem> SCALE_MAIL_HELMET = ITEMS.register("scale_mail_helmet",
            () -> new ArmorItem(ModArmorMaterial.SCALE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT))
    );
    public static final RegistryObject<ArmorItem> SCALE_MAIL_CHESTPLATE = ITEMS.register("scale_mail_chestplate",
            () -> new ArmorItem(ModArmorMaterial.SCALE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT))
    );
    public static final RegistryObject<ArmorItem> SCALE_MAIL_LEGGINGS = ITEMS.register("scale_mail_leggings",
            () -> new ArmorItem(ModArmorMaterial.SCALE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT))
    );
    public static final RegistryObject<ArmorItem> SCALE_MAIL_BOOTS = ITEMS.register("scale_mail_boots",
            () -> new ArmorItem(ModArmorMaterial.SCALE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT))
    );

    //Tools


    //Spawn Eggs
    public static final RegistryObject<ModSpawnEggItem> BEARDED_DRAGON_SPAWN_EGG = ITEMS.register("bearded_dragon_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BEARDEDDRAGON, 0xedb879, 0xe07b39, new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<ModSpawnEggItem> CHAMELEON_SPAWN_EGG = ITEMS.register("chameleon_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.CHAMELEON, 0x19F513, 0x094907, new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<ModSpawnEggItem> CROCODILE_SPAWN_EGG = ITEMS.register("crocodile_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.CROCODILE, 0x084C06, 0x332A00, new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<ModSpawnEggItem> DINOSAUR_SPAWN_EGG = ITEMS.register("dinosaur_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.DINOSAUR, 0xC8CB60, 0x505128, new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<ModSpawnEggItem> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.GECKO, 0xF2F58F, 0x232318, new Item.Properties().group(ItemGroup.MISC))
    );
    public static final RegistryObject<ModSpawnEggItem> NESSIE_SPAWN_EGG = ITEMS.register("nessie_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.NESSIE, 0x30F2EC, 0x0B302F, new Item.Properties().group(ItemGroup.MISC))
    );
}
