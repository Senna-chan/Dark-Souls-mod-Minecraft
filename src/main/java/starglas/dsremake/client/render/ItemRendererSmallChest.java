package starglas.dsremake.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.smallchest;
import starglas.dsremake.common.helpers.ModReference;

public class ItemRendererSmallChest implements IItemRenderer {

	public smallchest model;
	
	public ItemRendererSmallChest(){
		model = new smallchest();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
//		switch(type){
//		case EQUIPPED:
//		case EQUIPPED_FIRST_PERSON:
//		case INVENTORY:
			return true;
//		default:
//			return false;
//		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModReference.MODID,"textures/blocks/Mimicchestfinal.png"));
				switch(type){
				case EQUIPPED:
				case EQUIPPED_FIRST_PERSON:
				
				//GL11.glTranslatef(0F, -3F, 0.65F);
				
				GL11.glScalef(0.3F, 0.3F, 0.3F);
				default:
					break;
				}
				model.renderAll(0.0625F);
				
			GL11.glPopMatrix();
		

	}

}
