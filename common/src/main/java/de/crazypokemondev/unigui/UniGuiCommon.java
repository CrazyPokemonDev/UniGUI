package de.crazypokemondev.unigui;

import com.google.common.base.Suppliers;
import de.crazypokemondev.unigui.api.CustomGuiFactory;
import de.crazypokemondev.unigui.api.StateDecoder;
import de.crazypokemondev.unigui.network.packets.OpenGuiPacket;
import de.crazypokemondev.unigui.screens.TestGui;
import de.crazypokemondev.unigui.screens.TestGuiState;
import de.crazypokemondev.unigui.state.NullState;
import dev.architectury.networking.NetworkManager;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.options.DefaultIdRegistrarOption;
import lombok.extern.slf4j.Slf4j;
import net.fabricmc.api.EnvType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

@Slf4j
public final class UniGuiCommon {
    public static final Supplier<RegistrarManager> REGISTRY_MANAGER = Suppliers.memoize(() -> RegistrarManager.get(UniGuiApi.MOD_ID));
    public static Registrar<CustomGuiFactory> GUI_FACTORIES;
    public static Registrar<StateDecoder<?>> STATE_DECODERS;
    private static final ResourceLocation NULL_STATE_LOCATION = ResourceLocation.fromNamespaceAndPath(UniGuiApi.MOD_ID, "null");

    public static void init() {
        // Write common init code here.
        GUI_FACTORIES = REGISTRY_MANAGER.get()
                .builder(ResourceLocation.fromNamespaceAndPath(UniGuiApi.MOD_ID, "gui_factories"), new CustomGuiFactory[0])
                .build();
        STATE_DECODERS = REGISTRY_MANAGER.get()
                .builder(ResourceLocation.fromNamespaceAndPath(UniGuiApi.MOD_ID, "states"), new StateDecoder<?>[0])
                .option(new DefaultIdRegistrarOption(NULL_STATE_LOCATION))
                .build();
        STATE_DECODERS.register(NULL_STATE_LOCATION, NullState::new);

        GUI_FACTORIES.register(ResourceLocation.fromNamespaceAndPath(UniGuiApi.MOD_ID, "testgui"), () -> TestGui::new);
        STATE_DECODERS.register(ResourceLocation.fromNamespaceAndPath(UniGuiApi.MOD_ID, "testgui"), TestGuiState::new);

        if (Platform.getEnv() == EnvType.SERVER) {
            NetworkManager.registerS2CPayloadType(OpenGuiPacket.TYPE, OpenGuiPacket.CODEC);
        }
        if (Platform.getEnv() == EnvType.CLIENT) {
            NetworkManager.registerReceiver(NetworkManager.Side.S2C, OpenGuiPacket.TYPE, OpenGuiPacket.CODEC, OpenGuiPacket::receive);
        }
    }
}
