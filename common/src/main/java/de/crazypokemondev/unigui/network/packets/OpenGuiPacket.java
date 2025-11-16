package de.crazypokemondev.unigui.network.packets;

import de.crazypokemondev.unigui.UniGuiApi;
import de.crazypokemondev.unigui.UniGuiCommon;
import de.crazypokemondev.unigui.api.CustomGuiFactory;
import de.crazypokemondev.unigui.api.EncodableGuiState;
import de.crazypokemondev.unigui.api.StateDecoder;
import de.crazypokemondev.unigui.api.StatefulScreen;
import dev.architectury.networking.NetworkManager;
import lombok.extern.slf4j.Slf4j;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class OpenGuiPacket extends OpenGuiPayload<EncodableGuiState<?>> implements CustomPacketPayload {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(UniGuiApi.MOD_ID, PACKET_NAME);
    public static final Type<OpenGuiPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<FriendlyByteBuf, OpenGuiPacket> CODEC = StreamCodec.of(OpenGuiPacket::encode, OpenGuiPacket::new);

    public OpenGuiPacket(FriendlyByteBuf byteBuf) {
        guiId = byteBuf.readUtf();
        StateDecoder<?> stateDecoder = null;
        ResourceLocation location = ResourceLocation.tryParse(guiId);
        if (location != null) {
            stateDecoder = UniGuiCommon.STATE_DECODERS.get(location);
        }
        if (stateDecoder != null) {
            this.state = stateDecoder.decode(byteBuf);
        }
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void encode(FriendlyByteBuf byteBuf, OpenGuiPacket testPackage) {
        byteBuf.writeUtf(testPackage.guiId);
        if (testPackage.state != null) {
            testPackage.state.encode(byteBuf);
        }
    }

    public static void receive(OpenGuiPacket packet, NetworkManager.PacketContext context) {
        context.queue(() -> {
            ResourceLocation location = ResourceLocation.tryParse(packet.getGuiId());
            if (location != null) {
                CustomGuiFactory guiFactory = UniGuiCommon.GUI_FACTORIES.get(location);
                if (guiFactory != null) {
                    Screen screen = guiFactory.createScreen();
                    if (packet.state != null && screen instanceof StatefulScreen<?> statefulScreen) {
                        setState(statefulScreen, packet.state);
                    }
                    Minecraft.getInstance().setScreen(screen);
                }
            }
        });
    }

    public static <T extends EncodableGuiState<T>> void setState(StatefulScreen<T> screen, EncodableGuiState<?> state) {
        Class<T> type = screen.stateType();
        if (type.isAssignableFrom(state.getClass())) {
            screen.updateState(type.cast(state));
        }
    }
}
