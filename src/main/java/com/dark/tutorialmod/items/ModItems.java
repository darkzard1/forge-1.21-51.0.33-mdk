package com.dark.tutorialmod.items;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.items.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RAW_CYRENIAN = ITEMS.register("raw_cyrenian",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CYRENIAN_NUGGET = ITEMS.register("cyrenian_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CYRENIAN_INGOT = ITEMS.register("cyrenian_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> MYSTIC_POWDER = ITEMS.register("mystic_powder",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}