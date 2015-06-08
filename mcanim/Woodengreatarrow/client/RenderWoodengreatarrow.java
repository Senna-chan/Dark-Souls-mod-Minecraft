package yourModPackage.client.renders;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import yourModPackage.common.entities.mobs.EntityWoodengreatarrow;

public class RenderWoodengreatarrow extends Render {

	public static final ResourceLocation Woodengreatarrow_texture = new ResourceLocation("yourAssetsFolder", "textures/models/Woodengreatarrow.png");
	public static ModelWoodengreatarrow modelWoodengreatarrow;	
	
	public RenderWoodengreatarrow()
    {
        this.modelWoodengreatarrow = new ModelWoodengreatarrow();
    }
	
	@Override
	public void doRender(Entity _entity, double posX, double posY, double posZ, float var8, float var9) {
		EntityWoodengreatarrow entity = (EntityWoodengreatarrow) _entity;
				
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef((float)posX, (float)posY, (float)posZ);
		this.bindEntityTexture(entity);
		this.modelWoodengreatarrow.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return Woodengreatarrow_texture;
	}
}