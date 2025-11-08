package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.util.GuiStateHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class VanillaGuiFactoryStateful extends VanillaGuiFactory {
    private final Function<GuiStateHolder<?>, Gui> supplier;

    /**
     * Creates a new factory for a stateless vanilla GUI
     *
     * @param id       The identifier for your specific GUI. Recommended pattern is <code>pluginid:guiname</code>.
     *                 If you have multiple implementations for the same GUI (e.g. one vanilla implementation and one custom
     *                 implementation) they need to share the same identifier. The implementation with the highest priority available
     *                 to the client will be used.
     * @param supplier A supplier method that will return a new instance of the GUI referencing the GuiStateHolder it receives.
     *                 This can be the same state holder for multiple GUI instances.
     */
    public VanillaGuiFactoryStateful(String id, Function<GuiStateHolder<?>, Gui> supplier) {
        super(id);
        this.supplier = supplier;
    }

    @Override
    public @NotNull Gui createGui(@Nullable GuiStateHolder<?> stateHolder) {
        return supplier.apply(stateHolder);
    }
}
