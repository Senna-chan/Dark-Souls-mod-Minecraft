package starglas.dsremake.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.common.helpers.Reference;
import assets.dsremake.models.Bonfire;

public class RendererBonfire extends TileEntitySpecialRenderer{
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/blocks/bonfiretexture.png");
	
	public Bonfire model;

	public RendererBonfire(){
		this.model = new Bonfire();
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180F, 0F, 0F, 1F);
			GL11.glScalef(1F, 1F, 1F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
