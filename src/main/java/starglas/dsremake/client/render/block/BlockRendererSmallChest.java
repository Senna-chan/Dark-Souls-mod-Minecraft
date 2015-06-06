package starglas.dsremake.client.render.block;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.blocks.smallchest_OLD;
import starglas.dsremake.common.helpers.ModReference;

public class BlockRendererSmallChest extends TileEntitySpecialRenderer{
	
	private static final ResourceLocation texture = new ResourceLocation(ModReference.MODID, "textures/blocks/Mimicchestfinal.png");
	
	public smallchest_OLD model;

	public BlockRendererSmallChest(){
		this.model = new smallchest_OLD();
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.225F,(float)y + 0.625F, (float)z + 0.6F);
			GL11.glRotatef(180F, 0F, 0F, 1F);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				model.renderAll(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
