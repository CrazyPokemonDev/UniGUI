package de.crazypokemondev.unigui.api;

import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface CustomGuiFactory {
    @NotNull
    Screen createScreen();
}
