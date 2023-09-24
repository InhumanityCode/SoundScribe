package com.inhumanity.soundscribe.config;

import java.util.HashSet;

import com.inhumanity.soundscribe.ModFile;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

import net.minecraftforge.registries.ForgeRegistries;

public class ClientConfigUtil {
    //// SOUNDS
    // List of my mods's sounds
    private static final String[] mySounds = new String[] {
        "ping",
    };
    // List of all MC sounds (vanilla + modded)
    public static final HashSet<String> allSound = new HashSet<String>() {{
        // Add all of my sounds
        for (String sound : mySounds) {
            add(ModFile.MOD_ID + ":" + sound);
        }
        // Add every sound registered in MC and Forge
        for (ResourceLocation RL : ForgeRegistries.SOUND_EVENTS.getKeys()) {
            add(RL.getNamespace() + ":" + RL.getPath().toLowerCase());
        }
    }};


    //// SOUND CATEGORIES
    // Enum for all of the possible SoundCategories in MC
    public static enum Category {
        master(SoundCategory.MASTER),
        music(SoundCategory.MUSIC),
        record(SoundCategory.RECORDS),
        weather(SoundCategory.WEATHER),
        hostile(SoundCategory.HOSTILE),
        neutral(SoundCategory.NEUTRAL),
        player(SoundCategory.PLAYERS),
        block(SoundCategory.BLOCKS),
        ambient(SoundCategory.AMBIENT),
        voice(SoundCategory.VOICE);

        private SoundCategory sound;

        private Category(SoundCategory soundCategory) {
            this.sound = soundCategory;
        }

        public SoundCategory getSoundCategory() {
            return sound;
        }
    }
}
