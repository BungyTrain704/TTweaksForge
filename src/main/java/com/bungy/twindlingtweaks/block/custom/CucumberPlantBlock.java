package com.bungy.twindlingtweaks.block.custom;

import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class CucumberPlantBlock extends CropBlock {
    public CucumberPlantBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CUCUMBER_SEEDS.get();
    }
}
