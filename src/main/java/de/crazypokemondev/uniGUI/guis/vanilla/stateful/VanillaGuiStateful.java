package de.crazypokemondev.uniGUI.guis.vanilla.stateful;

import de.crazypokemondev.uniGUI.guis.GuiStateHolder;
import de.crazypokemondev.uniGUI.guis.vanilla.VanillaGui;
import org.bukkit.plugin.Plugin;
import xyz.janboerman.guilib.api.menu.MenuHolder;

public abstract class VanillaGuiStateful<TState extends GuiStateHolder> extends VanillaGui {
    protected final TState stateHolder;

    protected VanillaGuiStateful(MenuHolder<? extends Plugin> menuHolder, TState stateHolder) {
        super(menuHolder);
        this.stateHolder = stateHolder;
        this.stateHolder.registerChangeEventHandler(this::onUpdate);
    }

    protected abstract void onUpdate();
}
