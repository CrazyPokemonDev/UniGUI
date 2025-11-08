package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.UniGuiFactory;
import de.crazypokemondev.uniGUI.api.Gui;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class VanillaGuiFactory<TGui extends Gui> extends UniGuiFactory {
    private final String id;
    private final Supplier<TGui> supplier;

    public VanillaGuiFactory(String id, Supplier<TGui> supplier) {
        this.id = id;
        this.supplier = supplier;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean isSupportedByPlayer(Player player) {
        return true;
    }

    @Override
    public @NotNull Gui createGui() {
        return supplier.get();
    }
}
