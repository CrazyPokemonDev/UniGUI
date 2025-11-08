package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.UniGuiFactory;
import de.crazypokemondev.uniGUI.api.Gui;
import org.bukkit.entity.Player;

public abstract class VanillaGuiFactory extends UniGuiFactory {
    private final String id;

    public VanillaGuiFactory(String id) {
        this.id = id;
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
}
