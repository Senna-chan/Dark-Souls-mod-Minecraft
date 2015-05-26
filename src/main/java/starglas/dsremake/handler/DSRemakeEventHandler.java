package starglas.dsremake.handler;

import starglas.dsremake.common.helpers.RegisterHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DSRemakeEventHandler{
	@SubscribeEvent
	public void OnPlayerLogedIn(PlayerEvent.PlayerLoggedInEvent event){
		if (event.player instanceof EntityPlayer && DSPlayerHandler.get((EntityPlayer) event.player) == null){
			System.out.println("OnPlayerLogedIn");
			DSPlayerHandler.register((EntityPlayer) event.player);
			DSPlayerHandler handler = new DSPlayerHandler(event.player);
			handler.FirstLogin();
		}
	}
	@SubscribeEvent
    public void onPlayerTick(LivingUpdateEvent e){
        if (e.entity instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)e.entity;
            DSPlayerHandler handler = new DSPlayerHandler(player);
            handler.saveLastVisitedBonfire(player.posX, player.posY, player.posZ);
            //RegisterHelper.displayChat(player, "SPAM");
        }
    }
}
