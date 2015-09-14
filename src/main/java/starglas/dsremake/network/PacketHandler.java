package starglas.dsremake.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import starglas.dsremake.common.helpers.ModVars;

/**
 * Created by Starlight on 11-9-2015.
 */
public class PacketHandler {
    private static SimpleNetworkWrapper INSTANCE;

    public static void init(){
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModVars.PACKET_CHANNEL);

        INSTANCE.registerMessage(MessageTest.class, MessageTest.class, 0, Side.SERVER);
        INSTANCE.registerMessage(SyncPlayerPropsPacket.class, SyncPlayerPropsPacket.class, 1, Side.CLIENT);
        INSTANCE.registerMessage(OpenPlayerGuiPacket.class, OpenPlayerGuiPacket.class, 2, Side.SERVER);
        INSTANCE.registerMessage(PlayerUseItem.class, PlayerUseItem.class, 3, Side.SERVER);
        INSTANCE.registerMessage(SetupClassPacket.class, SetupClassPacket.class, 4, Side.SERVER);
    }
    /**
     * Send this message to the specified player.
     * See {@link SimpleNetworkWrapper#sendTo(IMessage, EntityPlayerMP)}
     */
    public static final void sendTo(IMessage message, EntityPlayerMP player) {
        INSTANCE.sendTo(message, player);
    }

    /**
     * Send this message to everyone within a certain range of a point.
     * See {@link SimpleNetworkWrapper#sendToAllAround(IMessage, NetworkRegistry.TargetPoint)}
     */
    public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
        INSTANCE.sendToAllAround(message, point);
    }

    /**
     * Sends a message to everyone within a certain range of the coordinates in the same dimension.
     */
    public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
        INSTANCE.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
    }

    /**
     * Sends a message to everyone within a certain range of the player provided.
     */
    public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) {
        INSTANCE.sendToAllAround(message, new NetworkRegistry.TargetPoint(player.worldObj.provider.dimensionId, player.posX, player.posY, player.posZ, range));
    }

    /**
     * Send this message to everyone within the supplied dimension.
     * See {@link SimpleNetworkWrapper#sendToDimension(IMessage, int)}
     */
    public static final void sendToDimension(IMessage message, int dimensionId) {
        INSTANCE.sendToDimension(message, dimensionId);
    }

    /**
     * Send this message to the server.
     * See {@link SimpleNetworkWrapper#sendToServer(IMessage)}
     */
    public static final void sendToServer(IMessage message) {
        INSTANCE.sendToServer(message);
    }
}
