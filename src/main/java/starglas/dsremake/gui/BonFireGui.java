package starglas.dsremake.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;

public class BonFireGui extends GuiScreen{

	int guiWidth = 190;
	int guiHeight = 130;
	
	int guiX = (width - guiWidth) / 2;
	int guiY = (height - guiHeight) /2;
	
	public static int BonFireX, BonFireY, BonFireZ;
	EntityPlayer player;
	InventoryPlayer playerInv;
	ExtendedPlayer props;


	public BonFireGui(EntityPlayer player, InventoryPlayer inventoryplayer, ExtendedPlayer extendedPlayer){
		this.player = player;
		this.playerInv = inventoryplayer;
		this.props = extendedPlayer;
	}

	@Override
	public void drawScreen(int x, int y, float ticks){
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) /2;
		GL11.glColor4f(1F, 1F, 1F, 1F);
		drawDefaultBackground();
		mc.getTextureManager().bindTexture(new ResourceLocation(ModVars.MODID, "/gui/guitest.png"));
		
		//Draw stuff
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		//Text rendereing
		ExtendedPlayer props = ExtendedPlayer.get(player);
		fontRendererObj.drawString(ModVars.CLASSNAMES[props.getPlayerClass()], guiX + 20, guiY + 5, 0xF8A5F7);
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}
	@Override
	public void initGui(){
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) /2;
		//this.buttonList.add(new GuiButton(0, guiX + 40, guiY + 40, 50, 20, "Upgrade Bonfire"));
		this.buttonList.add(new GuiButton(1, guiX + 40, guiY + 80, 50, 20, "Teleport"));
		super.initGui();
	}
	@Override
	public void actionPerformed(GuiButton button){
		switch(button.id){
		case 0:

			break;
		case 1:
			ModHelper.displayChat(player,"WIP");
		default:
			break;
		}
	}
	@Override
	protected void keyTyped(char c, int key){
		switch(key){
		case Keyboard.KEY_E:
			mc.displayGuiScreen(null);
		}
		super.keyTyped(c, key);
	}
	
}
