package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.util.GuiStateHolder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VanillaGuiFactoryStateless extends VanillaGuiFactory {
    private final Gui gui;

    /**
     * Creates a new factory for a stateless vanilla GUI
     *
     * @param id  The identifier for your specific GUI. Recommended pattern is <code>pluginid:guiname</code>.
     *            If you have multiple implementations for the same GUI (e.g. one vanilla implementation and one custom
     *            implementation) they need to share the same identifier. The implementation with the highest priority available
     *            to the client will be used.
     * @param gui The Gui instance to return. Since this GUI is stateless, the same instance can be returned for every player.
     */
    public VanillaGuiFactoryStateless(String id, Gui gui) {
        super(id);
        this.gui = gui;
    }

    @Override
    public @NotNull Gui createGui(GuiStateHolder<?> stateHolder) {
        return gui;
    }
}
