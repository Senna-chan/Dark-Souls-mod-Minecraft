package starglas.dsremake.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.items.ModelEstus;
import starglas.dsremake.common.helpers.ModReference;

public class ItemRendererEstus implements IItemRenderer {

	public ModelEstus model;
	
	public ItemRendererEstus(){
		model = new ModelEstus();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return helper != ItemRendererHelper.EQUIPPED_BLOCK;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModReference.MODID,"textures/items/estustexture.png"));
			
			if(type==ItemRenderType.EQUIPPED){
				GL11.glTranslatef(0.4F, 0.3F, 0.2F);
				GL11.glRotatef(80.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(0.3F, 0.3F, 0.3F);
			}
			else if(type==ItemRenderType.EQUIPPED_FIRST_PERSON){
				GL11.glTranslatef(1.0F, 0.2F, 0.8F);
				GL11.glRotatef(200, 0, 0, 1);
				GL11.glScalef(0.3F, 0.3F, 0.3F);
			}
			else if(type==ItemRenderType.INVENTORY){
				GL11.glTranslatef(1.0F, 1F, 1.0F);
				GL11.glRotatef(180, 0, 0, 1);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
			}
			else if(type==ItemRenderType.ENTITY){
				GL11.glTranslatef(0, 0.5F, 0);
				GL11.glScalef(0.3F, 0.3F, 0.3F);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 0, 1);
			}
			else{
				
			}
			model.renderModel(0.0625F);
			
		GL11.glPopMatrix();
	}
}