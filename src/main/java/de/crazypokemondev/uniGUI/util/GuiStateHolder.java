package de.crazypokemondev.uniGUI.util;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GuiStateHolder<TState> {
    @Getter
    private final TState state;
    private final List<Runnable> updateHandlers = new ArrayList<>();

    public GuiStateHolder(TState state) {
        this.state = state;
    }

    public void registerUpdateHandler(Runnable updateHandler) {
        updateHandlers.add(updateHandler);
    }

    public void unregisterUpdateHandler(Runnable updateHandler) {
        updateHandlers.remove(updateHandler);
    }

    public void notifyStateChanged() {
        for (Runnable handler : updateHandlers) {
            handler.run();
        }
    }
}
