package de.crazypokemondev.unigui.screens;

import de.crazypokemondev.unigui.api.EncodableGuiState;
import de.crazypokemondev.unigui.api.StateDecoder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minecraft.network.FriendlyByteBuf;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TestGuiState implements EncodableGuiState<TestGuiState>, StateDecoder<TestGuiState> {
    private String text;

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(text);
    }

    @Override
    public TestGuiState decode(FriendlyByteBuf buf) {
        return new TestGuiState(buf.readUtf());
    }
}
