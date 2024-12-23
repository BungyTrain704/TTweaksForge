package com.bungy.twindlingtweaks.integration;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.recipes.ObsidianForgerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class ObsidianForgerRecipeCategory implements IRecipeCategory<ObsidianForgerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TwindlingTweaks.MOD_ID, "forging");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TwindlingTweaks.MOD_ID, "textures/gui/obsidian_forger_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ObsidianForgerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OBSIDIAN_FORGER.get()));
    }

    @Override
    public RecipeType<ObsidianForgerRecipe> getRecipeType() {
        return JEITwindlingTweaksPlugin.FORGING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Obsidian Forger");
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
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, ObsidianForgerRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 66, 50).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 66, 16).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 114, 33).addItemStack(recipe.getResultItem());
    }
}

