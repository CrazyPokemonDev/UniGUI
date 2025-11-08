package de.crazypokemondev.uniGUI.guis.vanilla.buttons;

import de.crazypokemondev.uniGUI.api.events.ButtonEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import xyz.janboerman.guilib.api.menu.ItemButton;
import xyz.janboerman.guilib.api.menu.MenuHolder;
import xyz.janboerman.guilib.util.Scheduler;

public class EventButton<MH extends MenuHolder<?>> extends ItemButton<MH> {
    private final String guiId;
    private final String buttonId;
    private final boolean closeOnClick;

    public EventButton(ItemStack itemStack, String guiId, String buttonId) {
        this(itemStack, guiId, buttonId, false);
    }

    public EventButton(ItemStack itemStack, String guiId, String buttonId, boolean closeOnClick) {
        super(itemStack);
        this.guiId = guiId;
        this.buttonId = buttonId;
        this.closeOnClick = closeOnClick;
    }

    @Override
    public void onClick(MH holder, InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        new ButtonEvent(guiId, buttonId, player).callEvent();
        if (this.closeOnClick) {
            Scheduler scheduler = Scheduler.get();
            scheduler.runTaskLater(holder.getPlugin(), event.getWhoClicked(), event.getView()::close);
        }
    }
}
