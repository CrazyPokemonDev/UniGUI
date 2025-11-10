package de.crazypokemondev.uniGUI;

import de.crazypokemondev.uniGUI.api.GuiHandler;
import de.crazypokemondev.uniGUI.api.GuiRegistry;
import de.crazypokemondev.uniGUI.network.Channels;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class UniGUI extends JavaPlugin {
    public static final String PLUGIN_ID = "UniGUI";
    public static UniGUI INSTANCE;
    private final GuiRegistry guiRegistry = new UniGuiRegistry();
    private final GuiHandler guiHandler = new UniGuiHandler(guiRegistry);

    @Override
    public void onEnable() {
        INSTANCE = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this, Channels.UNIGUI_MAIN.getId());
        // TODO incoming listener for default abstract implementations
        getServer().getServicesManager().register(GuiRegistry.class, guiRegistry, this, ServicePriority.Normal);
        getServer().getServicesManager().register(GuiHandler.class, guiHandler, this, ServicePriority.Normal);
    }

    @Override
    public void onDisable() {
        getServer().getServicesManager().unregister(guiHandler);
    }
}
