package starglas.dsremake.common;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import starglas.dsremake.entity.ModEntities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class CommonProxy {

	public void registerProxies() {//Server and Client stuff
		ModEntities.init();
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


	public boolean isSinglePlayer() {
		return false;
	}

	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
	
}