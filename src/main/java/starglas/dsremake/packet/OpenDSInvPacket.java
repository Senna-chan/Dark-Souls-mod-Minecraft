package starglas.dsremake.packet;

import starglas.dsremake.common.DSMain;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class OpenDSInvPacket extends AbstractPacket{

	private byte id;
	
	public OpenDSInvPacket(){}
	
	public OpenDSInvPacket(byte id){
		this.id = id;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeByte(id);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		this.id = buffer.readByte();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		System.out.println("YA DIDN'T FUCKED UP");
		FMLNetworkHandler.openGui(player, DSMain.instance, this.id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

}
