package starglas.dsremake.entity.tileentity;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TileEntityBonfire extends TileEntity {

	String owner = "none";
	int activated = 0;
	int BonfireLevel = 1;

	public void onPlaced(EntityPlayer player){
		owner = player.getUniqueID()+"";
		activated = 1;
		player.addChatMessage(new ChatComponentText("This bonfire belongs to " + owner + " Level is " + this.BonfireLevel));
	}
	
	public void processOnActivate(EntityPlayer player, World world) {
		player.addChatMessage(new ChatComponentText("Bonfire level: " + this.BonfireLevel));
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.owner = nbt.getString("owner");
		this.activated = nbt.getInteger("activated");
		this.BonfireLevel = nbt.getInteger("BonfireLevel");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("owner", owner);
		nbt.setInteger("activated", this.activated);
		nbt.setInteger("BonfireLevel", this.BonfireLevel);
	}
	public void BonfireUpgrade(){
		this.BonfireLevel = this.BonfireLevel + 1;
	}

	public int getBonFireLevel() {
		return this.BonfireLevel;
	}
}