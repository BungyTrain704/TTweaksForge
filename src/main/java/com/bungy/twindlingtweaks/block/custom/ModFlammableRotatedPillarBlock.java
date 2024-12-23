package com.bungy.twindlingtweaks.block.custom;

import com.bungy.twindlingtweaks.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.CATALPA_LOG.get())) {
                return ModBlocks.STRIPPED_CATALPA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.CATALPA_WOOD.get())) {
                return ModBlocks.STRIPPED_CATALPA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (context.getItemInHand().getItem() instanceof AxeItem) {
                if (state.is(ModBlocks.RED_MAPLE_LOG.get())) {
                    return ModBlocks.STRIPPED_RED_MAPLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
                if (state.is(ModBlocks.RED_MAPLE_WOOD.get())) {
                    return ModBlocks.STRIPPED_RED_MAPLE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
            }



            return state;
        }
        return state;
    }
    }
