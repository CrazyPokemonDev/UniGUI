package de.crazypokemondev.unigui;

import de.crazypokemondev.unigui.api.GuiFactory;
import de.crazypokemondev.unigui.api.GuiRegistry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UniGuiRegistry implements GuiRegistry {
    public static UniGuiRegistry INSTANCE = new UniGuiRegistry();

    private final Map<String, PriorityQueue<GuiFactory>> registry = new HashMap<>();

    @Override
    public void register(@NotNull GuiFactory factory) {
        if (!registry.containsKey(factory.getId())) {
            registry.put(factory.getId(), new PriorityQueue<>());
        }
        registry.get(factory.getId()).add(factory);
    }

    @Override
    public boolean unregister(@NotNull GuiFactory factory) {
        if (registry.containsKey(factory.getId())) {
            return registry.get(factory.getId()).remove(factory);
        } else return false;
    }

    @Override
    public Optional<GuiFactory> getGui(@NotNull String guiId, @NotNull ServerPlayer player) {
        PriorityQueue<GuiFactory> guis = registry.getOrDefault(guiId, null);
        if (guis != null) {
            for (GuiFactory f : guis) {
                if (f.isSupportedByPlayer(player)) return Optional.of(f);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<GuiFactory> getAllGuis(@NotNull String guiId) {
        if (registry.containsKey(guiId)) return registry.get(guiId).stream().toList();
        else return Collections.emptyList();
    }
}
