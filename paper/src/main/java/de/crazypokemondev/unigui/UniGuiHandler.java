package de.crazypokemondev.unigui;

import de.crazypokemondev.unigui.api.Gui;
import de.crazypokemondev.unigui.api.GuiFactory;
import de.crazypokemondev.unigui.api.GuiHandler;
import de.crazypokemondev.unigui.api.GuiRegistry;
import de.crazypokemondev.unigui.api.GuiState;
import de.crazypokemondev.unigui.api.error.GuiNotSupportedException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UniGuiHandler implements GuiHandler {
    public static final UniGuiHandler INSTANCE = new UniGuiHandler(UniGuiRegistry.INSTANCE);

    private final GuiRegistry registry;

    @Override
    public Gui openGui(@NotNull Player player, @NotNull String guiId, @Nullable GuiState state) throws GuiNotSupportedException {
        Optional<GuiFactory> optional = registry.getGui(guiId, player);
        GuiFactory factory = optional.orElseThrow(() -> new GuiNotSupportedException(player.getUniqueId(), guiId));
        Gui gui = factory.createGui(player, state);
        gui.open(player);
        return gui;
    }
}
