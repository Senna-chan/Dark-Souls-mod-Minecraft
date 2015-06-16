package starglas.dsremake.handler;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyHandler {

	
	private static final String[] keyDesc = {"key.DSRemake.inv.desc"};
	private static final int[] keyValues = {Keyboard.KEY_B};
	private final KeyBinding[] keys;
	
	public KeyHandler(){
		keys = new KeyBinding[keyValues.length];
		for(int i = 0; i < keyValues.length; i++){
			keys[i] = new KeyBinding(keyDesc[i], keyValues[i], "key.DSRemake.category");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	@SubscribeEvent
	public void onKeyPressed(InputEvent.KeyInputEvent event){
		if(!FMLClientHandler.instance().isGUIOpen(GuiChat.class)){
			int key = Keyboard.getEventKey();
			boolean isDown = Keyboard.getEventKeyState();
			
			// DSRemake inv
			if(isDown && key== keyValues[0/* DSREMAKE Inv*/]){
				// Send packet to open gui
				//DSMain.packetpipeline.sendToSever(new OpenDSInvPacket(ModReference.GUI_DSINV));
			}
		}
	}
	
}