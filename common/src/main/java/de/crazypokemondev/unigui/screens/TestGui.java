package de.crazypokemondev.unigui.screens;

import de.crazypokemondev.unigui.api.StatefulScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class TestGui extends Screen implements StatefulScreen<TestGuiState> {
    private TestGuiState state;

    public TestGui() {
        super(Component.literal("Test"));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);

        guiGraphics.drawCenteredString(font, state.getText(), width / 2, height / 2, 0xffffffff);
    }

    @Override
    public void updateState(TestGuiState state) {
        this.state = state;
    }

    @Override
    public @NotNull Class<TestGuiState> stateType() {
        return TestGuiState.class;
    }
}
