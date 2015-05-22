package starglas.dsremake.common;

import net.minecraftforge.common.MinecraftForge;
import starglas.dsremake.handler.DSRemakeEventHandler;
import starglas.dsremake.handler.KeyHandler;
import starglas.dsremake.handler.TickEvents;
import cpw.mods.fml.common.FMLCommonHandler;


public class CommonProxy {

	public void registerProxies() {//Server stuff
		FMLCommonHandler.instance().bus().register(new KeyHandler()); // Reg key and event for keystuff
		
	}
}