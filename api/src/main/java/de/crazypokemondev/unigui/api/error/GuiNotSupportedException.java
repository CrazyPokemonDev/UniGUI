package de.crazypokemondev.unigui.api.error;

import java.util.UUID;

/**
 * Thrown when a player's client does not support any GUI for the requested <code>guiId</code>.
 * This only happens if you forgot to register a GUI implementation, or if no vanilla implementation is present while
 * the player doesn't support any of the modded implementations.
 */
public class GuiNotSupportedException extends RuntimeException {
    public GuiNotSupportedException(UUID playerUuid, String guiId) {
        super(String.format(
                "GUI %s is not compatible with vanilla clients and no supported custom GUI client was reported by player %s",
                guiId, playerUuid));
    }
}
