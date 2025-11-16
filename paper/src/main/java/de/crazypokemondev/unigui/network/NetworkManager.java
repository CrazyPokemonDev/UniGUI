package de.crazypokemondev.unigui.network;

import de.crazypokemondev.unigui.UniGuiApi;
import de.crazypokemondev.unigui.UniGuiPaper;
import de.crazypokemondev.unigui.network.packets.Packet;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import org.bukkit.entity.Player;

public class NetworkManager {
    public static <T extends Packet> void sendToPlayer(Player player, T packet) {
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        packet.encode(buffer);

        FriendlyByteBuf packetSizeBuf = new FriendlyByteBuf(Unpooled.buffer());
        int packetSize = buffer.readableBytes();
        packetSizeBuf.writeVarInt(packetSize);

        int packetSizeLength = packetSizeBuf.readableBytes();
        byte[] bytes = new byte[packetSizeLength + packetSize];
        packetSizeBuf.readBytes(bytes, 0, packetSizeLength);
        buffer.readBytes(bytes, packetSizeLength, packetSize);

        player.sendPluginMessage(UniGuiPaper.INSTANCE, UniGuiApi.MOD_ID + ":" + packet.getName(), bytes);
    }
}
