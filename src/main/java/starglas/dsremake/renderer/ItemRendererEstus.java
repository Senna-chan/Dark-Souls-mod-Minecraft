package starglas.dsremake.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.common.block.TileEntityEstus;
import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.models.ModelEstus;

public class ItemRendererEstus implements IItemRenderer {

	public ModelEstus model;
	
	public ItemRendererEstus(){
		model = new ModelEstus();
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
			
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID,"textures/items/estustexture.png"));
				
				GL11.glRotatef(80.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
				
				GL11.glTranslatef(0.2F, -0.5F, 0.65F);
				
				GL11.glScalef(0.3F, 0.3F, 0.3F);
				model.render((Entity)data[1],0.0F,0.0F,0.0F,0.0F,0.0F,0.0625F);
				
			GL11.glPopMatrix();
		default:
			break;
		}

	}

}
