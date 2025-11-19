package de.crazypokemondev.unigui.guis.vanilla;

import de.crazypokemondev.unigui.api.Gui;
import de.crazypokemondev.unigui.api.GuiState;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class VanillaGuiFactoryStateful extends VanillaGuiFactory {
    private final BiFunction<Player, GuiState, Gui> supplier;

    /**
     * Creates a new factory for a stateless vanilla GUI
     *
     * @param id       The identifier for your specific GUI. Recommended pattern is <code>pluginid:guiname</code>.
     *                 If you have multiple implementations for the same GUI (e.g. one vanilla implementation and one custom
     *                 implementation) they need to share the same identifier. The implementation with the highest priority available
     *                 to the client will be used.
     * @param supplier A supplier method that will return a new instance of the GUI for the given player,
     *                 referencing the GuiState it receives.
     *                 This can be the same state holder for multiple GUI instances.
     */
    public VanillaGuiFactoryStateful(String id, BiFunction<Player, GuiState, Gui> supplier) {
        super(id);
        this.supplier = supplier;
    }

    @Override
    public @NotNull Gui createGui(Player player, @Nullable GuiState state) {
        return supplier.apply(player, state);
    }
}
