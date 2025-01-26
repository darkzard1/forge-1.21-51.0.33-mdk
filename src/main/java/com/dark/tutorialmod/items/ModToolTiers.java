package com.dark.tutorialmod.items;

import com.dark.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier EMPOWERED_IRON = new ForgeTier(2300, 10.5f, 6f, 18,
            ModTags.Blocks.NEEDS_EMPOWERED_IRON_TOOL, () -> Ingredient.of(ModItems.CYRENIAN_NUGGET.get()), ModTags.Blocks.INCORRECT_FOR_EMPOWERED_IRON_TOOL);
}
