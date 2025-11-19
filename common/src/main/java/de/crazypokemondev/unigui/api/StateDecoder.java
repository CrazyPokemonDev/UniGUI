package de.crazypokemondev.unigui.api;

import net.minecraft.network.FriendlyByteBuf;

@FunctionalInterface
public interface StateDecoder<T extends EncodableGuiState<T>> {
    EncodableGuiState<T> decode(FriendlyByteBuf buf);
}
