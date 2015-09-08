package starglas.dsremake.common;

import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


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