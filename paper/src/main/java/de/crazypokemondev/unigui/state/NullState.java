package de.crazypokemondev.unigui.state;

import de.crazypokemondev.unigui.api.EncodableGuiState;
import net.minecraft.network.FriendlyByteBuf;

public class NullState implements EncodableGuiState<NullState> {
    @Override
    public void encode(FriendlyByteBuf buf) {

    }

    @Override
    public NullState decode(FriendlyByteBuf buf) {
        return new NullState();
    }
}
