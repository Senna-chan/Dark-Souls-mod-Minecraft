package starglas.dsremake.client.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.client.models.mobs.ModelDeadsapsprout;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.entity.mobs.creature.EntityDeadsapsprout;

public class RenderDeadsapsprout extends RenderLiving {

	public static final ResourceLocation Deadsapsprout_texture = new ResourceLocation(ModReference.MODID, "textures/mobs/deadsapsprout.png");
	public static ModelDeadsapsprout modelDeadsapsprout = new ModelDeadsapsprout();	
	public static float modelHeight = 4F;
	
	public RenderDeadsapsprout()
    {
        super(modelDeadsapsprout, 1F);
    }
	
	@Override
	public void doRender(Entity _entity, double posX, double posY, double posZ, float var8, float var9) {
		EntityDeadsapsprout entity = (EntityDeadsapsprout) _entity;
				
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		super.doRender(_entity, posX, posY, posZ, var8, var9);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f)
	{
		GL11.glRotatef(180F, 0, 1F, 0F);
		GL11.glRotatef(180F, 0, 0, 1F);
		GL11.glTranslatef(0, 3F, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return Deadsapsprout_texture;
	}
}