package starglas.dsremake.common.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBonfire extends TileEntity {
	public static int isLit;

	public void processActivate(EntityPlayer player, World world) {

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.isLit = nbt.getInteger("isLit");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("isLit", isLit);
	}

}