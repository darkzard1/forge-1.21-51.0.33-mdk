package com.dark.tutorialmod.items;

import com.dark.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier EMPOWERED_NETHERITE = new ForgeTier(4031, 12f, 8f, 22,
            ModTags.Blocks.NEEDS_EMPOWERED_NETHERITE_TOOL, () -> Ingredient.of(ModItems.CYRENIAN_NUGGET.get()), ModTags.Blocks.INCORRECT_FOR_EMPOWERED_NETHERITE_TOOL);

    public static final Tier ARTIFACT_TOOLS = new ForgeTier(1500, 12f, 0f, 30,
            ModTags.Blocks.NEEDS_ARTIFACT_TOOL, () -> Ingredient.of(ModItems.CYRENIAN_NUGGET.get()), ModTags.Blocks.INCORRECT_FOR_ARTIFACT_TOOL);
}
