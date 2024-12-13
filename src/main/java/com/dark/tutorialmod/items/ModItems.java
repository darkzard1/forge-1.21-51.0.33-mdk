package com.dark.tutorialmod.items;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.items.custom.ChiselItem;
import com.dark.tutorialmod.items.custom.FuelItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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

    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BLUEBERRIES)));

    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PINEAPPLE)));

    public static final RegistryObject<Item> UNSTABLE_CONCOCTION = ITEMS.register("unstable_concoction",
            () -> new FuelItem(new Item.Properties(), 15000));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}