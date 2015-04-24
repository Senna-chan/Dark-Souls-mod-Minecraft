package starglas.dsremake.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;

public class PlayerStatsTest {
	private static NBTTagInt strength;

	public static NBTTagInt PlayerStatsStr(EntityPlayer player){
		NBTTagCompound tag = player.getEntityData();
	
		NBTBase modeTag = tag.getTag("Strength");
		if (modeTag != null) {
			//player.addChatMessage("Current int:" + ((NBTTagInt)modeTag).data);
		}
	
		tag.setInteger("Strength", 150);
		strength = (NBTTagInt) tag.getTag("Strength");
		return strength;
	}
}
