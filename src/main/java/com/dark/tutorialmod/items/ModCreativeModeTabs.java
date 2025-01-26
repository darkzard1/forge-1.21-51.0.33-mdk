package com.dark.tutorialmod.items;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> CYRENIAN_ITEMS_TAB = CREATIVE_MODE_TABS.register("cyrenian_items_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.RAW_CYRENIAN.get()))
                    .title(Component.translatable("creativetab.tutorialmod.cyrenian_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_CYRENIAN.get());
                        output.accept(ModItems.CYRENIAN_NUGGET.get());
                        output.accept(ModItems.CYRENIAN_INGOT.get());
                        output.accept(ModItems.EMPOWERED_IRON_AXE.get());
                        output.accept(ModItems.EMPOWERED_IRON_HOE.get());
                        output.accept(ModItems.EMPOWERED_IRON_PICKAXE.get());
                        output.accept(ModItems.EMPOWERED_IRON_SHOVEL.get());
                        output.accept(ModItems.EMPOWERED_IRON_SWORD.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> CYRENIAN_BLOCKS_TAB = CREATIVE_MODE_TABS.register("cyrenian_blocks_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.CYRENIAN_ORE.get()))
                    .withTabsBefore(CYRENIAN_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.cyrenian_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RAW_CYRENIAN_BLOCK.get());
                        output.accept(ModBlocks.CYRENIAN_ORE.get());
                        output.accept(ModBlocks.CYRENIAN_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.CYRENIAN_BLOCK.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> NEW_FOODS_TAB = CREATIVE_MODE_TABS.register("new_foods_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BLUEBERRIES.get()))
                    .withTabsBefore(CYRENIAN_BLOCKS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.new_foods"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLUEBERRIES.get());
                        output.accept(ModItems.PINEAPPLE.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
