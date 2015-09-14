package starglas.dsremake.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Starlight on 11-9-2015.
 */
public class MessageTest extends MessageBase<MessageTest> {

    private static int slot;

    public MessageTest(){}

    public MessageTest(int slot){
        this.slot = slot;
    }

    @Override
    public void fromBytes(ByteBuf buf){
        slot = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(slot);
    }

    @Override
    public void handleClientSide(MessageTest message, EntityPlayer player) {
        System.out.println("MessageTest.handleClientSide");
    }

    @Override
    public void handleServerSide(MessageTest message, EntityPlayer player) {
        System.out.println("MessageTest.handleServerSide");

    }
}
