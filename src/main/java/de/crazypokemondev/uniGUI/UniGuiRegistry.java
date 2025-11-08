package de.crazypokemondev.uniGUI;

import de.crazypokemondev.uniGUI.api.Gui;
import de.crazypokemondev.uniGUI.api.GuiRegistry;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class UniGuiRegistry implements GuiRegistry {
    private final Map<String, PriorityQueue<Gui>> registry = new HashMap<>();

    @Override
    public void register(@NotNull Gui gui) {
        if (!registry.containsKey(gui.getId())) {
            registry.put(gui.getId(), new PriorityQueue<>());
        }
        registry.get(gui.getId()).add(gui);
    }

    @Override
    public boolean unregister(@NotNull Gui gui) {
        if (registry.containsKey(gui.getId())) {
            return registry.get(gui.getId()).remove(gui);
        } else return false;
    }

    @Override
    public Optional<Gui> getGui(@NotNull String guiId, @NotNull Player player) {
        PriorityQueue<Gui> guis = registry.getOrDefault(guiId, null);
        if (guis != null) {
            for (Gui g : guis) {
                if (g.isSupportedByPlayer(player)) return Optional.of(g);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Gui> getAllGuis(@NotNull String guiId) {
        if (registry.containsKey(guiId)) return registry.get(guiId).stream().toList();
        else return Collections.emptyList();
    }
}
