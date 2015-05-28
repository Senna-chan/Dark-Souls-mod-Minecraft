package yourModPackage.client.models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

import yourModPackage.client.MCAClientLibrary.MCAModelRenderer;
import yourModPackage.common.MCACommonLibrary.MCAVersionChecker;
import yourModPackage.common.MCACommonLibrary.animation.AnimationHandler;
import yourModPackage.common.MCACommonLibrary.math.Matrix4f;
import yourModPackage.common.MCACommonLibrary.math.Quaternion;
import yourModPackage.common.entities.mobs.EntityDeadsapsprout;

public class ModelDeadsapsprout extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer innerbud;
MCAModelRenderer outerbud;
MCAModelRenderer middlebud;
MCAModelRenderer top;
MCAModelRenderer flowertop;
MCAModelRenderer attenae1;
MCAModelRenderer attenae2;
MCAModelRenderer attenae3;
MCAModelRenderer leaf1;
MCAModelRenderer leaf2;
MCAModelRenderer leaf3;
MCAModelRenderer leaf4;
MCAModelRenderer root;
MCAModelRenderer roottip;
MCAModelRenderer leaftip1;
MCAModelRenderer leaftip2;
MCAModelRenderer leaftip3;
MCAModelRenderer leaftip4;

public ModelDeadsapsprout()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 64;
textureHeight = 64;

innerbud = new MCAModelRenderer(this, "innerbud", 0, 0);
innerbud.mirror = false;
innerbud.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5);
innerbud.setInitialRotationPoint(0.0F, 0.0F, 0.0F);
innerbud.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
innerbud.setTextureSize(64, 64);
parts.put(innerbud.boxName, innerbud);

outerbud = new MCAModelRenderer(this, "outerbud", 0, 0);
outerbud.mirror = false;
outerbud.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5);
outerbud.setInitialRotationPoint(2.0F, 0.0F, -1.0F);
outerbud.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, -0.25881904F, 0.0F, 0.9659258F)).transpose());
outerbud.setTextureSize(64, 64);
parts.put(outerbud.boxName, outerbud);

middlebud = new MCAModelRenderer(this, "middlebud", 0, 0);
middlebud.mirror = false;
middlebud.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5);
middlebud.setInitialRotationPoint(4.0F, 0.0F, -1.0F);
middlebud.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, -0.5F, 0.0F, 0.8660254F)).transpose());
middlebud.setTextureSize(64, 64);
parts.put(middlebud.boxName, middlebud);

top = new MCAModelRenderer(this, "top", 20, 10);
top.mirror = false;
top.addBox(0.0F, 0.0F, 0.0F, 4, 1, 3);
top.setInitialRotationPoint(1.0F, 6.0F, 1.0F);
top.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
top.setTextureSize(64, 64);
parts.put(top.boxName, top);

flowertop = new MCAModelRenderer(this, "flowertop", 20, 0);
flowertop.mirror = false;
flowertop.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
flowertop.setInitialRotationPoint(2.0F, 7.0F, 2.0F);
flowertop.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
flowertop.setTextureSize(64, 64);
parts.put(flowertop.boxName, flowertop);

attenae1 = new MCAModelRenderer(this, "attenae1", 30, 0);
attenae1.mirror = false;
attenae1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
attenae1.setInitialRotationPoint(1.0F, 5.0F, 2.0F);
attenae1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.5F, 0.8660254F)).transpose());
attenae1.setTextureSize(64, 64);
parts.put(attenae1.boxName, attenae1);

attenae2 = new MCAModelRenderer(this, "attenae2", 30, 0);
attenae2.mirror = false;
attenae2.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
attenae2.setInitialRotationPoint(4.0F, 5.0F, 4.0F);
attenae2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.43301272F, 0.75F, 0.24999999F, 0.43301266F)).transpose());
attenae2.setTextureSize(64, 64);
parts.put(attenae2.boxName, attenae2);

attenae3 = new MCAModelRenderer(this, "attenae3", 30, 0);
attenae3.mirror = false;
attenae3.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
attenae3.setInitialRotationPoint(5.0F, 5.0F, 1.0F);
attenae3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.43301272F, -0.75F, 0.24999999F, 0.43301266F)).transpose());
attenae3.setTextureSize(64, 64);
parts.put(attenae3.boxName, attenae3);

leaf1 = new MCAModelRenderer(this, "leaf1", 20, 20);
leaf1.mirror = false;
leaf1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 10);
leaf1.setInitialRotationPoint(1.0F, 0.0F, 3.0F);
leaf1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leaf1.setTextureSize(64, 64);
parts.put(leaf1.boxName, leaf1);

leaf2 = new MCAModelRenderer(this, "leaf2", 20, 20);
leaf2.mirror = false;
leaf2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 10);
leaf2.setInitialRotationPoint(4.0F, 0.0F, 4.0F);
leaf2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.70710677F, 0.0F, 0.70710677F)).transpose());
leaf2.setTextureSize(64, 64);
parts.put(leaf2.boxName, leaf2);

leaf3 = new MCAModelRenderer(this, "leaf3", 20, 20);
leaf3.mirror = false;
leaf3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 10);
leaf3.setInitialRotationPoint(5.0F, 0.0F, 1.0F);
leaf3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 1.0F, 0.0F, -4.371139E-8F)).transpose());
leaf3.setTextureSize(64, 64);
parts.put(leaf3.boxName, leaf3);

leaf4 = new MCAModelRenderer(this, "leaf4", 20, 20);
leaf4.mirror = false;
leaf4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 10);
leaf4.setInitialRotationPoint(2.0F, 0.0F, 0.0F);
leaf4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, -0.70710677F, 0.0F, 0.70710677F)).transpose());
leaf4.setTextureSize(64, 64);
parts.put(leaf4.boxName, leaf4);

root = new MCAModelRenderer(this, "root", 0, 30);
root.mirror = false;
root.addBox(0.0F, 0.0F, 0.0F, 4, 2, 4);
root.setInitialRotationPoint(1.0F, -2.0F, 0.0F);
root.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
root.setTextureSize(64, 64);
parts.put(root.boxName, root);

roottip = new MCAModelRenderer(this, "roottip", 0, 40);
roottip.mirror = false;
roottip.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2);
roottip.setInitialRotationPoint(2.0F, -5.0F, 1.0F);
roottip.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
roottip.setTextureSize(64, 64);
parts.put(roottip.boxName, roottip);

leaftip1 = new MCAModelRenderer(this, "leaftip1", 20, 40);
leaftip1.mirror = false;
leaftip1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
leaftip1.setInitialRotationPoint(1.0F, 0.0F, 10.0F);
leaftip1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leaftip1.setTextureSize(64, 64);
parts.put(leaftip1.boxName, leaftip1);
leaf1.addChild(leaftip1);

leaftip2 = new MCAModelRenderer(this, "leaftip2", 20, 40);
leaftip2.mirror = false;
leaftip2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
leaftip2.setInitialRotationPoint(1.0F, 0.0F, 10.0F);
leaftip2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leaftip2.setTextureSize(64, 64);
parts.put(leaftip2.boxName, leaftip2);
leaf2.addChild(leaftip2);

leaftip3 = new MCAModelRenderer(this, "leaftip3", 20, 40);
leaftip3.mirror = false;
leaftip3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
leaftip3.setInitialRotationPoint(1.0F, 0.0F, 10.0F);
leaftip3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leaftip3.setTextureSize(64, 64);
parts.put(leaftip3.boxName, leaftip3);
leaf3.addChild(leaftip3);

leaftip4 = new MCAModelRenderer(this, "leaftip4", 20, 40);
leaftip4.mirror = false;
leaftip4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
leaftip4.setInitialRotationPoint(1.0F, 0.0F, 10.0F);
leaftip4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leaftip4.setTextureSize(64, 64);
parts.put(leaftip4.boxName, leaftip4);
leaf4.addChild(leaftip4);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntityDeadsapsprout entity = (EntityDeadsapsprout)par1Entity;

AnimationHandler.performAnimationInModel(parts, entity);

//Render every non-child part
innerbud.render(par7);
outerbud.render(par7);
middlebud.render(par7);
top.render(par7);
flowertop.render(par7);
attenae1.render(par7);
attenae2.render(par7);
attenae3.render(par7);
leaf1.render(par7);
leaf2.render(par7);
leaf3.render(par7);
leaf4.render(par7);
root.render(par7);
roottip.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}