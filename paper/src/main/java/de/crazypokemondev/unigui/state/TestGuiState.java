package de.crazypokemondev.unigui.state;

import de.crazypokemondev.unigui.api.EncodableGuiState;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.FriendlyByteBuf;

@Getter
@Setter
public class TestGuiState implements EncodableGuiState<TestGuiState> {
    private String text;

    public TestGuiState(String text) {
        this.text = text;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(text);
    }

    @Override
    public TestGuiState decode(FriendlyByteBuf buf) {
        return new TestGuiState(buf.readUtf());
    }
}
