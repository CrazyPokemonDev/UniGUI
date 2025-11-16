package de.crazypokemondev.unigui.network.packets;

import net.minecraft.network.FriendlyByteBuf;

public interface Packet {
    void encode(FriendlyByteBuf buffer);

    String getName();
}
