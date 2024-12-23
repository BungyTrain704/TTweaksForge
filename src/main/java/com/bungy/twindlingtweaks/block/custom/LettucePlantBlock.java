package com.bungy.twindlingtweaks.block.custom;

import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class LettucePlantBlock extends CropBlock {
    public LettucePlantBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LETTUCE_SEEDS.get();
    }
}
