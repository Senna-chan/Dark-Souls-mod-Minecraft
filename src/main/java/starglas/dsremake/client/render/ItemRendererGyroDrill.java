package starglas.dsremake.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.ModelGyrodrill;
import starglas.dsremake.common.helpers.Reference;

public class ItemRendererGyroDrill implements IItemRenderer {

	public ModelGyrodrill model;
	
	public ItemRendererGyroDrill(){
		model = new ModelGyrodrill();
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
		
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID,"textures/items/gyrodrilltexture.png"));
			if(type==ItemRenderType.EQUIPPED){
				GL11.glTranslatef(0.98F, -0.20F, 0.25F);
				GL11.glRotatef(15F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(30F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(0.3F, 0.3F, 0.3F);
			}
			else if(type==ItemRenderType.EQUIPPED_FIRST_PERSON){
				GL11.glTranslatef(1.0F, 0.2F, 0.8F);
				GL11.glRotatef(180, 0, 0, 1);
				GL11.glScalef(0.3F, 0.3F, 0.3F);
			}
			else if(type==ItemRenderType.INVENTORY){
				
				GL11.glScalef(0.3F, 0.3F, 0.3F);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 0, 1);
			}
			else if(type==ItemRenderType.ENTITY){
				GL11.glTranslatef(0, 0.5F, 0);
				GL11.glScalef(0.3F, 0.3F, 0.3F);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 0, 1);
			}
			else{
				
			}
			/*GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			
			*/
			
			model.renderModel(0.0625F);
			
		GL11.glPopMatrix();
	}

}
