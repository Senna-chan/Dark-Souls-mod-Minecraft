package starglas.dsremake.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.items.paladinglaive;
import starglas.dsremake.common.helpers.ModReference;

public class ItemRendererPaladinGlaive implements IItemRenderer {

	protected paladinglaive model;
	
	public ItemRendererPaladinGlaive(){
		model = new paladinglaive();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
			GL11.glPushMatrix();
			
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModReference.MODID,"textures/items/paladinglaivetexture.png"));
				
				GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
				GL11.glRotatef(4.0F, 0.0F, 0.0F, 0.0F);
				GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
								// X 	Y 		Z
				GL11.glTranslatef(0.3F, 0.0F, -0.5F);
				
				model.render((Entity)data[1],0.0F,0.0F,0.0F,0.0F,0.0F,0.0625F);
				
			GL11.glPopMatrix();
		default:
			break;
		}

	}

}
