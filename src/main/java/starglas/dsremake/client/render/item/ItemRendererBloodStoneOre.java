package starglas.dsremake.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.client.models.blocks.bloodstoneore;
import starglas.dsremake.common.helpers.ModVars;

public class ItemRendererBloodStoneOre implements IItemRenderer {

	public bloodstoneore model;
	
	public ItemRendererBloodStoneOre(){
		model = new bloodstoneore();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModVars.MODID,"textures/blocks/bloodstoneoretexture.png"));
			if(type==ItemRenderType.EQUIPPED){
				GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			}
			else if(type==ItemRenderType.EQUIPPED_FIRST_PERSON){
				
			}
			else if(type==ItemRenderType.INVENTORY){
				
			}
			else if(type==ItemRenderType.ENTITY){
				
			}
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glTranslatef(0, -1, 0);
			model.renderAll(0.0625F);
		GL11.glPopMatrix();
	}
}
