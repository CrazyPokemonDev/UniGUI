package de.crazypokemondev.unigui.guis.vanilla;

import de.crazypokemondev.unigui.api.GuiFactory;
import org.bukkit.entity.Player;

public abstract class VanillaGuiFactory implements GuiFactory {
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
