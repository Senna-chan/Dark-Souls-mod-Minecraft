package starglas.dsremake.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.ModelSanctifiedgreathammer;
import starglas.dsremake.common.helpers.ModReference;

public class ItemRendererSancitiedGreatHammer implements IItemRenderer {

	public ModelSanctifiedgreathammer model;
	
	public ItemRendererSancitiedGreatHammer(){
		model = new ModelSanctifiedgreathammer();
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
		
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModReference.MODID,"textures/items/Sanctifiedgreathammertexture.png"));
			if(type==ItemRenderType.EQUIPPED){
				GL11.glRotatef(270, 0, 1, 0);
				GL11.glRotatef(30, 1, 0, 0);
				GL11.glRotatef(-30, 0, 0, 1);
				GL11.glTranslatef(-1.5F, 0.25F, -0.9F);
				GL11.glScalef(0.2F, 0.2F, 0.2F);
			}
			else if(type==ItemRenderType.EQUIPPED_FIRST_PERSON){
				GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(30F, 0, 0, 1);
				GL11.glTranslatef(-1.1F, -0.4F, -0.0F);
				GL11.glScalef(0.2F, 0.2F, 0.2F);
			}
			else if(type==ItemRenderType.INVENTORY){
				GL11.glTranslatef(0.0F, 0.5F, 0.0F);
				GL11.glRotatef(270, 0, 1, 0);
				GL11.glRotatef(30, 1, 0, 0);
				GL11.glRotatef(-30, 0, 0, 1);
				GL11.glScalef(0.1F, 0.1F, 0.1F);
			}
			else if(type==ItemRenderType.ENTITY){
				GL11.glTranslatef(0.0F, 1.5F, 0.0F);
				GL11.glRotatef(270, 0, 1, 0);
				GL11.glRotatef(30, 1, 0, 0);
				GL11.glRotatef(-30, 0, 0, 1);
				GL11.glScalef(0.2F, 0.2F, 0.2F);
			}
			model.renderModel(0.0625F);	
		GL11.glPopMatrix();
	}
}
