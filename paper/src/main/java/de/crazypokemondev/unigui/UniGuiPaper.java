package de.crazypokemondev.unigui;

import de.crazypokemondev.unigui.api.GuiHandler;
import de.crazypokemondev.unigui.api.GuiRegistry;
import de.crazypokemondev.unigui.network.NetworkManager;
import de.crazypokemondev.unigui.network.packets.OpenGuiPacket;
import de.crazypokemondev.unigui.state.TestGuiState;
import org.bukkit.entity.Player;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class UniGuiPaper extends JavaPlugin {
    public static UniGuiPaper INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this, UniGuiApi.MOD_ID + ":" + OpenGuiPacket.PACKET_NAME);
        TestGuiState state = new TestGuiState("hello");
        registerCommand("nettest", (source, args) -> {
            if (!(source.getSender() instanceof Player player)) return;
            NetworkManager.sendToPlayer(player, new OpenGuiPacket("unigui:testgui", state));
        });
        registerCommand("changetext", (source, args) -> {
            state.setText(String.join(" ", args));
            state.notifyStateChanged();
        });
        // TODO incoming listener for default abstract implementations
        getServer().getServicesManager().register(GuiRegistry.class, UniGuiRegistry.INSTANCE, this, ServicePriority.Normal);
        getServer().getServicesManager().register(GuiHandler.class, UniGuiHandler.INSTANCE, this, ServicePriority.Normal);
    }

    @Override
    public void onDisable() {
        getServer().getMessenger().unregisterOutgoingPluginChannel(this, UniGuiApi.MOD_ID + ":" + OpenGuiPacket.PACKET_NAME);
        // TODO incoming listener for default abstract implementations
        getServer().getServicesManager().unregister(UniGuiRegistry.INSTANCE);
        getServer().getServicesManager().unregister(UniGuiHandler.INSTANCE);
    }
}
