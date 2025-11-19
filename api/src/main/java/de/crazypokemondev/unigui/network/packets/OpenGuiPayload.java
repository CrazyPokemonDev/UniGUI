package de.crazypokemondev.unigui.network.packets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class OpenGuiPayload<TState> {
    public static final String PACKET_NAME = "open_gui";
    protected String guiId;
    @Nullable
    protected TState state;
}
