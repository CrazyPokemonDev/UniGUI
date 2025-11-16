package de.crazypokemondev.unigui.api;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

/**
 * The GUI registry service. You don't need to implement this interface, since UniGUI provides this service.
 */
interface GuiRegistryBase<TPlayer, TState extends GuiStateBase, TGui extends GuiBase<TPlayer>, TFactory extends GuiFactoryBase<TPlayer, TState, TGui>> {
    /**
     * Registers a GUI factory for usage by the UniGUI lib.
     *
     * @param gui The GUI factory to register
     */
    void register(@NotNull TFactory gui);

    /**
     * Unregisters a GUI factory for usage by the UniGUI lib.
     *
     * @param gui The GUI factory to unregister
     * @return true if the GUI was previously registered.
     */
    boolean unregister(@NotNull TFactory gui);

    /**
     * Returns the GUI factory with the highest priority supported by the specified player.
     *
     * @param guiId  The GUI identifier for the requested type of GUI
     * @param player The player that should have support for the given GUI.
     * @return An Optional of the GUI implementation with the highest priority supported, if any.
     */
    Optional<TFactory> getGui(@NotNull String guiId, @NotNull TPlayer player);

    /**
     * Returns a list of all implementations supported for this GUI id.
     *
     * @param guiId The identifier of the GUI requested.
     * @return A list of all registered implementations for this GUI identifier.
     */
    List<TFactory> getAllGuis(@NotNull String guiId);
}
