package de.crazypokemondev.uniGUI.api;

import de.crazypokemondev.uniGUI.util.GuiStateHolder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface GuiFactory extends Comparable<GuiFactory> {
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
     * Should return an instance of your GUI for the given player and state.
     * Depending on your implementation, this might be the same instance for each player or a new instance each time.
     *
     * @param player      The player to create the GUI instance for.
     * @param stateHolder The state holder, or <code>null</code> if the GUI is stateless.
     * @return a Gui instance
     */
    @NotNull
    Gui createGui(Player player, @Nullable GuiStateHolder<?> stateHolder);

    @Override
    default int compareTo(@NotNull GuiFactory o) {
        return o.getPriority() - this.getPriority();
    }
}
