package de.crazypokemondev.uniGUI.api.error;

import org.bukkit.entity.Player;

public class GuiNotSupportedException extends RuntimeException {
    public GuiNotSupportedException(Player player, String guiId) {
        super(String.format(
                "GUI %s is not compatible with vanilla clients and no supported custom GUI client was reported by player %s",
                guiId, player.getUniqueId()));
    }
}
