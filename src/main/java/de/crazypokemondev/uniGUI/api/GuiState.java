package de.crazypokemondev.uniGUI.api;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface GuiState {
    List<Runnable> updateHandlers = new CopyOnWriteArrayList<>();

    default void registerUpdateHandler(Runnable updateHandler) {
        updateHandlers.add(updateHandler);
    }

    default void unregisterUpdateHandler(Runnable updateHandler) {
        updateHandlers.remove(updateHandler);
    }

    default void notifyStateChanged() {
        for (Runnable handler : updateHandlers) {
            handler.run();
        }
    }
}
