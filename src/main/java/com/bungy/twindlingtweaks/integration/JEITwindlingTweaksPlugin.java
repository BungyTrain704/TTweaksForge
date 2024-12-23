package com.bungy.twindlingtweaks.integration;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.recipes.CrusherRecipe;
import com.bungy.twindlingtweaks.recipes.FiltererRecipe;
import com.bungy.twindlingtweaks.recipes.ObsidianForgerRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITwindlingTweaksPlugin implements IModPlugin {
    public static RecipeType<ObsidianForgerRecipe> FORGING_TYPE =
            new RecipeType<>(ObsidianForgerRecipeCategory.UID, ObsidianForgerRecipe.class);

    public static RecipeType<CrusherRecipe> CRUSHING_TYPE =
            new RecipeType<>(CrusherRecipeCategory.UID, CrusherRecipe.class);

    public static RecipeType<FiltererRecipe> FILTERING_TYPE =
            new RecipeType<>(FiltererRecipeCategory.UID, FiltererRecipe.class);


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TwindlingTweaks.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                ObsidianForgerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                FiltererRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                CrusherRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<ObsidianForgerRecipe> recipesForging = rm.getAllRecipesFor(ObsidianForgerRecipe.Type.INSTANCE);
        registration.addRecipes(FORGING_TYPE, recipesForging);

        List<FiltererRecipe> recipesFiltering = rm.getAllRecipesFor(FiltererRecipe.Type.INSTANCE);
        registration.addRecipes(FILTERING_TYPE, recipesFiltering);

        List<CrusherRecipe> recipesCrushing = rm.getAllRecipesFor(CrusherRecipe.Type.INSTANCE);
        registration.addRecipes(CRUSHING_TYPE, recipesCrushing);

    }
}