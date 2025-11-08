package de.crazypokemondev.uniGUI.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface GuiRegistry {
    /**
     * Registers a GUI for usage by the UniGUI lib.
     *
     * @param gui The GUI to register
     */
    void register(@NotNull Gui gui);

    /**
     * Unregisters a GUI for usage by the UniGUI lib.
     *
     * @param gui The GUI to unregister
     * @return true if the GUI was previously registered.
     */
    boolean unregister(@NotNull Gui gui);

    /**
     * Returns the GUI with the highest priority supported by the specified player.
     *
     * @param guiId  The GUI identifier for the requested type of GUI
     * @param player The player that should have support for the given GUI.
     * @return An Optional of the GUI implementation with the highest priority supported, if any.
     */
    Optional<Gui> getGui(@NotNull String guiId, @NotNull Player player);

    /**
     * Returns a list of all implementations supported for this GUI id.
     *
     * @param guiId The identifier of the GUI requested.
     * @return A list of all registered implementations for this GUI identifier.
     */
    List<Gui> getAllGuis(@NotNull String guiId);
}
