package com.bungy.twindlingtweaks.integration;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.recipes.CrusherRecipe;
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

public class CrusherRecipeCategory implements IRecipeCategory<CrusherRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TwindlingTweaks.MOD_ID, "crushing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TwindlingTweaks.MOD_ID, "textures/gui/crusher_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CrusherRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CRUSHER.get()));
    }

    @Override
    public RecipeType<CrusherRecipe> getRecipeType() {
        return JEITwindlingTweaksPlugin.CRUSHING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Crusher");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CrusherRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 35, 8).addIngredients(Ingredient.of(ModItems.STONE_HAMMER.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 35, 35).addIngredients(Ingredient.of(ModItems.ORANGE_SEEDS.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 115, 34).addItemStack(recipe.getResultItem());
    }
}