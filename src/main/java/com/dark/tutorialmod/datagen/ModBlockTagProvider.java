package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.block.ModBlocks;
import com.dark.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CYRENIAN_BLOCK.get())
                .add(ModBlocks.CYRENIAN_ORE.get())
                .add(ModBlocks.CYRENIAN_DEEPSLATE_ORE.get())
                .add(ModBlocks.RAW_CYRENIAN_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CYRENIAN_BLOCK.get())
                .add(ModBlocks.CYRENIAN_ORE.get())
                .add(ModBlocks.CYRENIAN_DEEPSLATE_ORE.get())
                .add(ModBlocks.RAW_CYRENIAN_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get());

    }
}
