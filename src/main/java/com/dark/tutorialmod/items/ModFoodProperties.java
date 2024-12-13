package com.dark.tutorialmod.items;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties BLUEBERRIES = new FoodProperties.Builder().nutrition(3).saturationModifier(.5f).build();

    public static final FoodProperties PINEAPPLE = new FoodProperties.Builder().nutrition(6).saturationModifier(.9f).build();

}
