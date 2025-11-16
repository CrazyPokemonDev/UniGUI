package de.crazypokemondev.unigui.api;

import net.minecraft.network.FriendlyByteBuf;

public interface EncodableGuiState<TState extends EncodableGuiState<TState>> extends GuiState {
    void encode(FriendlyByteBuf buf);

    TState decode(FriendlyByteBuf buf);
}
