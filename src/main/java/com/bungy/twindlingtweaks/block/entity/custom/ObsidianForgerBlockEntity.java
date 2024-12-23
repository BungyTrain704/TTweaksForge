package com.bungy.twindlingtweaks.block.entity.custom;


import com.bungy.twindlingtweaks.block.entity.ModBlockEntities;
import com.bungy.twindlingtweaks.recipes.ObsidianForgerRecipe;
import com.bungy.twindlingtweaks.screen.ObsidianForgerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityProvider;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Stack;

import static net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity.isFuel;

public class ObsidianForgerBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public ObsidianForgerBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.OBSIDIAN_FORGER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return ObsidianForgerBlockEntity.this.progress;
                    case 1: return ObsidianForgerBlockEntity.this.maxProgress;
                    case 2: return ObsidianForgerBlockEntity.this.fuelTime;
                    case 3: return ObsidianForgerBlockEntity.this.maxFuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: ObsidianForgerBlockEntity.this.progress = value; break;
                    case 1: ObsidianForgerBlockEntity.this.maxProgress = value; break;
                    case 2: ObsidianForgerBlockEntity.this.fuelTime = value; break;
                    case 3: ObsidianForgerBlockEntity.this.maxFuelTime = value; break;
                }
            }

            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Obsidian Forger");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new ObsidianForgerMenu(pContainerId, pInventory, this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("obsidian_forger.progress", progress);
        tag.putInt("obsidian_forger.fuelTime", fuelTime);
        tag.putInt("obsidian_forger.maxFuelTime", maxFuelTime);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("obsidian_forger.progress");
        fuelTime = nbt.getInt("obsidian_forger.fuelTime");
        maxFuelTime = nbt.getInt("obsidian_forger.maxFuelTime");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, ObsidianForgerBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState);
            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel, pPos, pState);
        }
    }

    private static boolean hasRecipe(ObsidianForgerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<ObsidianForgerRecipe> match = level.getRecipeManager()
                .getRecipeFor(ObsidianForgerRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
                && hasItemInFuelSlot(entity);
    }

    private static boolean hasItemInFuelSlot(ObsidianForgerBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() == Items.COAL ||
                entity.itemHandler.getStackInSlot(0).getItem() == Items.CHARCOAL ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.COAL_BLOCK.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Items.LAVA_BUCKET ||
                entity.itemHandler.getStackInSlot(0).getItem() == Items.STICK ||
                entity.itemHandler.getStackInSlot(0).getItem() == Items.BLAZE_ROD ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.OAK_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_OAK_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.OAK_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.BIRCH_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_BIRCH_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.BIRCH_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.JUNGLE_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_JUNGLE_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.JUNGLE_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.SPRUCE_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_SPRUCE_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.SPRUCE_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.ACACIA_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_ACACIA_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.ACACIA_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.DARK_OAK_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_DARK_OAK_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.DARK_OAK_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.MANGROVE_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_MANGROVE_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.MANGROVE_PLANKS.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.CHERRY_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.STRIPPED_CHERRY_LOG.asItem() ||
                entity.itemHandler.getStackInSlot(0).getItem() == Blocks.CHERRY_PLANKS.asItem();



    }



    private static void craftItem(ObsidianForgerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<ObsidianForgerRecipe> match = level.getRecipeManager()
                .getRecipeFor(ObsidianForgerRecipe.Type.INSTANCE, inventory, level);

        if(match.isPresent()) {
            entity.itemHandler.extractItem(0,1, false);
            entity.itemHandler.extractItem(1,1, false);
            entity.itemHandler.extractItem(2,1, false);

            entity.itemHandler.setStackInSlot(3, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(3).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(3).getItem() == output.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }
}