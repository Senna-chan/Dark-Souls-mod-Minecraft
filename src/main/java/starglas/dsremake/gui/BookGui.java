package starglas.dsremake.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;

public class BookGui extends GuiScreen{

	private EntityPlayer player;
	int guiWidth = 190;
	int guiHeight = 130;
	
	int guiX = (width - guiWidth) / 2;
	int guiY = (height - guiHeight) /2;
	
	public BookGui(EntityPlayer player){
		this.player = player;
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
		this.buttonList.add(new GuiButton(1, guiX + 10, guiY + 10, 65, 20, "Soldier"));
		this.buttonList.add(new GuiButton(2, guiX + 10, guiY + 10 + 25 * 1, 65, 20, "Sorcerer)"));
		this.buttonList.add(new GuiButton(3, guiX + 10, guiY + 10 + 25 * 2, 65, 20, "Cleric"));
		this.buttonList.add(new GuiButton(4, guiX + 10, guiY + 10 + 25 * 3, 65, 20, "Human"));
		super.initGui();
	}
	@Override
	public void actionPerformed(GuiButton button){
		ExtendedPlayer props = ExtendedPlayer.get(player);
		switch(button.id){
			case 1:
				props.classSetup(1);
				ModHelper.displayChat(player, "Go slash 'm up");
				break;
			case 2:
				props.classSetup(2);
				ModHelper.displayChat(player, "Go out of your parents basement u virgin");
				break;
			case 3:
				props.classSetup(3);
				ModHelper.displayChat(player, "Cleric");
				break;
			case 4:
				props.classSetup(4);
				ModHelper.displayChat(player, "Waste of human skin");
			default:
				break;
		}
		System.out.println("BookGui.actionPerformed");
		int indexForClassName = props.getPlayerClass();
		ModHelper.displayChat(player, "You are now a "+ ModVars.CLASSNAMES[indexForClassName]);
	}
	@Override
	protected void keyTyped(char c, int key) {
		if (key == mc.gameSettings.keyBindInventory.getKeyCode()){
			mc.displayGuiScreen(null);
		}
		super.keyTyped(c, key);
	}
	
}
