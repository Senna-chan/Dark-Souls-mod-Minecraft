package starglas.dsremake.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import starglas.dsremake.handler.ExtendedPlayer;

public class SyncPlayerPropsPacket extends MessageBase<SyncPlayerPropsPacket>

{

	// Previously, we've been writing each field in our properties one at a
	// time,

	// but that is really annoying, and we've already done it in the save and
	// load

	// NBT methods anyway, so here's a slick way to efficiently send all of your

	// extended data, and no matter how much you add or remove, you'll never
	// have

	// to change the network / synchronization of your data.

	// this will store our ExtendedPlayer data, allowing us to easily read and
	// write

	private NBTTagCompound data;

	// The basic, no-argument constructor MUST be included to use the new
	// automated handling

	public SyncPlayerPropsPacket() {}
	// We need to initialize our data, so provide a suitable constructor:
	public SyncPlayerPropsPacket(EntityPlayer player) {
		// create a new tag compound
		data = new NBTTagCompound();
		// and save our player's data into it
		ExtendedPlayer.get(player).saveNBTData(data);
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		// ByteBufUtils provides a convenient method for writing the compound
		ByteBufUtils.writeTag(buffer, data);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		// luckily, ByteBufUtils provides an easy way to read the NBT
		data = ByteBufUtils.readTag(buffer);
	}

	@Override
	public void handleClientSide(SyncPlayerPropsPacket message, EntityPlayer player) {

	}

	@Override
	public void handleServerSide(SyncPlayerPropsPacket message, EntityPlayer player) {

	}
}