package starglas.dsremake.common.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import starglas.dsremake.common.entity.TileEntityBonfire;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.common.items.consumables.Estus;
import starglas.dsremake.common.items.upgrades.RadiantOil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class BonFireGui extends GuiScreen{
	
	int guiWidth = 300;
	int guiHeight = 200;
	
	int guiX = (width - guiWidth) / 2;
	int guiY = (height - guiHeight) /2;
	boolean radiantOilFound = false;
	
	int BonFireX, BonFireY, BonFireZ;
	
	public BonFireGui(int X, int Y, int Z){
		this.BonFireX = X;
		this.BonFireY = Y;
		this.BonFireZ = Z;
	}
	@Override
	public void drawScreen(int x, int y, float ticks){
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) /2;
		GL11.glColor4f(1F, 1F, 1F, 1F);
		drawDefaultBackground();
		mc.getTextureManager().bindTexture(new ResourceLocation(ModReference.MODID, "/gui/guitest.png"));
		
		//Draw stuff
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		//Text rendereing
		fontRendererObj.drawString("TEST", guiX + 20, guiY + 5, 0xF8A5F7);
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
		this.buttonList.add(new GuiButton(0, guiX + 40, guiY + 40, 50, 20, "Upgrade Bonfire"));
		this.buttonList.add(new GuiButton(1, guiX + 40, guiY + 80, 50, 20, "Teleport"));
		super.initGui();
	}
	@Override
	public void actionPerformed(GuiButton button){
		switch(button.id){
		case 0:
			ItemStack[] playerInventory = mc.thePlayer.inventory.mainInventory;

            for(ItemStack itemStack : playerInventory){
                if(itemStack != null && itemStack.getItem() instanceof RadiantOil){
                	mc.thePlayer.inventory.consumeInventoryItem(ModItems.RadiantOil);
                	radiantOilFound = true;
                	break;
                }
            }
			if(radiantOilFound == false){
				mc.thePlayer.addChatMessage(new ChatComponentText("Git Gud Faggot. Ya need a Radiant Oil"));
			}
			else{
				mc.thePlayer.addChatMessage(new ChatComponentText("BonFire level upgraded"));
				TileEntityBonfire t = (TileEntityBonfire) mc.theWorld.getTileEntity(BonFireX, BonFireY, BonFireZ);
				t.processOnActivate(mc.thePlayer, mc.theWorld);
				radiantOilFound = false;
			}
			break;
		case 1:
			mc.thePlayer.addChatMessage(new ChatComponentText("WIP"));
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
