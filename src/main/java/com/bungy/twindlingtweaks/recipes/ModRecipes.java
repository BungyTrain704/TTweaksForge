package com.bungy.twindlingtweaks.recipes;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.custom.CrusherBlock;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TwindlingTweaks.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ObsidianForgerRecipe>> FORGING_SERIALIZER =
            SERIALIZERS.register("forging", () -> ObsidianForgerRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<FiltererRecipe>> FILTERING_SERIALIZER =
            SERIALIZERS.register("filtering", () -> FiltererRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CrusherRecipe>> CRUSHING_SERIALIZER =
            SERIALIZERS.register("crushing", () -> CrusherRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}