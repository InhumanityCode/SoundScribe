package com.inhumanity.soundscribe;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.inhumanity.soundscribe.config.ClientConfig;
import com.inhumanity.soundscribe.listener.ClientChatReceivedListener;
import com.inhumanity.soundscribe.registries.SoundEvents;


@Mod(ModFile.MOD_ID)
@OnlyIn(Dist.CLIENT)
public class ModFile
{
    public static final String MOD_ID = "soundscribe";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public ModFile() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SoundEvents.register(eventBus);
        ModLoadingContext.get().registerConfig(Type.CLIENT, ClientConfig.SPEC, String.format("%s-client.toml", MOD_ID));
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ClientChatReceivedListener());
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
