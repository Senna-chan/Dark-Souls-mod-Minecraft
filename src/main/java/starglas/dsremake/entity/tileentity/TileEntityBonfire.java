package starglas.dsremake.entity.tileentity;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.handler.ExtendedPlayer;

public class TileEntityBonfire extends TileEntity {

	String owner;
	int activated = 0;
	int BonfireLevel = 1;

	public void onPlaced(EntityPlayer player,int X, int Y, int Z,  String bonfireType){
		owner = player.getDisplayName();
		activated = 1;
		ModHelper.displayChat(player, "This bonfire now belongs to " + owner + " Level is " + this.BonfireLevel + " and bonfire type is " + bonfireType);
		ExtendedPlayer props = ExtendedPlayer.get(player);
		props.saveBonfire(X, Y, Z);
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
	public void upgradeBonfire(){
		this.BonfireLevel = this.BonfireLevel + 1;
	}

	public int getBonFireLevel() {
		return this.BonfireLevel;
	}

	public String getOwner(){
		return this.owner;
	}
}