package com.bungy.twindlingtweaks.item;

import com.bungy.twindlingtweaks.block.ModBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier ALLUMINITE = new ForgeTier(3, 1500,9.8F,
            0F, 15, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.REINFORCED_ALLUMINITE_INGOT.get()));

    public static final ForgeTier OBSIDIAN = new ForgeTier(3, 3000,11F,
            0F, 30, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModBlocks.REINFORCED_OBSIDIAN.get()));

}
