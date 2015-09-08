package starglas.dsremake.handler;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.gui.container.ContainerCustomPlayer;
import starglas.dsremake.packet.OpenPlayerGuiPacket;

public class KeyHandler {

    /** Key index for easy handling */

    public static final int CUSTOM_INV = 0;
    public static final int SPELLMINUS = 1;
    public static final int SPELLPLUS = 2;


    /** Key descriptions; use a language file to localize the description later */

    private static final String[] desc = {"key.open_ds_inventory", "key.spell_minus", "key.spell_plus"};



    /** Default key values – these can be changed using the in-game menu */

    private static final int[] keyValues = {Keyboard.KEY_P, Keyboard.KEY_I, Keyboard.KEY_O};



    public static final KeyBinding[] keys = new KeyBinding[desc.length];

    public KeyHandler() {

        // the advantage of doing it with the above static arrays is now we can just loop through

        // creating and registering all of our keybindings automatically


        for (int i = 0; i < desc.length; ++i) {

             // create the new KeyBinding:

            keys[ i ] = new KeyBinding(desc[ i ], keyValues[ i ], "darksouls");

            // and be sure to register it to the ClientRegistry:

            ClientRegistry.registerKeyBinding(keys[ i ]);

        }

    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {

        if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
            int kb = Keyboard.getEventKey();

            boolean isDown = Keyboard.getEventKeyState();
            if (kb == keys[CUSTOM_INV].getKeyCode()) {
                EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
                if (player.openContainer instanceof ContainerCustomPlayer) {
                    player.closeScreen();
                }
                else {
                    DSMain.packetPipeline.sendToServer(new OpenPlayerGuiPacket(ModVars.GUI_DSINV));
                }
            }


        }

    }

}