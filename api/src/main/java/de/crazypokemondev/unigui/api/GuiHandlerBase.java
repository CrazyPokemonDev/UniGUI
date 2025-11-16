package de.crazypokemondev.unigui.api;

import de.crazypokemondev.unigui.api.error.GuiNotSupportedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The GUI handler service. You don't need to implement this interface, since UniGUI provides this service.
 */
interface GuiHandlerBase<TPlayer, TState extends GuiStateBase, TGui extends GuiBase<TPlayer>> {

    /**
     * Opens the specified GUI for the specified player.
     *
     * @param player The player to open the GUI for
     * @param guiId  The identifier of the GUI to open
     * @param state  The initial state, or <code>null</code> if the GUI is stateless.
     * @return the implementation of the GUI opened for the player
     * @throws GuiNotSupportedException if the player's client does not support any implementation of the specified GUI
     */
    TGui openGui(@NotNull TPlayer player, @NotNull String guiId, @Nullable TState state) throws GuiNotSupportedException;
}
