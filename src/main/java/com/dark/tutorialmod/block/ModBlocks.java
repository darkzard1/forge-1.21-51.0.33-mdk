package com.dark.tutorialmod.block;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.block.custom.MagicBlock;
import com.dark.tutorialmod.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> CYRENIAN_ORE = registerBlock("cyrenian_ore",
            () -> new DropExperienceBlock(UniformInt.of(5, 10), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> JADE_DEPOSIT = registerBlock("jade_deposit",
            () -> new DropExperienceBlock(UniformInt.of(7, 11), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final RegistryObject<Block> CYRENIAN_DEEPSLATE_ORE = registerBlock("cyrenian_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(5, 10), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RAW_CYRENIAN_BLOCK = registerBlock("raw_cyrenian_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> CYRENIAN_BLOCK = registerBlock("cyrenian_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOUL_SAND_BRICK = registerBlock("soul_sand_brick",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOUL_SAND_BRICKS = registerBlock("soul_sand_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SAND_SOIL = registerBlock("sand_soil",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.SAND)));

    public static final RegistryObject<Block> SOUL_SAND_BRICK_CRACKED = registerBlock("soul_sand_brick_cracked",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOUL_SAND_BRICK_EMPOWERED = registerBlock("soul_sand_brick_empowered",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOUL_SAND_BRICK_LEAKING = registerBlock("soul_sand_brick_leaking",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).noLootTable()));

    public static final RegistryObject<Block> SOUL_SAND_BRICK_STAIRS = registerBlock("soul_sand_brick_stairs",
            () -> new StairBlock(ModBlocks.SOUL_SAND_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> OBSIDIAN_STAIRS = registerBlock("obsidian_stairs",
            () -> new StairBlock(Blocks.OBSIDIAN.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DIAMOND_STAIRS = registerBlock("diamond_stairs",
            () -> new StairBlock(Blocks.DIAMOND_BLOCK.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SOUL_SAND_BRICK_SLAB = registerBlock("soul_sand_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
