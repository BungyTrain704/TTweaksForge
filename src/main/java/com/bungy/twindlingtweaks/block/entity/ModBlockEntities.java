package com.bungy.twindlingtweaks.block.entity;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.entity.custom.CrusherBlockEntity;
import com.bungy.twindlingtweaks.block.entity.custom.FiltererBlockEntity;
import com.bungy.twindlingtweaks.block.entity.custom.ObsidianForgerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TwindlingTweaks.MOD_ID);

    public static final RegistryObject<BlockEntityType<ObsidianForgerBlockEntity>> OBSIDIAN_FORGER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("obsidian_forger_block_entity", () ->
                    BlockEntityType.Builder.of(ObsidianForgerBlockEntity::new,
                            ModBlocks.OBSIDIAN_FORGER.get()).build(null));

    public static final RegistryObject<BlockEntityType<FiltererBlockEntity>> FILTERER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("filterer_block_entity", () ->
                    BlockEntityType.Builder.of(FiltererBlockEntity::new,
                            ModBlocks.FILTERER.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrusherBlockEntity>> CRUSHER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("crusher_block_entity", () ->
                    BlockEntityType.Builder.of(CrusherBlockEntity::new,
                            ModBlocks.CRUSHER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}