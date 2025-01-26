package com.dark.tutorialmod.datagen;

import com.dark.tutorialmod.TutorialMod;
import com.dark.tutorialmod.block.ModBlocks;
import com.dark.tutorialmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
                ModBlocks.CYRENIAN_DEEPSLATE_ORE.get();

        List<ItemLike> JADE_SMELTABLES = List.of(ModItems.RAW_JADE.get());
        ModBlocks.JADE_DEPOSIT.get();


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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_SAND_BRICK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.SOUL_SAND)
                .unlockedBy(getHasName(Items.SOUL_SAND), has(Items.SOUL_SAND)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_SAND_BRICKS.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.SOUL_SAND)
                .unlockedBy(getHasName(Items.SOUL_SAND), has(Items.SOUL_SAND)).save(pRecipeOutput);

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

        oreSmelting(pRecipeOutput, CYRENIAN_SMELTABLES, RecipeCategory.MISC, ModItems.CYRENIAN_NUGGET.get(), 5.0f, 1000, "cyrenian_nugget");
        oreBlasting(pRecipeOutput, CYRENIAN_SMELTABLES, RecipeCategory.MISC, ModItems.CYRENIAN_NUGGET.get(), 6.0f, 800, "cyrenian_nugget");

        oreSmelting(pRecipeOutput, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE.get(), 5.0f, 1000, "jade");
        oreBlasting(pRecipeOutput, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE.get(), 6.0f, 800, "jade");



        stairBuilder(ModBlocks.OBSIDIAN_STAIRS.get(), Ingredient.of(Items.OBSIDIAN))
                .unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(pRecipeOutput);

        stairBuilder(ModBlocks.DIAMOND_STAIRS.get(), Ingredient.of(Items.DIAMOND_BLOCK))
                .unlockedBy("has_diamond_block", has(Items.DIAMOND_BLOCK)).save(pRecipeOutput);

        stairBuilder(ModBlocks.SOUL_SAND_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.SOUL_SAND_BRICK.get()))
                .unlockedBy("has_soul_sand_brick", has(ModBlocks.SOUL_SAND_BRICK.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SAND_BRICK_SLAB.get(), ModBlocks.SOUL_SAND_BRICK.get());
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
