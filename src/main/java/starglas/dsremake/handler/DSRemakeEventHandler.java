package starglas.dsremake.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.entity.mobs.trader.DSTrader;

import java.util.List;

public class DSRemakeEventHandler{
	public static int 		playerLevel;
	public static String 	playerClass = "";
	public static int 		playerHP;
	public static int 		playerStamina;
	public static int 		playerStrength;
	public static int 		playerGrace;
	public static int 		playerWill;
	public static int 		playerResolve;
	public static int 		playerWrath;
	public static int 		playerSerenity;
	public static int	 	playerHarmony;

	@SubscribeEvent
	public void OnPlayerConstruct(EntityEvent.EntityConstructing event){
		
		if(event.entity instanceof EntityPlayer){
			System.out.println("EntityConstructing event called; is this the client side? " + event.entity.worldObj.isRemote);
			Entity player = event.entity;
			if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null){
				ExtendedPlayer.register((EntityPlayer) event.entity);
				ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);
				props.FirstLogin();
			}
		}
	}
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		// we only want to save data for players (most likely, anyway)
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			// NOTE: See step 6 for a way to do this all in one line!!!
			// create a new NBT Tag Compound to store the IExtendedEntityProperties data
			NBTTagCompound playerData = new NBTTagCompound();
			// write the data to the new compound
			((ExtendedPlayer)(event.entity.getExtendedProperties(ModReference.NBTExtendedName))).saveNBTData(playerData);
			// and store it in our proxy
			DSMain.proxy.storeEntityData(((EntityPlayer) event.entity).getUniqueID(), playerData);
			// call our handy static one-liner to save custom data to the proxy
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}

	// we already have this event, but we need to modify it some
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			// NOTE: See step 6 for a way to do this all in one line!!!
			// before syncing the properties, we must first check if the player has some saved in the proxy
			// recall that 'getEntityData' also removes it from the map, so be sure to store it locally
			NBTTagCompound playerData = DSMain.proxy.getEntityData(((EntityPlayer) event.entity).getUniqueID());
			// make sure the compound isn't null
			if (playerData != null) {
				// then load the data back into the player's IExtendedEntityProperties
				((ExtendedPlayer)(event.entity.getExtendedProperties(ModReference.NBTExtendedName))).loadNBTData(playerData);
			}
		}
	}
	@SubscribeEvent
	public void onPlayerTick(LivingEvent.LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			Entity player = event.entity;
			if (ExtendedPlayer.get((EntityPlayer) player) != null){
				List foundPlayers = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX - 5, player.posY - 1, player.posZ - 5, player.posX + 5, player.posY + 5, player.posZ + 5));
				for(int i=0; i < foundPlayers.size();i++) {
					Object currentElement = foundPlayers.get(i);
					if(currentElement instanceof EntityLivingBase && currentElement != player && !(currentElement instanceof DSTrader)){
						ModHelper.displayChat((EntityPlayer)player, foundPlayers.get(i).getClass() + "");
					}

				}

			}
		}
	}
}