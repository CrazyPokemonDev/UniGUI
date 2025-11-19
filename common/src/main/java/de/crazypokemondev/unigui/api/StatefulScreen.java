package de.crazypokemondev.unigui.api;

import org.jetbrains.annotations.NotNull;

public interface StatefulScreen<T extends EncodableGuiState<T>> {
    void updateState(T state);

    @NotNull
    Class<T> stateType();
}
