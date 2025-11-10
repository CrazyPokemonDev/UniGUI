package de.crazypokemondev.uniGUI;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.api.GuiFactory;
import de.crazypokemondev.uniGUI.api.GuiHandler;
import de.crazypokemondev.uniGUI.api.GuiRegistry;
import de.crazypokemondev.uniGUI.api.error.GuiNotSupportedException;
import de.crazypokemondev.uniGUI.api.GuiState;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class UniGuiHandler implements GuiHandler {
    private final GuiRegistry registry;

    public UniGuiHandler(GuiRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Gui openGui(@NotNull Player player, @NotNull String guiId, @Nullable GuiState state) throws GuiNotSupportedException {
        Optional<GuiFactory> optional = registry.getGui(guiId, player);
        GuiFactory factory = optional.orElseThrow(() -> new GuiNotSupportedException(player, guiId));
        Gui gui = factory.createGui(player, state);
        gui.open(player);
        return gui;
    }
}
