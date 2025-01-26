package com.dark.tutorialmod;

import com.dark.tutorialmod.block.ModBlocks;
import com.dark.tutorialmod.items.ModCreativeModeTabs;
import com.dark.tutorialmod.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_CYRENIAN);
            event.accept(ModItems.CYRENIAN_NUGGET);
            event.accept(ModItems.CYRENIAN_INGOT);
            event.accept(ModItems.MYSTIC_POWDER);
            event.accept(ModItems.UNSTABLE_CONCOCTION);
            event.accept(ModItems.JADE);
            event.accept(ModItems.RAW_JADE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CYRENIAN_ORE);
            event.accept(ModBlocks.RAW_CYRENIAN_BLOCK);
            event.accept(ModBlocks.CYRENIAN_BLOCK);
            event.accept(ModBlocks.OBSIDIAN_STAIRS);
            event.accept(ModBlocks.DIAMOND_STAIRS);
            event.accept(ModBlocks.SOUL_SAND_BRICK);
            event.accept(ModBlocks.SOUL_SAND_BRICKS);
            event.accept(ModBlocks.SOUL_SAND_BRICK_EMPOWERED);
            event.accept(ModBlocks.SOUL_SAND_BRICK_CRACKED);
            event.accept(ModBlocks.SOUL_SAND_BRICK_LEAKING);
            event.accept(ModBlocks.SOUL_SAND_BRICK_STAIRS);
            event.accept(ModBlocks.SOUL_SAND_BRICK_SLAB);
            event.accept(ModBlocks.SAND_SOIL);
            event.accept(ModBlocks.JADE_DEPOSIT);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.CHISEL);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
