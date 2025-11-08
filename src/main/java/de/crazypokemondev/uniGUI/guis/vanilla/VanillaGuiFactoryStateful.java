package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.util.GuiStateHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class VanillaGuiFactoryStateful extends VanillaGuiFactory {
    private final Function<GuiStateHolder<?>, Gui> supplier;

    public VanillaGuiFactoryStateful(String id, Function<GuiStateHolder<?>, Gui> supplier) {
        super(id);
        this.supplier = supplier;
    }

    @Override
    public @NotNull Gui createGui(@Nullable GuiStateHolder<?> stateHolder) {
        if (stateHolder == null) {
            throw new RuntimeException("Tried to create a stateful GUI without a state!");
        }
        return supplier.apply(stateHolder);
    }
}
