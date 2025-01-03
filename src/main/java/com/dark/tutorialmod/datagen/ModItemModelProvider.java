package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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
    }
}
