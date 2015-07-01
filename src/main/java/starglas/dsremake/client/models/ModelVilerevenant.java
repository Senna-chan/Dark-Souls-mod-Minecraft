package starglas.dsremake.client.models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import starglas.dsremake.client.MCAClientLibrary.MCAModelRenderer;
import starglas.dsremake.common.MCACommonLibrary.MCAVersionChecker;
import starglas.dsremake.common.MCACommonLibrary.animation.AnimationHandler;
import starglas.dsremake.common.MCACommonLibrary.math.Matrix4f;
import starglas.dsremake.common.MCACommonLibrary.math.Quaternion;
import starglas.dsremake.entity.mobs.trader.EntityVilerevenant;

public class ModelVilerevenant extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer bodyplate;
MCAModelRenderer tail;
MCAModelRenderer lowerbone;
MCAModelRenderer core;
MCAModelRenderer cloakbone;
MCAModelRenderer plate1;
MCAModelRenderer plate2;
MCAModelRenderer bellyplate;
MCAModelRenderer chestspike;
MCAModelRenderer chestridge;
MCAModelRenderer tailbone;
MCAModelRenderer tailspike;
MCAModelRenderer coreshard1;
MCAModelRenderer coreshard2;

public ModelVilerevenant()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 256;
textureHeight = 256;

bodyplate = new MCAModelRenderer(this, "bodyplate", 40, 0);
bodyplate.mirror = false;
bodyplate.addBox(0.0F, 0.0F, 0.0F, 10, 12, 1);
bodyplate.setInitialRotationPoint(4.0F, 3.0F, 5.0F);
bodyplate.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 1.0F, 0.0F, -4.371139E-8F)).transpose());
bodyplate.setTextureSize(256, 256);
parts.put(bodyplate.boxName, bodyplate);

tail = new MCAModelRenderer(this, "tail", 0, 20);
tail.mirror = false;
tail.addBox(0.0F, 0.0F, 0.0F, 10, 2, 4);
tail.setInitialRotationPoint(-3.0F, 2.0F, 0.0F);
tail.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.27059805F, 0.65328145F, 0.27059805F, 0.65328145F)).transpose());
tail.setTextureSize(256, 256);
parts.put(tail.boxName, tail);

lowerbone = new MCAModelRenderer(this, "lowerbone", 30, 20);
lowerbone.mirror = false;
lowerbone.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
lowerbone.setInitialRotationPoint(-2.0F, 3.0F, -1.0F);
lowerbone.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
lowerbone.setTextureSize(256, 256);
parts.put(lowerbone.boxName, lowerbone);

core = new MCAModelRenderer(this, "core", 40, 40);
core.mirror = false;
core.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3);
core.setInitialRotationPoint(-1.0F, 7.0F, 0.0F);
core.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.38268346F, 0.9238795F)).transpose());
core.setTextureSize(256, 256);
parts.put(core.boxName, core);

cloakbone = new MCAModelRenderer(this, "cloakbone", 60, 20);
cloakbone.mirror = false;
cloakbone.addBox(0.0F, 0.0F, 0.0F, 4, 1, 11);
cloakbone.setInitialRotationPoint(-3.0F, 9.0F, -7.0F);
cloakbone.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
cloakbone.setTextureSize(256, 256);
parts.put(cloakbone.boxName, cloakbone);

plate1 = new MCAModelRenderer(this, "plate1", 20, 0);
plate1.mirror = false;
plate1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5);
plate1.setInitialRotationPoint(6.0F, 11.0F, 1.0F);
plate1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
plate1.setTextureSize(256, 256);
parts.put(plate1.boxName, plate1);
bodyplate.addChild(plate1);

plate2 = new MCAModelRenderer(this, "plate2", 0, 0);
plate2.mirror = false;
plate2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5);
plate2.setInitialRotationPoint(0.0F, 11.0F, 1.0F);
plate2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
plate2.setTextureSize(256, 256);
parts.put(plate2.boxName, plate2);
bodyplate.addChild(plate2);

bellyplate = new MCAModelRenderer(this, "bellyplate", 65, 0);
bellyplate.mirror = false;
bellyplate.addBox(0.0F, 0.0F, 0.0F, 6, 9, 1);
bellyplate.setInitialRotationPoint(2.0F, 2.0F, -1.0F);
bellyplate.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
bellyplate.setTextureSize(256, 256);
parts.put(bellyplate.boxName, bellyplate);
bodyplate.addChild(bellyplate);

chestspike = new MCAModelRenderer(this, "chestspike", 80, 0);
chestspike.mirror = false;
chestspike.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
chestspike.setInitialRotationPoint(4.0F, 6.0F, -3.0F);
chestspike.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
chestspike.setTextureSize(256, 256);
parts.put(chestspike.boxName, chestspike);
bodyplate.addChild(chestspike);

chestridge = new MCAModelRenderer(this, "chestridge", 100, 0);
chestridge.mirror = false;
chestridge.addBox(0.0F, 0.0F, 0.0F, 4, 3, 2);
chestridge.setInitialRotationPoint(3.0F, 4.0F, -1.0F);
chestridge.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
chestridge.setTextureSize(256, 256);
parts.put(chestridge.boxName, chestridge);
bodyplate.addChild(chestridge);

tailbone = new MCAModelRenderer(this, "tailbone", 0, 30);
tailbone.mirror = false;
tailbone.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2);
tailbone.setInitialRotationPoint(6.0F, -5.0F, 1.0F);
tailbone.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.25881904F, 0.9659258F)).transpose());
tailbone.setTextureSize(256, 256);
parts.put(tailbone.boxName, tailbone);
tail.addChild(tailbone);

tailspike = new MCAModelRenderer(this, "tailspike", 0, 40);
tailspike.mirror = false;
tailspike.addBox(0.0F, 0.0F, 0.0F, 6, 1, 2);
tailspike.setInitialRotationPoint(6.0F, -5.0F, 1.0F);
tailspike.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
tailspike.setTextureSize(256, 256);
parts.put(tailspike.boxName, tailspike);
tail.addChild(tailspike);

coreshard1 = new MCAModelRenderer(this, "coreshard1", 40, 50);
coreshard1.mirror = false;
coreshard1.addBox(0.0F, 0.0F, 0.0F, 7, 4, 1);
coreshard1.setInitialRotationPoint(-2.0F, 3.0F, 1.0F);
coreshard1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, -0.38268346F, 0.9238795F)).transpose());
coreshard1.setTextureSize(256, 256);
parts.put(coreshard1.boxName, coreshard1);
core.addChild(coreshard1);

coreshard2 = new MCAModelRenderer(this, "coreshard2", 40, 60);
coreshard2.mirror = false;
coreshard2.addBox(0.0F, 0.0F, 0.0F, 7, 4, 1);
coreshard2.setInitialRotationPoint(1.0F, -2.0F, 1.0F);
coreshard2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.38268346F, 0.9238795F)).transpose());
coreshard2.setTextureSize(256, 256);
parts.put(coreshard2.boxName, coreshard2);
core.addChild(coreshard2);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntityVilerevenant entity = (EntityVilerevenant)par1Entity;

AnimationHandler.performAnimationInModel(parts, entity);

//Render every non-child part
bodyplate.render(par7);
tail.render(par7);
lowerbone.render(par7);
core.render(par7);
cloakbone.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}