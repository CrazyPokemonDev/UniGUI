package de.crazypokemondev.uniGUI.api;

import de.crazypokemondev.uniGUI.api.error.GuiNotSupportedException;
import de.crazypokemondev.uniGUI.util.GuiStateHolder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface GuiHandler {

    /**
     * Opens the specified GUI for the specified player.
     *
     * @param player      The player to open the GUI for
     * @param guiId       The identifier of the GUI to open
     * @param stateHolder A state holder, or <code>null</code> if the GUI is stateless.
     * @return the implementation of the GUI opened for the player
     * @throws GuiNotSupportedException if the player's client does not support any implementation of the specified GUI
     */
    Gui openGui(@NotNull Player player, @NotNull String guiId, @NotNull GuiStateHolder<?> stateHolder) throws GuiNotSupportedException;
}
