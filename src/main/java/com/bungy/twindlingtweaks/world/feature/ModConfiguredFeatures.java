package com.bungy.twindlingtweaks.world.feature;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_KEY = registerKey("red_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_SPAWN_KEY = registerKey("red_maple_spawn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CATALPA_KEY = registerKey("catalpa");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CATALPA_SPAWN_KEY = registerKey("catalpa_spawn");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LUMINIUM_ORE_KEY = registerKey("overworld_luminium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ALLUMINITE_ORE_KEY = registerKey("overworld_alluminite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RAW_ALLUMINITE_BLOCK_KEY = registerKey("overworld_raw_alluminite_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MUD_ORE_KEY = registerKey("overworld_mud_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SUGAR_ORE_KEY = registerKey("overworld_sugar_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, RED_MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.RED_MAPLE_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(ModBlocks.RED_MAPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());


        register(context, CATALPA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CATALPA_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(ModBlocks.CATALPA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());


        register(context, OVERWORLD_LUMINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_LUMINIUM_ORES.get(), 7));
        register(context, OVERWORLD_ALLUMINITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_ALLUMINITE_ORES.get(), 14));
        register(context, OVERWORLD_RAW_ALLUMINITE_BLOCK_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_RAW_ALLUMINITE_BLOCKS.get(), 3));
        register(context, OVERWORLD_MUD_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_MUD_ORES.get(), 16));
        register(context, OVERWORLD_SUGAR_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_SUGAR_ORES.get(), 15));
    }

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_LUMINIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.LUMINIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_LUMINIUM_ORE.get().defaultBlockState())));

        public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ALLUMINITE_ORES = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.ALLUMINITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get().defaultBlockState())));

        public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RAW_ALLUMINITE_BLOCKS = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.RAW_ALLUMINITE_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.RAW_ALLUMINITE_BLOCK.get().defaultBlockState())));

        public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MUD_ORES = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.MUD_ORE.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_MUD_ORE.get().defaultBlockState())));

        public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SUGAR_ORES = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.SUGAR_ORE.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SUGAR_ORE.get().defaultBlockState())));



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TwindlingTweaks.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

