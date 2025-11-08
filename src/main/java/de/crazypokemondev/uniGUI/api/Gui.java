package de.crazypokemondev.uniGUI.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface Gui extends Comparable<Gui> {
    /**
     * Should return an identifier for your specific GUI. Recommended pattern is <code>pluginid:guiname</code>.
     * If you have multiple implementations for the same GUI (e.g. one vanilla implementation and one custom
     * implementation) they need to share the same identifier. The implementation with the highest priority available
     * to the client will be used.
     *
     * @return a unique identifier for this GUI.
     */
    String getId();

    /**
     * Should return the priority for this implementation of your GUI. For vanilla implementations, this is usually 0.
     * The implementation with the highest priority available to the client will be used.
     *
     * @return the priority of this GUI implementation
     */
    int getPriority();

    /**
     * Returns true if this GUI implementation is supported by the provided player's client.
     * For vanilla implementations, this should always return true.
     *
     * @param player The player to check GUI support for
     * @return true if the player's client supports this GUI implementation
     */
    boolean isSupportedByPlayer(Player player);

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

    @Override
    default int compareTo(@NotNull Gui o) {
        return o.getPriority() - this.getPriority();
    }
}
