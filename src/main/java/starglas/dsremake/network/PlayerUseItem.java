package starglas.dsremake.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.handler.ExtendedPlayer;
import starglas.dsremake.network.PacketPipeline.AbstractPacket;

/**
 * Created by Starlight on 11-9-2015.
 */
public class PlayerUseItem extends MessageBase<PlayerUseItem> {
    // this will store the id of the gui to open

    private int itemSlot;

    // The basic, no-argument constructor MUST be included to use the new
    // automated handling

    public PlayerUseItem() {
    }

    // if there are any class fields, be sure to provide a constructor that
    // allows

    // for them to be initialized, and use that constructor when sending the
    // network

    public PlayerUseItem(int id) {

        this.itemSlot = id;

    }

    @Override
    public void toBytes(ByteBuf buffer) {

        // basic Input/Output operations, very much like DataOutputStream

        buffer.writeInt(itemSlot);

    }

    @Override
    public void fromBytes(ByteBuf buffer) {
        // basic Input/Output operations, very much like DataInputStream
        itemSlot = buffer.readInt();
    }

    @Override
    public void handleClientSide(PlayerUseItem message, EntityPlayer player) {
        System.out.println("PlayerUseItem.handleClientSide");
    }

    @Override
    public void handleServerSide(PlayerUseItem message, EntityPlayer player) {
        System.out.println("PlayerUseItem.handleServerSide");
        ItemStack Mahou = ExtendedPlayer.get(player).inventoryPlayer.getStackInSlot(message.itemSlot);
        Mahou.useItemRightClick(player.worldObj, player);
    }
}
