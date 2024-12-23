package com.bungy.twindlingtweaks;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.entity.ModBlockEntities;
import com.bungy.twindlingtweaks.item.ModCreativeModeTab;
import com.bungy.twindlingtweaks.item.ModItems;
import com.bungy.twindlingtweaks.recipes.ModRecipes;
import com.bungy.twindlingtweaks.screen.CrusherScreen;
import com.bungy.twindlingtweaks.screen.FiltererScreen;
import com.bungy.twindlingtweaks.screen.ModMenuTypes;
import com.bungy.twindlingtweaks.screen.ObsidianForgerScreen;
import com.bungy.twindlingtweaks.sound.ModSounds;
import com.bungy.twindlingtweaks.world.biomemods.ModBiomeModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TwindlingTweaks.MOD_ID)
public class TwindlingTweaks {
    public static final String MOD_ID = "twindlingtweaks";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TwindlingTweaks() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTab.register(eventBus);
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModRecipes.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModBiomeModifiers.register(eventBus);
        ModSounds.register(eventBus);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
    }



    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MUD_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MUD_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBER_SEEDS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LETTUCE_SEEDS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOMATO_SEEDS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATALPA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATALPA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATALPA_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATALPA_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_MAPLE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_MAPLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_MAPLE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_MAPLE_TRAPDOOR.get(), RenderType.cutout());
        MenuScreens.register(ModMenuTypes.OBSIDIAN_FORGER_MENU.get(), ObsidianForgerScreen::new);
        MenuScreens.register(ModMenuTypes.FILTERER_MENU.get(), FiltererScreen::new);
        MenuScreens.register(ModMenuTypes.CRUSHER_MENU.get(), CrusherScreen::new);
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}