package starglas.dsremake.common.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TileEntityBonfire extends TileEntity {

	String owner = "none";
	int activated = 0;

	public void onPlaced(EntityPlayer player){
		player.addChatMessage(new ChatComponentText("Be sure to activate it or else you won't be the owner and someone else can break and/or upgrade it"));
		
	}
	
	public void processActivate(EntityPlayer player, World world) {
		owner = player.getDisplayName();
		activated = 1;
		player.addChatMessage(new ChatComponentText("This bonfire belongs to "
				+ owner + " Its activation is " + activated));
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.owner = nbt.getString("owner");
		this.activated = nbt.getInteger("activated");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("owner", owner);
		nbt.setInteger("1", activated);
	}
}