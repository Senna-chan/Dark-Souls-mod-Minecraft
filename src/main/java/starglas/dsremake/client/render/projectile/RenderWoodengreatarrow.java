package starglas.dsremake.client.render.projectile;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.client.models.entities.ModelWoodengreatarrow;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.projectiles.arrows.EntityWoodengreatarrow;

public class RenderWoodengreatarrow extends Render {

	public static final ResourceLocation Woodengreatarrow_texture = new ResourceLocation(ModVars.MODID, "textures/items/Woodengreatarrow.png");
	public static ModelWoodengreatarrow modelWoodengreatarrow;	
	
	public RenderWoodengreatarrow()
    {
        modelWoodengreatarrow = new ModelWoodengreatarrow();
    }
	
	@Override
	public void doRender(Entity _entity, double posX, double posY, double posZ, float var8, float var9) {
		EntityWoodengreatarrow entity = (EntityWoodengreatarrow) _entity;
				
		GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_CULL_FACE);
			//GL11.glRotatef(-90, 0, 0, 1);
			GL11.glTranslatef((float) posX, (float) posY, (float) posZ);
			GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * var9 - 90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * var9 - 90F, 0.0F, 0.0F, 1.0F);


			this.bindEntityTexture(entity);
			modelWoodengreatarrow.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return Woodengreatarrow_texture;
	}
}