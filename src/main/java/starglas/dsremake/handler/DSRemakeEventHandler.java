package starglas.dsremake.handler;

import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.items.fists.GenericFist;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

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
	public void OnPlayerLogedIn(PlayerEvent.PlayerLoggedInEvent event){
		if (event.player instanceof EntityPlayer && DSPlayerHandler.get((EntityPlayer) event.player) == null){
			System.out.println("OnPlayerLogedIn");
			//DSPlayerHandler.register((EntityPlayer) event.player);
		DSPlayerHandler handler = new DSPlayerHandler(event.player);
			NBTTagCompound nbt = new NBTTagCompound();
			handler.loadNBTData(nbt);
			handler.FirstLogin();
		}
	}
	@SubscribeEvent
    public void onPlayerTick(LivingUpdateEvent e){
        if (e.entity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)e.entity;
//            DSPlayerHandler handler = new DSPlayerHandler(player);
//            NBTTagCompound nbt = new NBTTagCompound();
//			handler.loadNBTData(nbt);
//            this.playerStrength = handler.getPlayerStrength();
//            this.playerGrace = handler.getPlayerStrength();
        }
    }
}
