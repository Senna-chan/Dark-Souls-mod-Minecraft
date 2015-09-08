package starglas.dsremake.client.models.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import starglas.dsremake.client.MCAClientLibrary.MCAModelRenderer;
import starglas.dsremake.common.MCACommonLibrary.MCAVersionChecker;
import starglas.dsremake.common.MCACommonLibrary.math.Matrix4f;
import starglas.dsremake.common.MCACommonLibrary.math.Quaternion;
import starglas.dsremake.entity.projectiles.arrows.EntityWoodengreatarrow;

import java.util.HashMap;

public class ModelWoodengreatarrow extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer base;
MCAModelRenderer broadhead;
MCAModelRenderer spike1;
MCAModelRenderer spike2;
MCAModelRenderer headspike;
MCAModelRenderer woodfletch1;
MCAModelRenderer woodfletch2;

public ModelWoodengreatarrow()
{
    MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

    textureWidth = 32;
    textureHeight = 32;

    base = new MCAModelRenderer(this, "Base", 0, 0);
    base.mirror = false;
    base.addBox(0.0F, 0.0F, 0.0F, 3, 20, 3);
    base.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
    base.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
    base.setTextureSize(32, 32);
    parts.put(base.boxName, base);

    broadhead = new MCAModelRenderer(this, "Broadhead", 12, 8);
    broadhead.mirror = false;
    broadhead.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5);
    broadhead.setInitialRotationPoint(-1.0F, 20.0F, -1.0F);
    broadhead.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
    broadhead.setTextureSize(32, 32);
    parts.put(broadhead.boxName, broadhead);
    base.addChild(broadhead);

    spike1 = new MCAModelRenderer(this, "spike1", 16, 21);
    spike1.mirror = false;
    spike1.addBox(0.0F, 0.0F, 0.0F, 5, 7, 3);
    spike1.setInitialRotationPoint(-1.0F, 23.0F, 3.0F);
    spike1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.19936793F, 0.0F, 0.0F, 0.9799247F)).transpose());
    spike1.setTextureSize(32, 32);
    parts.put(spike1.boxName, spike1);
    base.addChild(spike1);

    spike2 = new MCAModelRenderer(this, "spike2", 16, 21);
    spike2.mirror = false;
    spike2.addBox(0.0F, 0.0F, 0.0F, 5, 7, 3);
    spike2.setInitialRotationPoint(-1.0F, 24.0F, -3.0F);
    spike2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.25881904F, 0.0F, 0.0F, 0.9659258F)).transpose());
    spike2.setTextureSize(32, 32);
    parts.put(spike2.boxName, spike2);
    base.addChild(spike2);

    headspike = new MCAModelRenderer(this, "headspike", 19, 0);
    headspike.mirror = false;
    headspike.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
    headspike.setInitialRotationPoint(0.0F, 28.0F, 2.0F);
    headspike.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
    headspike.setTextureSize(32, 32);
    parts.put(headspike.boxName, headspike);
    base.addChild(headspike);

    woodfletch1 = new MCAModelRenderer(this, "woodfletch1", 0, 28);
    woodfletch1.mirror = false;
    woodfletch1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
    woodfletch1.setInitialRotationPoint(0.0F, -2.0F, 0.0F);
    woodfletch1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.5F, 0.0F, 0.0F, 0.8660254F)).transpose());
    woodfletch1.setTextureSize(32, 32);
    parts.put(woodfletch1.boxName, woodfletch1);
    base.addChild(woodfletch1);

    woodfletch2 = new MCAModelRenderer(this, "woodfletch2", 0, 24);
    woodfletch2.mirror = true;
    woodfletch2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1);
    woodfletch2.setInitialRotationPoint(0.0F, -2.0F, 3.0F);
    woodfletch2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.25881904F, 0.0F, 0.0F, 0.9659258F)).transpose());
    woodfletch2.setTextureSize(32, 32);
    parts.put(woodfletch2.boxName, woodfletch2);
    base.addChild(woodfletch2);

    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    EntityWoodengreatarrow entity = (EntityWoodengreatarrow)par1Entity;

    //Render every non-child part
    base.render(par7);
    }
    public void renderModel(float par7){
            base.render(par7);
        }
    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

    public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}