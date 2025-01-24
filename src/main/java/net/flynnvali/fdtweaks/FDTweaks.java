package net.flynnvali.fdtweaks;

import com.mojang.logging.LogUtils;

import com.petrolpark.destroy.chemistry.legacy.index.*;


import net.flynnvali.fdtweaks.chemistry.legacy.index.FDTweaksMolecules;
import net.flynnvali.fdtweaks.item.FDTweaksItems;
import net.flynnvali.fdtweaks.chemistry.legacy.index.FDTweaksGenericReaction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTabs;

import net.flynnvali.fdtweaks.chemistry.legacy.index.FDTweaksReactions;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FDTweaks.MOD_ID)
public class FDTweaks {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "fdtweaks";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    };



    public FDTweaks(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        FDTweaksItems.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(FDTweaks::init);
        modEventBus.addListener(this::addCreative);

        // Register the item to a creative tab


    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(FDTweaksItems.POTATO_STARCH);
            event.accept(FDTweaksItems.MYSTIC_ELECTRIC_SOURCE);
            event.accept(FDTweaksItems.SILVER_POWDER);

        }
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
          DestroyGroupFinder.register();
            DestroyTopologies.register();
            DestroyReactions.register();
            DestroyGenericReactions.register();
            DestroyReactions.register();
            FDTweaksReactions.register();
            FDTweaksMolecules.register();
            FDTweaksGenericReaction.register();

        });


    }
}
