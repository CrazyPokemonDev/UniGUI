package de.crazypokemondev.unigui.network.packets;

import de.crazypokemondev.unigui.api.EncodableGuiState;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.Nullable;

public class OpenGuiPacket extends OpenGuiPayload<EncodableGuiState<?>> implements Packet {
    public OpenGuiPacket(String guiId, @Nullable EncodableGuiState<?> state) {
        super(guiId, state);
    }

    @Override
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(getGuiId());
        if (state != null) {
            state.encode(buffer);
        }
    }

    @Override
    public String getName() {
        return OpenGuiPayload.PACKET_NAME;
    }
}
