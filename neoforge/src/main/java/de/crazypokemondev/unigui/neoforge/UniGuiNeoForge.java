package de.crazypokemondev.unigui.neoforge;

import de.crazypokemondev.unigui.UniGuiApi;
import net.neoforged.fml.common.Mod;

import de.crazypokemondev.unigui.UniGuiCommon;

@Mod(UniGuiApi.MOD_ID)
public final class UniGuiNeoForge {
    public UniGuiNeoForge() {
        // Run our common setup.
        UniGuiCommon.init();
    }
}
