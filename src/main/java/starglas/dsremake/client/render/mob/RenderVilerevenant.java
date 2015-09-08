package starglas.dsremake.client.render.mob;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.client.models.mobs.ModelVilerevenant;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.mobs.trader.EntityVilerevenant;

public class RenderVilerevenant extends RenderLiving {

	public static final ResourceLocation Vilerevenant_texture = new ResourceLocation(ModVars.MODID, "textures/mobs/vilerevenanttexture.png");
	public static ModelVilerevenant modelVilerevenant = new ModelVilerevenant();	
	public static float modelHeight = 2F;
	
	public RenderVilerevenant()
    {
        super(modelVilerevenant, 1F);
    }
	
	@Override
	public void doRender(Entity _entity, double posX, double posY, double posZ, float var8, float var9) {
		EntityVilerevenant entity = (EntityVilerevenant) _entity;
				
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
		GL11.glTranslatef(0, 2.5F, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return Vilerevenant_texture;
	}
}