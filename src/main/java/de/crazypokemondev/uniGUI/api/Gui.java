package de.crazypokemondev.uniGUI.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface Gui {
    /**
     * Should open this GUI for the given player.
     *
     * @param player The player to open the GUI for.
     */
    void open(Player player);

    /**
     * Should close the GUI for the player.
     *
     * @param player The player to close this GUI for.
     */
    void close(Player player);
}
