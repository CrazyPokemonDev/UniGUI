package de.crazypokemondev.unigui.api;

/**
 * Represents a GUI instance. Might be a singleton (usually for stateless GUIs) or a unique instance for one player.
 */
interface GuiBase<TPlayer> {
    /**
     * Should open this GUI for the given player.
     *
     * @param player The player to open the GUI for.
     */
    void open(TPlayer player);

    /**
     * Should close the GUI for the player.
     *
     * @param player The player to close this GUI for.
     */
    void close(TPlayer player);
}
