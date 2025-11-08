package de.crazypokemondev.uniGUI;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.api.GuiHandler;
import de.crazypokemondev.uniGUI.api.GuiRegistry;
import de.crazypokemondev.uniGUI.api.error.GuiNotSupportedException;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class UniGuiHandler implements GuiHandler {
    private final GuiRegistry registry;

    public UniGuiHandler(GuiRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Gui openGui(@NotNull Player player, @NotNull String guiId) throws GuiNotSupportedException {
        Optional<Gui> optional = registry.getGui(guiId, player);
        Gui gui = optional.orElseThrow(() -> new GuiNotSupportedException(player, guiId));
        gui.open(player);
        return gui;
    }
}
