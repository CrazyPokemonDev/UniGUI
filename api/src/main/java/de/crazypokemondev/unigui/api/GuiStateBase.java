package de.crazypokemondev.unigui.api;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implement this interface on the class representing your GUI state. It provides functionality to notify on changed state,
 * so you only need to register update handlers and call {@link GuiStateBase#notifyStateChanged()} to send a notification
 * to all handlers.
 * For Bukkit or its derivatives it also makes sure the update handlers are being executed on the main thread.
 */
interface GuiStateBase {
    /**
     * A thread-safe list used to keep track of update handlers
     */
    List<Runnable> updateHandlers = new CopyOnWriteArrayList<>();

    /**
     * Registers an update handler to be called every time the state changes.
     *
     * @param updateHandler The method to be called on state change
     */
    default void registerUpdateHandler(Runnable updateHandler) {
        updateHandlers.add(updateHandler);
    }

    /**
     * Unregisters an update handler.
     *
     * @param updateHandler The handler to unregister
     */
    default void unregisterUpdateHandler(Runnable updateHandler) {
        updateHandlers.remove(updateHandler);
    }

    /**
     * Call this method whenever you need to inform all attached GUI instances of an update to the state.
     */
    void notifyStateChanged();
}
