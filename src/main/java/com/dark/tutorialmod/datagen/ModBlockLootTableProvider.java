package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.block.ModBlocks;
import com.dark.tutorialmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CYRENIAN_BLOCK.get());
        dropSelf(ModBlocks.RAW_CYRENIAN_BLOCK.get());
        //dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.CYRENIAN_ORE.get(),
                block -> createOreDrop(ModBlocks.CYRENIAN_ORE.get(), ModItems.RAW_CYRENIAN.get()));
        this.add(ModBlocks.CYRENIAN_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.CYRENIAN_DEEPSLATE_ORE.get(), ModItems.RAW_CYRENIAN.get(), 1, 2));

        this.dropSelf(ModBlocks.OBSIDIAN_STAIRS.get());
    }

    //the class under the comment is to make blocks drop multiple items upon breaking
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
