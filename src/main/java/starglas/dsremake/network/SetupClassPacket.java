package starglas.dsremake.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 8-9-2015.
 */
public class SetupClassPacket extends MessageBase<SetupClassPacket> {
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
    public void toBytes(ByteBuf buffer) {
        // basic Input/Output operations, very much like DataOutputStream
        buffer.writeInt(id);
    }

    @Override
    public void fromBytes( ByteBuf buffer) {
        // basic Input/Output operations, very much like DataInputStream
        id = buffer.readInt();
    }

    @Override
    public void handleClientSide(SetupClassPacket message, EntityPlayer player) {

    }

    @Override
    public void handleServerSide(SetupClassPacket message, EntityPlayer player) {
        ExtendedPlayer props = ExtendedPlayer.get(player);
        props.classSetup(message.id);
    }


}
