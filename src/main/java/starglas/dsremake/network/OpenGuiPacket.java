package starglas.dsremake.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.common.helpers.ModVars;

public class OpenGuiPacket extends MessageBase<OpenGuiPacket>

{

	// this will store the id of the gui to open

	private int id;

	// The basic, no-argument constructor MUST be included to use the new
	// automated handling

	public OpenGuiPacket() {
	}

	// if there are any class fields, be sure to provide a constructor that
	// allows

	// for them to be initialized, and use that constructor when sending the
	// network

	public OpenGuiPacket(int id) {

		this.id = id;

	}

	@Override
	public void toBytes(ByteBuf buffer) {

		// basic Input/Output operations, very much like DataOutputStream

		buffer.writeInt(id);

	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		// basic Input/Output operations, very much like DataInputStream
		id = buffer.readInt();
	}

	@Override
	public void handleClientSide(OpenGuiPacket message, EntityPlayer player) {

	}

	@Override
	public void handleServerSide(OpenGuiPacket message, EntityPlayer player) {
		player.openGui(ModVars.MODID, message.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
}
