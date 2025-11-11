# UniGUI

## About

UniGUI is a plugin library that allows developers to create universal GUIs for both vanilla and modded clients.

For vanilla implementations, it is suggested to use [GuiLib](https://github.com/jannyboy11/guilib/) by Jannyboy11.

## Getting Started

### Installation

You can use this library as a dependency with JitPack:

```groovy
repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}

dependencies {
    compileOnly 'com.github.Olfi01:UniGUI:v0.1'
}
```

This requires users of your plugin to also install the UniGUI plugin!
If you want to be able to use your plugin without a separate UniGUI plugin installation, you will have to shade the
dependency into your jar file.

### Usage

#### Registering GUIs

The GUI registry to register GUIs can be obtained like this:

```java
public void onEnable() {
    RegisteredServiceProvider<GuiRegistry> guiRegistryProvider = getServer().getServicesManager().getRegistration(GuiRegistry.class);
    GuiRegistry registry = guiRegistryProvider.getProvider();
}
```

Opening a GUI for a player is done using the GuiHandler, which is obtained similarly:

```java
RegisteredServiceProvider<GuiHandler> guiHandlerProvider = getServer().getServicesManager().getRegistration(GuiHandler.class);
GuiHandler handler = guiHandlerProvider.getProvider();
```

## Examples

### Vanilla

Below you can see a very simple example of a stateless vanilla GUI using GuiLib.

```java
public final class MinecraftUnoRebuilt extends JavaPlugin {
    public void onEnable() {
        RegisteredServiceProvider<GuiRegistry> guiRegistryProvider = getServer().getServicesManager().getRegistration(GuiRegistry.class);
        GuiRegistry registry = guiRegistryProvider.getProvider();
        registry.register(new VanillaGuiFactoryStateless("myplugin:mygui", MyGui::new));

        RegisteredServiceProvider<GuiHandler> guiHandlerProvider = getServer().getServicesManager().getRegistration(GuiHandler.class);
        GuiHandler handler = guiHandlerProvider.getProvider();
        registerCommand("mygui", (commandSourceStack, args) ->
                handler.openGui((Player) commandSourceStack.getExecutor(), "myplugin:mygui", null)
        );
    }
}
```

```java
public class MyGui extends MenuHolder<MyPlugin> implements Gui {
    public MyGui() {
        super(MyPlugin.INSTANCE, InventoryType.CHEST, "My GUI");
        setButton(13, new ItemButton<MyGui>(new ItemBuilder(Material.APPLE).name("Click me!").build()) {
            @Override
            public void onClick(MyGui holder, InventoryClickEvent event) {
                event.getWhoClicked().sendMessage("Hello from my GUI!");
            }
        });
    }

    @Override
    public void open(Player player) {
        player.openInventory(this.getInventory());
    }

    @Override
    public void close(Player player) {
        player.closeInventory();
    }
}
```
