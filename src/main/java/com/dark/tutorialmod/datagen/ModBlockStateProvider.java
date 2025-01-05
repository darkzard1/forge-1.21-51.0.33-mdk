package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.CYRENIAN_ORE);
        blockWithItem(ModBlocks.CYRENIAN_DEEPSLATE_ORE);

        stairsBlock(((StairBlock) ModBlocks.OBSIDIAN_STAIRS.get()), blockTexture(Blocks.OBSIDIAN));
        blockItem(ModBlocks.OBSIDIAN_STAIRS);

        stairsBlock(((StairBlock) ModBlocks.DIAMOND_STAIRS.get()), blockTexture(Blocks.DIAMOND_BLOCK));
        blockItem(ModBlocks.DIAMOND_STAIRS);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
}
