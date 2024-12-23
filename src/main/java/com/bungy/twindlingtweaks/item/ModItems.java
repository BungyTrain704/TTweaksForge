package com.bungy.twindlingtweaks.item;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.item.custom.ModArmorItem;
import com.bungy.twindlingtweaks.item.custom.ModArmorItem2;
import com.bungy.twindlingtweaks.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TwindlingTweaks.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> MUD_BALL = ITEMS.register("mud_ball",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_MUD_BALL = ITEMS.register("dried_mud_ball",
            () -> new Item(new Item.Properties().food(ModFoods.DRIED_MUD_BALL)));

    public static final RegistryObject<Item> UNPROCESSED_LUMINIUM_CHUNK = ITEMS.register("unprocessed_luminium_chunk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUMINIUM_CHUNK = ITEMS.register("luminium_chunk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_LUMINIUM = ITEMS.register("raw_luminium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUMINIUM_GEM = ITEMS.register("luminium_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUMINIUM_APPLE = ITEMS.register("luminium_apple",
        () -> new EnchantedGoldenAppleItem(new Item.Properties().food(ModFoods.LUMINIUM_APPLE)));

    public static final RegistryObject<Item> RAW_ALLUMINITE = ITEMS.register("raw_alluminite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALLUMINITE_INGOT = ITEMS.register("alluminite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALLUMINITE_NUGGET = ITEMS.register("alluminite_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REINFORCED_ALLUMINITE_INGOT = ITEMS.register("reinforced_alluminite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALLUMINITE_SWORD = ITEMS.register("alluminite_sword",
            () -> new SwordItem(ModTiers.ALLUMINITE,  7, -2.2F,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_AXE = ITEMS.register("alluminite_axe",
            () -> new AxeItem(ModTiers.ALLUMINITE,  10, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_PICKAXE = ITEMS.register("alluminite_pickaxe",
            () -> new PickaxeItem(ModTiers.ALLUMINITE,  1, -1.9F,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_SHOVEL = ITEMS.register("alluminite_shovel",
            () -> new ShovelItem(ModTiers.ALLUMINITE,  2, -1.9F,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_HOE = ITEMS.register("alluminite_hoe",
            () -> new HoeItem(ModTiers.ALLUMINITE,  2, 1.9F,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALLUMINITE_HELMET = ITEMS.register("alluminite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ALLUMINITE, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_CHESTPLATE = ITEMS.register("alluminite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ALLUMINITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_LEGGINGS = ITEMS.register("alluminite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ALLUMINITE, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLUMINITE_BOOTS = ITEMS.register("alluminite_boots",
            () -> new ArmorItem(ModArmorMaterials.ALLUMINITE, ArmorItem.Type.BOOTS,
                    new Item.Properties()));



    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ModArmorItem2(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS,
                    new Item.Properties()));







    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword",
            () -> new SwordItem(ModTiers.OBSIDIAN,  9, -2.9F,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe",
            () -> new AxeItem(ModTiers.OBSIDIAN,  16, -3.4F,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe",
            () -> new PickaxeItem(ModTiers.OBSIDIAN,  1, -1.9F,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel",
            () -> new ShovelItem(ModTiers.OBSIDIAN,  2, -1.9F,
                    new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe",
            () -> new HoeItem(ModTiers.OBSIDIAN,  2, 1.9F,
                    new Item.Properties()));


    public static final RegistryObject<Item> ALLUMINITE_ROD = ITEMS.register("alluminite_rod",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALLUMINITE_ROD_SHARD = ITEMS.register("alluminite_rod_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNFILTERED_SUGAR = ITEMS.register("unfiltered_sugar",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ORANGE_SEED_POWDER = ITEMS.register("orange_seed_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ORANGE_SEED_MILK = ITEMS.register("orange_seed_milk_bucket",
            () -> new ModMilkBucketItem(new Item.Properties()));

    public static final RegistryObject<Item> SALAD_TOPPINGS = ITEMS.register("salad_toppings",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RANCH_BOTTLE = ITEMS.register("ranch_bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new AxeItem(Tiers.STONE, 7.0F, -3.6F, new Item.Properties()));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> CROUTON = ITEMS.register("crouton",
            () -> new Item(new Item.Properties().food(ModFoods.CROUTON)));

    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item(new Item.Properties().food(ModFoods.LETTUCE)));

    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoods.ORANGE)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));

    public static final RegistryObject<Item> SALAD = ITEMS.register("salad",
            () -> new Item(new Item.Properties().food(ModFoods.SALAD)));

    //public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
         //   () -> new Item(new Item.Properties().food(ModFoods.BANANA)));


    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LETTUCE_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> ORANGE_SEEDS = ITEMS.register("orange_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ORANGE_SEEDS_BLOCK.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_SEEDS_BLOCK.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> MYSTICAL_MUSIC_DISC = ITEMS.register("mystical_cd",
            () -> new RecordItem(6, ModSounds.MYSTICAL, new Item.Properties().stacksTo(1), 5880));

    }
