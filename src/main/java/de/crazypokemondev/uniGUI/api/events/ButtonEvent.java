package de.crazypokemondev.uniGUI.api.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ButtonEvent extends Event implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean cancelled;
    @Getter
    private final String guiId;
    @Getter
    private final String buttonId;
    @Getter
    private final Player whoClicked;

    public ButtonEvent(String guiId, String buttonId, Player whoClicked) {
        this.guiId = guiId;
        this.buttonId = buttonId;
        this.whoClicked = whoClicked;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
