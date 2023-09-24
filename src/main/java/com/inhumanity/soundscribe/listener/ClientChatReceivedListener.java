package com.inhumanity.soundscribe.listener;

import java.util.List;

import com.inhumanity.soundscribe.config.ClientConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ClientChatReceivedListener {
    @SubscribeEvent
    public void chatMessage(ClientChatReceivedEvent event) {
        final Minecraft MC = Minecraft.getInstance();           // Minecraft Instance
        final ClientPlayerEntity CLIENT_PLAYER = MC.player;     // Client Player

        final List<? extends String> TERMS = ClientConfig.searchTerms.get();      // Search Terms defined in Configs

        if (MC != null && CLIENT_PLAYER != null &&                  // Client and Client Player exist
            !TERMS.isEmpty() &&                                     // List of Search Terms is not empty
            event.getSenderUUID() != CLIENT_PLAYER.getUniqueID()    // Message Sender was not the Client Player
        ) {
            // Convert message and client player name to lowercase
            final String MSG = event.getMessage().getString().toLowerCase();
            final String CP_NAME = CLIENT_PLAYER.getDisplayName().getString().toLowerCase();

            // For each search term
            for (String term : TERMS) {
                // Do Term Substitutions
                term = term.replace("%playername%", CP_NAME);

                // Split term into subterms if possible (using +)
                String[] subterms = term.split("\\+");

                // Count number of subterms found in message
                int count = 0;
                for (String subterm : subterms) {
                    if (MSG.contains(subterm)) count++;    // Increment count if found
                }

                // If every subterm found
                if (count == subterms.length) {
                    // Get sound to play from Config
                    String[] strRL = ClientConfig.pingSound.get().split(":");
                    String rlNamespace = strRL[0];
                    String rlPath = strRL[1];

                    // Create new Sound using sound name, and play it
                    SimpleSound sound = new SimpleSound(
                        new SoundEvent(new ResourceLocation(rlNamespace, rlPath)),      // Sound Event
                        ClientConfig.pingCategory.get().getSoundCategory(),           // Sound Category
                        ClientConfig.pingVolume.get().floatValue(),                   // Sound Volume
                        ClientConfig.pingVolume.get().floatValue(),                   // Sound Pitch
                        CLIENT_PLAYER.getPosition()                                     // BlockPosition to play at
                    );
                    MC.getSoundHandler().play(sound);
                }
            }
        }
    }
}
