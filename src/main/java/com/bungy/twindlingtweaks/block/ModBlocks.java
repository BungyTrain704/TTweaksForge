package com.bungy.twindlingtweaks.block;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.custom.*;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.world.feature.tree.CatalpaTreeGrower;
import com.bungy.twindlingtweaks.world.feature.tree.RedMapleTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TwindlingTweaks.MOD_ID);

    public static final RegistryObject<Block> MUD_BLOCK = registerBlock("mud_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).strength(0.5F)));

    public static final RegistryObject<Block> DRIED_MUD_BLOCK = registerBlock("dried_mud_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD).strength(1F)));

    public static final RegistryObject<Block> MUD_DOOR = registerBlock("mud_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion().strength(1F), BlockSetType.OAK));

    public static final RegistryObject<Block> MUD_TRAPDOOR = registerBlock("mud_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(0.8F).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> RED_MAPLE_LOG = registerFuelBlock("red_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(1F)));
    public static final RegistryObject<Block> RED_MAPLE_WOOD = registerFuelBlock("red_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(1F)));
    public static final RegistryObject<Block> STRIPPED_RED_MAPLE_LOG = registerFuelBlock("stripped_red_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(1F)));
    public static final RegistryObject<Block> STRIPPED_RED_MAPLE_WOOD = registerFuelBlock("stripped_red_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(1F)));
    public static final RegistryObject<Block> RED_MAPLE_PLANKS = registerFuelBlock("red_maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1F)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> RED_MAPLE_SAPLING = registerFuelBlock("red_maple_sapling",
            () -> new SaplingBlock(new RedMapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> RED_MAPLE_DOOR = registerFuelBlock("red_maple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).strength(1F).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> RED_MAPLE_TRAPDOOR = registerFuelBlock("red_maple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(1F).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> RED_MAPLE_STAiRS = registerFuelBlock("red_maple_stairs",
            () -> new StairBlock(() -> ModBlocks.RED_MAPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    .strength(1F)));
    public static final RegistryObject<Block> RED_MAPLE_SLAB = registerFuelBlock("red_maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .strength(1F)));
    public static final RegistryObject<Block> RED_MAPLE_FENCE = registerFuelBlock("red_maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .strength(1F)));
    public static final RegistryObject<Block> RED_MAPLE_FENCE_GATE = registerFuelBlock("red_maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(1F), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));
    public static final RegistryObject<Block> RED_MAPLE_BUTTON = registerFuelBlock("red_maple_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).strength(1F).noCollission(), BlockSetType.OAK,30, true));
    public static final RegistryObject<Block> RED_MAPLE_PRESSURE_PLATE = registerFuelBlock("red_maple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(1F), BlockSetType.OAK));



    public static final RegistryObject<Block> CATALPA_STAiRS = registerFuelBlock("catalpa_stairs",
            () -> new StairBlock(() -> ModBlocks.CATALPA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    .strength(1F)));
    public static final RegistryObject<Block> CATALPA_SLAB = registerFuelBlock("catalpa_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .strength(1F)));
    public static final RegistryObject<Block> CATALPA_FENCE = registerFuelBlock("catalpa_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .strength(1F)));
    public static final RegistryObject<Block> CATALPA_FENCE_GATE = registerFuelBlock("catalpa_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(1F), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN));

    public static final RegistryObject<Block> CATALPA_DOOR = registerFuelBlock("catalpa_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).strength(1F).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> CATALPA_TRAPDOOR = registerFuelBlock("catalpa_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(1F).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> CATALPA_BUTTON = registerFuelBlock("catalpa_button", () ->
            new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).strength(1F).noCollission(), BlockSetType.OAK,30, true));
    public static final RegistryObject<Block> CATALPA_PRESSURE_PLATE = registerFuelBlock("catalpa_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(1F), BlockSetType.OAK));


    public static final RegistryObject<Block> CATALPA_LOG = registerFuelBlock("catalpa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(1F)));
    public static final RegistryObject<Block> CATALPA_WOOD = registerFuelBlock("catalpa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(1F)));
    public static final RegistryObject<Block> STRIPPED_CATALPA_LOG = registerFuelBlock("stripped_catalpa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(1F)));
    public static final RegistryObject<Block> STRIPPED_CATALPA_WOOD = registerFuelBlock("stripped_catalpa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(1F)));
    public static final RegistryObject<Block> CATALPA_PLANKS = registerFuelBlock("catalpa_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1F)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });



    public static final RegistryObject<Block> CATALPA_LEAVES = registerBlock("catalpa_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> CATALPA_SAPLING = registerFuelBlock("catalpa_sapling",
            () -> new SaplingBlock(new CatalpaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).strength(12F).explosionResistance(1200F).sound(SoundType.ANVIL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OBSIDIAN_FORGER = registerBlock("obsidian_forger",
            () -> new ObsidianForgerBlock(BlockBehaviour.Properties.copy(ModBlocks.REINFORCED_OBSIDIAN.get()).strength(12F).explosionResistance(1200F).sound(SoundType.ANVIL)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CRUSHER = registerBlock("crusher",
            () -> new CrusherBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.LODESTONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FILTERER = registerBlock("filterer",
            () -> new FiltererBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(4F).explosionResistance(6.8F).sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> UNFILTERED_SUGAR_BLOCK = registerBlock("unfiltered_sugar_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(0.5F)));

    public static final RegistryObject<Block> SUGAR_BLOCK = registerBlock("sugar_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).strength(0.4F)));

    public static final RegistryObject<Block> ALLUMINITE_BLOCK = registerBlock("alluminite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).strength(2F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_ALLUMINITE_BLOCK = registerBlock("raw_alluminite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).strength(2F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MUD_ORE = registerBlock("mud_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_MUD_ORE = registerBlock("deepslate_mud_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SUGAR_ORE = registerBlock("sugar_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.9F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_SUGAR_ORE = registerBlock("deepslate_sugar_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.1F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALLUMINITE_ORE = registerBlock("alluminite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.6F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_ALLUMINITE_ORE = registerBlock("deepslate_alluminite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.4F).sound(SoundType.BASALT)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LUMINIUM_ORE = registerBlock("luminium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE).strength(2.3F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_LUMINIUM_ORE = registerBlock("deepslate_luminium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_REDSTONE_ORE).strength(3.1F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LUMINIUM_BLOCK = registerBlock("luminium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).strength(6F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_LUMINIUM_BLOCK = registerBlock("raw_luminium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).strength(5F).sound(SoundType.BONE_BLOCK)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CUCUMBER_SEEDS_BLOCK = registerBlockWithoutBlockItem("cucumber_seeds",
            () -> new CucumberPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> LETTUCE_SEEDS_BLOCK = registerBlockWithoutBlockItem("lettuce_seeds",
            () -> new LettucePlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> ORANGE_SEEDS_BLOCK = registerBlockWithoutBlockItem("orange_seeds",
            () -> new OrangePlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> TOMATO_SEEDS_BLOCK = registerBlockWithoutBlockItem("tomato_seeds",
            () -> new TomatoPlantBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()->new ModFuelBlockItem(block.get(),new Item.Properties(),350));
    }
    private static <T extends Block> RegistryObject<T> registerFuelBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFuelBlockItem(name, toReturn);
        return toReturn;
    }



    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}