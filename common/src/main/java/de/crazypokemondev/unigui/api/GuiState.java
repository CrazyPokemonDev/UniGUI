package de.crazypokemondev.unigui.api;

/**
 * @see de.crazypokemondev.unigui.api.GuiStateBase
 */
public interface GuiState extends GuiStateBase {

    /**
     * {@inheritDoc}
     */
    default void notifyStateChanged() {
        for (Runnable handler : updateHandlers) {
            handler.run();
        }
    }
}
