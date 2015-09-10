package starglas.dsremake.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 8-9-2015.
 */
public class SetupClassPacket extends AbstractPacket {
    private int id;

    // The basic, no-argument constructor MUST be included to use the new
    // automated handling=
    public SetupClassPacket() { }
    // if there are any class fields, be sure to provide a constructor that
    // allows
    // for them to be initialized, and use that constructor when sending the
    // network
    public SetupClassPacket(int id) {
        this.id = id;
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
        // basic Input/Output operations, very much like DataOutputStream
        buffer.writeInt(id);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
        // basic Input/Output operations, very much like DataInputStream
        id = buffer.readInt();
    }

    @Override
    public void handleClientSide(EntityPlayer player) {

    }

    @Override
    public void handleServerSide(EntityPlayer player) {
        ExtendedPlayer props = ExtendedPlayer.get(player);
        props.classSetup(id);
    }
}
