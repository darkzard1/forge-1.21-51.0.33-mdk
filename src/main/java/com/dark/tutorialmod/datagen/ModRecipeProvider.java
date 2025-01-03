package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.block.ModBlocks;
import com.dark.tutorialmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> CYRENIAN_SMELTABLES = List.of(ModItems.RAW_CYRENIAN.get());
                ModBlocks.CYRENIAN_ORE.get();


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYRENIAN_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CYRENIAN_INGOT.get())
                .unlockedBy(getHasName(ModItems.CYRENIAN_INGOT.get()), has(ModItems.CYRENIAN_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CYRENIAN_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CYRENIAN_NUGGET.get())
                .unlockedBy(getHasName(ModItems.CYRENIAN_NUGGET.get()), has(ModItems.CYRENIAN_NUGGET.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CYRENIAN_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_CYRENIAN.get())
                .unlockedBy(getHasName(ModItems.RAW_CYRENIAN.get()), has(ModItems.RAW_CYRENIAN.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.CYRENIAN_INGOT.get(),9)
                .requires(ModBlocks.CYRENIAN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CYRENIAN_BLOCK.get()), has(ModBlocks.CYRENIAN_BLOCK.get())).save(pRecipeOutput,
                        TutorialMod.MOD_ID + ":cyrenian_from_cyrenian_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.CYRENIAN_NUGGET.get(),9)
                .requires(ModItems.CYRENIAN_INGOT.get())
                .unlockedBy(getHasName(ModItems.CYRENIAN_INGOT.get()), has(ModItems.CYRENIAN_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_CYRENIAN.get(),9)
                .requires(ModBlocks.RAW_CYRENIAN_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_CYRENIAN_BLOCK.get()), has(ModBlocks.RAW_CYRENIAN_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, CYRENIAN_SMELTABLES, RecipeCategory.MISC, ModItems.CYRENIAN_INGOT.get(), 5.0f, 1000, "cyrenian_ingot");
        oreBlasting(pRecipeOutput, CYRENIAN_SMELTABLES, RecipeCategory.MISC, ModItems.CYRENIAN_INGOT.get(), 6.0f, 800, "cyrenian_ingot");


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
