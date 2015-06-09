package starglas.dsremake.handler;

import net.minecraft.client.Minecraft;
import starglas.dsremake.common.helpers.ModHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TickEvents{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		
	}

	// Called when the client ticks.
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		//RegisterHelper.displayChat(event., "OnPlayerTick");
		//System.out.println("TICK");
	}

	// Called when the server ticks. Usually 20 ticks a second.
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		/*if(Minecraft.getMinecraft().theWorld.isRemote){
			//RegisterHelper.displayChat(Minecraft.getMinecraft().thePlayer, "OnPlayerTick");
			//System.out.println("TICK");
		}*/
	}

	// Called when a new frame is displayed (See fps)
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {

	}

	// Called when the world ticks
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		
	}
}
