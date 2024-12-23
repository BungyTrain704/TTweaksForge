package com.bungy.twindlingtweaks.integration;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.recipes.FiltererRecipe;
import com.bungy.twindlingtweaks.recipes.ObsidianForgerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class FiltererRecipeCategory implements IRecipeCategory<FiltererRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TwindlingTweaks.MOD_ID, "filtering");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TwindlingTweaks.MOD_ID, "textures/gui/filterer_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public FiltererRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FILTERER.get()));
    }

    @Override
    public RecipeType<FiltererRecipe> getRecipeType() {
        return JEITwindlingTweaksPlugin.FILTERING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Filterer");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FiltererRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));

    }

    }