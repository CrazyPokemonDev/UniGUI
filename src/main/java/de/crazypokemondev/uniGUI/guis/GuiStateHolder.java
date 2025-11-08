package de.crazypokemondev.uniGUI.guis;

import java.util.ArrayList;
import java.util.List;

public abstract class GuiStateHolder {
    protected final List<Runnable> changeEventHandlers = new ArrayList<>();

    /**
     * Registers an event handler to always be called when this state has changed.
     *
     * @param changeEventHandler The method that will be called on state change
     */
    public void registerChangeEventHandler(Runnable changeEventHandler) {
        changeEventHandlers.add(changeEventHandler);
    }

    /**
     * Unregisters an event handler.
     *
     * @param changeEventHandler The method that will be unregistered.
     * @return <code>true</code> if the event handler was present before this operation
     */
    public boolean unregisterChangeEventHandler(Runnable changeEventHandler) {
        return changeEventHandlers.remove(changeEventHandler);
    }

    /**
     * Notifies all registered event handlers that the state has changed.
     */
    protected void notifyStateChanged() {
        for (Runnable handler : changeEventHandlers) {
            handler.run();
        }
    }
}
