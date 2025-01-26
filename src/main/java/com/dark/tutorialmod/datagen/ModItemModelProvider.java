package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CYRENIAN_INGOT.get());
        basicItem(ModItems.CYRENIAN_NUGGET.get());
        basicItem(ModItems.RAW_CYRENIAN.get());

        basicItem(ModItems.PINEAPPLE.get());
        basicItem(ModItems.BLUEBERRIES.get());
        basicItem(ModItems.UNSTABLE_CONCOCTION.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.MYSTIC_POWDER.get());
        basicItem(ModItems.RAW_JADE.get());
        basicItem(ModItems.JADE.get());

        handheldItem(ModItems.EMPOWERED_IRON_AXE);
        handheldItem(ModItems.EMPOWERED_IRON_HOE);
        handheldItem(ModItems.EMPOWERED_IRON_PICKAXE);
        handheldItem(ModItems.EMPOWERED_IRON_SHOVEL);
        handheldItem(ModItems.EMPOWERED_IRON_SWORD);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));

    }
}