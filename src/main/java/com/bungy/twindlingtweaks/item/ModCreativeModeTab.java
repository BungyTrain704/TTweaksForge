package com.bungy.twindlingtweaks.item;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TwindlingTweaks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TWINDLING_TWEAKS = CREATIVE_MODE_TABS.register("twindling_tweaks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_ALLUMINITE.get()))
                    .title(Component.literal("Twindling Tweaks"))
                    .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModItems.MUD_BALL.get());
                                pOutput.accept(ModItems.DRIED_MUD_BALL.get());
                                pOutput.accept(ModItems.RAW_LUMINIUM.get());
                                pOutput.accept(ModItems.UNPROCESSED_LUMINIUM_CHUNK.get());
                                pOutput.accept(ModItems.LUMINIUM_CHUNK.get());
                                pOutput.accept(ModItems.LUMINIUM_GEM.get());
                                pOutput.accept(ModItems.LUMINIUM_APPLE.get());
                                pOutput.accept(ModItems.RAW_ALLUMINITE.get());
                                pOutput.accept(ModItems.ALLUMINITE_INGOT.get());
                                pOutput.accept(ModItems.ALLUMINITE_NUGGET.get());
                                pOutput.accept(ModItems.REINFORCED_ALLUMINITE_INGOT.get());
                                pOutput.accept(ModItems.STONE_HAMMER.get());
                                pOutput.accept(ModItems.ALLUMINITE_SWORD.get());
                                pOutput.accept(ModItems.ALLUMINITE_AXE.get());
                                pOutput.accept(ModItems.ALLUMINITE_PICKAXE.get());
                                pOutput.accept(ModItems.ALLUMINITE_SHOVEL.get());
                                pOutput.accept(ModItems.ALLUMINITE_HOE.get());
                                pOutput.accept(ModItems.ALLUMINITE_ROD.get());
                                pOutput.accept(ModItems.ALLUMINITE_ROD_SHARD.get());
                                pOutput.accept(ModItems.ALLUMINITE_HELMET.get());
                                pOutput.accept(ModItems.ALLUMINITE_CHESTPLATE.get());
                                pOutput.accept(ModItems.ALLUMINITE_LEGGINGS.get());
                                pOutput.accept(ModItems.ALLUMINITE_BOOTS.get());
                                pOutput.accept(ModItems.OBSIDIAN_HELMET.get());
                                pOutput.accept(ModItems.OBSIDIAN_CHESTPLATE.get());
                                pOutput.accept(ModItems.OBSIDIAN_LEGGINGS.get());
                                pOutput.accept(ModItems.OBSIDIAN_BOOTS.get());
                                pOutput.accept(ModItems.OBSIDIAN_SWORD.get());
                                pOutput.accept(ModItems.OBSIDIAN_AXE.get());
                                pOutput.accept(ModItems.OBSIDIAN_PICKAXE.get());
                                pOutput.accept(ModItems.OBSIDIAN_SHOVEL.get());
                                pOutput.accept(ModItems.OBSIDIAN_HOE.get());
                                pOutput.accept(ModItems.UNFILTERED_SUGAR.get());
                                pOutput.accept(ModItems.SALAD_TOPPINGS.get());
                                pOutput.accept(ModItems.SALAD.get());
                                //pOutput.accept(ModItems.BANANA.get());
                                pOutput.accept(ModItems.RANCH_BOTTLE.get());
                                pOutput.accept(ModItems.CROUTON.get());
                                pOutput.accept(ModItems.CUCUMBER.get());
                                pOutput.accept(ModItems.LETTUCE.get());
                                pOutput.accept(ModItems.ORANGE.get());
                                pOutput.accept(ModItems.ORANGE_SEEDS.get());
                                pOutput.accept(ModItems.ORANGE_SEED_POWDER.get());
                                pOutput.accept(ModItems.ORANGE_SEED_MILK.get());
                                pOutput.accept(ModItems.TOMATO.get());
                                pOutput.accept(ModItems.CUCUMBER_SEEDS.get());
                                pOutput.accept(ModItems.LETTUCE_SEEDS.get());
                                pOutput.accept(ModItems.TOMATO_SEEDS.get());
                                pOutput.accept(ModItems.MYSTICAL_MUSIC_DISC.get());
                                    pOutput.accept(ModBlocks.MUD_BLOCK.get());
                                    pOutput.accept(ModBlocks.CRUSHER.get());
                                    pOutput.accept(ModBlocks.DRIED_MUD_BLOCK.get());
                                    pOutput.accept(ModBlocks.MUD_DOOR.get());
                                    pOutput.accept(ModBlocks.MUD_TRAPDOOR.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_LOG.get());
                                    pOutput.accept(ModBlocks.STRIPPED_RED_MAPLE_LOG.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_WOOD.get());
                                    pOutput.accept(ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_PLANKS.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_LEAVES.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_SAPLING.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_STAiRS.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_SLAB.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_DOOR.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_TRAPDOOR.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_BUTTON.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_PRESSURE_PLATE.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_FENCE.get());
                                    pOutput.accept(ModBlocks.RED_MAPLE_FENCE_GATE.get());
                                    pOutput.accept(ModBlocks.CATALPA_LOG.get());
                                    pOutput.accept(ModBlocks.STRIPPED_CATALPA_LOG.get());
                                    pOutput.accept(ModBlocks.CATALPA_WOOD.get());
                                    pOutput.accept(ModBlocks.STRIPPED_CATALPA_WOOD.get());
                                    pOutput.accept(ModBlocks.CATALPA_PLANKS.get());
                                    pOutput.accept(ModBlocks.CATALPA_LEAVES.get());
                                    pOutput.accept(ModBlocks.CATALPA_SAPLING.get());
                                    pOutput.accept(ModBlocks.CATALPA_STAiRS.get());
                                    pOutput.accept(ModBlocks.CATALPA_SLAB.get());
                                    pOutput.accept(ModBlocks.CATALPA_DOOR.get());
                                    pOutput.accept(ModBlocks.CATALPA_TRAPDOOR.get());
                                    pOutput.accept(ModBlocks.CATALPA_BUTTON.get());
                                    pOutput.accept(ModBlocks.CATALPA_PRESSURE_PLATE.get());
                                    pOutput.accept(ModBlocks.CATALPA_FENCE.get());
                                    pOutput.accept(ModBlocks.CATALPA_FENCE_GATE.get());
                                    pOutput.accept(ModBlocks.REINFORCED_OBSIDIAN.get());
                                    pOutput.accept(ModBlocks.OBSIDIAN_FORGER.get());
                                    pOutput.accept(ModBlocks.UNFILTERED_SUGAR_BLOCK.get());
                                    pOutput.accept(ModBlocks.SUGAR_BLOCK.get());
                                    pOutput.accept(ModBlocks.ALLUMINITE_BLOCK.get());
                                    pOutput.accept(ModBlocks.RAW_LUMINIUM_BLOCK.get());
                                    pOutput.accept(ModBlocks.LUMINIUM_BLOCK.get());
                                    pOutput.accept(ModBlocks.RAW_ALLUMINITE_BLOCK.get());
                                    pOutput.accept(ModBlocks.MUD_ORE.get());
                                    pOutput.accept(ModBlocks.DEEPSLATE_MUD_ORE.get());
                                    pOutput.accept(ModBlocks.SUGAR_ORE.get());
                                    pOutput.accept(ModBlocks.DEEPSLATE_SUGAR_ORE.get());
                                    pOutput.accept(ModBlocks.ALLUMINITE_ORE.get());
                                    pOutput.accept(ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get());
                                    pOutput.accept(ModBlocks.LUMINIUM_ORE.get());
                                    pOutput.accept(ModBlocks.DEEPSLATE_LUMINIUM_ORE.get());
                                    pOutput.accept(ModBlocks.FILTERER.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
