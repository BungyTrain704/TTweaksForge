package com.bungy.twindlingtweaks.world.feature;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.data.worldgen.placement.PlacementUtils.createKey;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RED_MAPLE_CHECKED_KEY = createKey("red_maple_checked");
    public static final ResourceKey<PlacedFeature> RED_MAPLE_PLACED_KEY = createKey("red_maple_placed");

    public static final ResourceKey<PlacedFeature> CATALPA_CHECKED_KEY = createKey("catalpa_checked");
    public static final ResourceKey<PlacedFeature> CATALPA_PLACED_KEY = createKey("catalpa_placed");

    public static final ResourceKey<PlacedFeature> LUMINIUM_PLACED_KEY = createKey("luminium_placed");
    public static final ResourceKey<PlacedFeature> ALLUMINITE_PLACED_KEY = createKey("alluminite_placed");
    public static final ResourceKey<PlacedFeature> RAW_ALLUMINITE_BLOCK_PLACED_KEY = createKey("raw_alluminite_block_placed");
    public static final ResourceKey<PlacedFeature> MUD_PLACED_KEY = createKey("mud_placed");
    public static final ResourceKey<PlacedFeature> SUGAR_PLACED_KEY = createKey("sugar_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, RED_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.RED_MAPLE_SAPLING.get()));

        register(context, CATALPA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CATALPA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.CATALPA_SAPLING.get()));


        register(context, LUMINIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_LUMINIUM_ORE_KEY),
                commonOrePlacement(7, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-90), VerticalAnchor.aboveBottom(120))));

        register(context, ALLUMINITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ALLUMINITE_ORE_KEY),
                commonOrePlacement(16, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-90), VerticalAnchor.aboveBottom(120))));

        register(context, RAW_ALLUMINITE_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RAW_ALLUMINITE_BLOCK_KEY),
                commonOrePlacement(4, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-90), VerticalAnchor.aboveBottom(120))));

        register(context, MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MUD_ORE_KEY),
                commonOrePlacement(16, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-90), VerticalAnchor.aboveBottom(120))));

        register(context, SUGAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SUGAR_ORE_KEY),
                commonOrePlacement(15, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-90), VerticalAnchor.aboveBottom(120))));


    }
        public static List<PlacementModifier> orePlacement (PlacementModifier p_195347_, PlacementModifier p_195348_){
            return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
        }

        public static List<PlacementModifier> commonOrePlacement ( int p_195344_, PlacementModifier p_195345_){
            return orePlacement(CountPlacement.of(p_195344_), p_195345_);
        }

        public static List<PlacementModifier> rareOrePlacement ( int p_195350_, PlacementModifier p_195351_){
            return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
        }
        private static ResourceKey<PlacedFeature> createKey (String name){
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TwindlingTweaks.MOD_ID, name));
        }
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}