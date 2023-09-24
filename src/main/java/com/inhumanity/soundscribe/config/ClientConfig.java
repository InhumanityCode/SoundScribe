package com.inhumanity.soundscribe.config;

import java.util.ArrayList;
import java.util.List;

import com.inhumanity.soundscribe.config.ClientConfigUtil.Category;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ClientConfig {
    public static final Builder BUILDER = new Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ConfigValue<List<? extends String>> searchTerms;
    public static final ConfigValue<String> pingSound;
    public static final ConfigValue<Category> pingCategory;
    public static final ConfigValue<Double> pingVolume;
    public static final ConfigValue<Double> pingPitch;

    static {
        BUILDER.push("Configs for SoundScribe");

        searchTerms = BUILDER
            .comment("List of Terms to Search the Chat For")
            .defineList("searchTerms", new ArrayList<>(), (it) -> { return it instanceof String; });
        
        pingSound = BUILDER
            .comment("Sound to Use")
            .comment("Can be any registered sound from any Mod that is present")
            .defineInList("pingSound", "soundscribe:ping", ClientConfigUtil.allSound);
        
        pingVolume = BUILDER
            .comment("How Loud the Ping is")
            .defineInRange("pingVolume", 0.5f, 0.0f, 1f);
        
        pingPitch = BUILDER
            .comment("How High the Pitch of the Ping is")
            .defineInRange("pingPitch", 0.5f, 0.0f, 1f);
        
        pingCategory = BUILDER
            .comment("Sound Category the Ping Plays in")
            .defineEnum("soundCategory", Category.master);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
