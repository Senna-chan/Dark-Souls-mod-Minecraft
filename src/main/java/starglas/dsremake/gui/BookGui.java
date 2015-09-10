package starglas.dsremake.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;
import starglas.dsremake.network.SetupClassPacket;

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
		this.buttonList.add(new GuiButton(ModVars.KNIGHTCLASS, guiX + 10, guiY + 10, 65, 20, "Knight"));
		this.buttonList.add(new GuiButton(ModVars.PYROMANCERCLASS, guiX + 10, guiY + 10 + 25 * 1, 65, 20, "Pyromancer"));
		this.buttonList.add(new GuiButton(ModVars.PALADINCLASS, guiX + 10, guiY + 10 + 25 * 2, 65, 20, "Paladin"));
		this.buttonList.add(new GuiButton(ModVars.WANDERERCLASS, guiX + 10, guiY + 10 + 25 * 3, 65, 20, "Wanderer"));
		super.initGui();
	}
	@Override
	public void actionPerformed(GuiButton button){
		ExtendedPlayer props = ExtendedPlayer.get(player);
		DSMain.packetPipeline.sendToServer(new SetupClassPacket(button.id));
		ModHelper.displayChat(player, "You are now a " + ModVars.CLASSNAMES[button.id]);
	}
	
}
