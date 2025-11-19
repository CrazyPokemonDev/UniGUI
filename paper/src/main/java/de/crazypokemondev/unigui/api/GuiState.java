package de.crazypokemondev.unigui.api;

import de.crazypokemondev.unigui.UniGuiPaper;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * @see de.crazypokemondev.unigui.api.GuiStateBase
 */
public interface GuiState extends GuiStateBase {
    /**
     * The scheduler instance used to ensure that all update handlers are being run on the main thread
     */
    BukkitScheduler scheduler = Bukkit.getScheduler();

    /**
     * {@inheritDoc}
     */
    default void notifyStateChanged() {
        for (Runnable handler : updateHandlers) {
            scheduler.runTask(UniGuiPaper.INSTANCE, handler);
        }
    }
}
