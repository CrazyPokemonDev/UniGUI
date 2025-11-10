package de.crazypokemondev.uniGUI.api;

import java.util.ArrayList;
import java.util.List;

public interface GuiState {
    List<Runnable> updateHandlers = new ArrayList<>();

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
