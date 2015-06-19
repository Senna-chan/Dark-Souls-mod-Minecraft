package starglas.dsremake.common;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.handler.ExtendedPlayer;


public class CommonProxy {

	public void registerProxies() {//Server and Client stuff
		
	}
	
	private static final Map<UUID, NBTTagCompound> extendedEntityData = new HashMap<UUID, NBTTagCompound>();
	
	public static void storeEntityData(UUID uuid, NBTTagCompound compound)
	{
		extendedEntityData.put(uuid, compound);
	}

	/**
	* Removes the compound from the map and returns the NBT tag stored for name or null if none exists
	*/
	public static NBTTagCompound getEntityData(UUID uuid)
	{
		return extendedEntityData.remove(uuid);
	}	
	
}