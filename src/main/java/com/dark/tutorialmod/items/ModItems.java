package com.dark.tutorialmod.items;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.items.custom.ChiselItem;
import com.dark.tutorialmod.items.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RAW_CYRENIAN = ITEMS.register("raw_cyrenian",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.raw_cyrenian"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> RAW_JADE = ITEMS.register("raw_jade",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
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

    public static final RegistryObject<Item> EMPOWERED_NETHERITE_SWORD = ITEMS.register("empowered_netherite_sword",
            () -> new SwordItem(ModToolTiers.EMPOWERED_NETHERITE,new Item.Properties().attributes(SwordItem.
                    createAttributes(ModToolTiers.EMPOWERED_NETHERITE, 3, -2.4f ))));

    public static final RegistryObject<Item> EMPOWERED_NETHERITE_SHOVEL = ITEMS.register("empowered_netherite_shovel",
            () -> new ShovelItem(ModToolTiers.EMPOWERED_NETHERITE,new Item.Properties().attributes(ShovelItem.
                    createAttributes(ModToolTiers.EMPOWERED_NETHERITE, 1.5F, -3.0F ))));

    public static final RegistryObject<Item> EMPOWERED_NETHERITE_PICKAXE = ITEMS.register("empowered_netherite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMPOWERED_NETHERITE,new Item.Properties().attributes(PickaxeItem.
                    createAttributes(ModToolTiers.EMPOWERED_NETHERITE, 1, -2.8f ))));

    public static final RegistryObject<Item> EMPOWERED_NETHERITE_AXE = ITEMS.register("empowered_netherite_axe",
            () -> new AxeItem(ModToolTiers.EMPOWERED_NETHERITE,new Item.Properties().attributes(AxeItem.
                    createAttributes(ModToolTiers.EMPOWERED_NETHERITE, 5, -3.0f ))));

    public static final RegistryObject<Item> EMPOWERED_NETHERITE_HOE = ITEMS.register("empowered_netherite_hoe",
            () -> new HoeItem(ModToolTiers.EMPOWERED_NETHERITE,new Item.Properties().attributes(HoeItem.
                    createAttributes(ModToolTiers.EMPOWERED_NETHERITE, -4, -1.0f ))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}