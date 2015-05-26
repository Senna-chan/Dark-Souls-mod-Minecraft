package starglas.dsremake.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.Bonfire;
import starglas.dsremake.common.helpers.ModReference;

public class BlockRendererBonfire extends TileEntitySpecialRenderer{
	
	private static final ResourceLocation texture = new ResourceLocation(ModReference.MODID, "textures/blocks/bonfiretexture.png");
	
	public Bonfire model;

	public BlockRendererBonfire(){
		this.model = new Bonfire();
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + 3F, (float)z + 0.4F);
			GL11.glRotatef(180F, 0F, 0F, 1F);
			GL11.glScalef(2F, 2F, 2F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
