package starglas.dsremake.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.ModReference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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

	/*@SubscribeEvent
	public void OnPlayerLogedIn(PlayerEvent.PlayerLoggedInEvent event){
		if (event.player instanceof EntityPlayer && DSPlayerHandler.get((EntityPlayer) event.player) == null){
			System.out.println("OnPlayerLogedIn");
			DSPlayerHandler.register((EntityPlayer) event.player);
			DSPlayerHandler handler = new DSPlayerHandler(event.player);
			NBTTagCompound nbt = new NBTTagCompound();
			handler.loadNBTData(nbt);
			handler.FirstLogin();
		}
	}*/
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
			// finally, we sync the data between server and client (we did this earlier in 3.3)
			//((ExtendedPlayer)(event.entity.getExtendedProperties(ModReference.NBTExtendedName))).syncExtendedProperties();
		}
	}
}