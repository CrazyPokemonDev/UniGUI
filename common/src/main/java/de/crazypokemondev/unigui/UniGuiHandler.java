package de.crazypokemondev.unigui;

import de.crazypokemondev.unigui.api.*;
import de.crazypokemondev.unigui.api.error.GuiNotSupportedException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UniGuiHandler implements GuiHandler {
    public static final UniGuiHandler INSTANCE = new UniGuiHandler(UniGuiRegistry.INSTANCE);

    private final GuiRegistry registry;

    @Override
    public Gui openGui(@NotNull ServerPlayer player, @NotNull String guiId, @Nullable GuiState state) throws GuiNotSupportedException {
        Optional<GuiFactory> optional = registry.getGui(guiId, player);
        GuiFactory factory = optional.orElseThrow(() -> new GuiNotSupportedException(player.getUUID(), guiId));
        Gui gui = factory.createGui(player, state);
        gui.open(player);
        return gui;
    }
}
