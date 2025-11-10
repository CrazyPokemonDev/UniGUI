package de.crazypokemondev.uniGUI.api;

import de.crazypokemondev.uniGUI.UniGUI;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface GuiState {
    BukkitScheduler scheduler = Bukkit.getScheduler();
    List<Runnable> updateHandlers = new CopyOnWriteArrayList<>();

    default void registerUpdateHandler(Runnable updateHandler) {
        updateHandlers.add(updateHandler);
    }

    default void unregisterUpdateHandler(Runnable updateHandler) {
        updateHandlers.remove(updateHandler);
    }

    default void notifyStateChanged() {
        for (Runnable handler : updateHandlers) {
            scheduler.runTask(UniGUI.INSTANCE, handler);
        }
    }
}
