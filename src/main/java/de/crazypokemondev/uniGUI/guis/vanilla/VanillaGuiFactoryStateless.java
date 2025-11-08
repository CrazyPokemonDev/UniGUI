package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.util.GuiStateHolder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VanillaGuiFactoryStateless extends VanillaGuiFactory {
    private final Supplier<Gui> supplier;

    public VanillaGuiFactoryStateless(String id, Supplier<Gui> supplier) {
        super(id);
        this.supplier = supplier;
    }

    @Override
    public @NotNull Gui createGui(GuiStateHolder<?> stateHolder) {
        return supplier.get();
    }
}
