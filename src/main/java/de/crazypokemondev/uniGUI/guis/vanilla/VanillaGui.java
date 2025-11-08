package de.crazypokemondev.uniGUI.guis.vanilla;

import de.crazypokemondev.uniGUI.api.Gui;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.janboerman.guilib.api.menu.MenuHolder;

public abstract class VanillaGui implements Gui {
    protected final MenuHolder<? extends Plugin> menuHolder;

    protected VanillaGui(MenuHolder<? extends Plugin> menuHolder) {
        this.menuHolder = menuHolder;
    }

    @Override
    public void close(Player player) {
        player.closeInventory();
    }

    @Override
    public void open(Player player) {
        player.openInventory(menuHolder.getInventory());
    }
}
