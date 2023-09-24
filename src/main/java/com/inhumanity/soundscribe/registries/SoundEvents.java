package com.inhumanity.soundscribe.registries;

import com.inhumanity.soundscribe.ModFile;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = 
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ModFile.MOD_ID);

    // Registered Sound Events
    public static final RegistryObject<SoundEvent> PING = registerSoundEvent("ping");

    // Register sound events
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(ModFile.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
