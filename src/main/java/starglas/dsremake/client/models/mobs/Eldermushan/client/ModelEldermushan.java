package yourModPackage.client.models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

import yourModPackage.client.MCAClientLibrary.MCAModelRenderer;
import yourModPackage.common.MCACommonLibrary.MCAVersionChecker;
import yourModPackage.common.MCACommonLibrary.animation.AnimationHandler;
import yourModPackage.common.MCACommonLibrary.math.Matrix4f;
import yourModPackage.common.MCACommonLibrary.math.Quaternion;
import yourModPackage.common.entities.mobs.EntityEldermushan;

public class ModelEldermushan extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer body;
MCAModelRenderer lowercap;
MCAModelRenderer middlecap;
MCAModelRenderer uppercap;
MCAModelRenderer leftleg;
MCAModelRenderer rightleg;
MCAModelRenderer leftstache;
MCAModelRenderer rightstache;
MCAModelRenderer upperbeard;
MCAModelRenderer lowerbeard;
MCAModelRenderer leftbrow;
MCAModelRenderer rightbrow;

public ModelEldermushan()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 256;
textureHeight = 256;

body = new MCAModelRenderer(this, "body", 150, 0);
body.mirror = false;
body.addBox(0.0F, 0.0F, 0.0F, 20, 36, 20);
body.setInitialRotationPoint(-10.0F, -18.0F, -10.0F);
body.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
body.setTextureSize(256, 256);
parts.put(body.boxName, body);

lowercap = new MCAModelRenderer(this, "lowercap", 0, 36);
lowercap.mirror = false;
lowercap.addBox(0.0F, 0.0F, 0.0F, 36, 10, 36);
lowercap.setInitialRotationPoint(-18.0F, 18.0F, -18.0F);
lowercap.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
lowercap.setTextureSize(256, 256);
parts.put(lowercap.boxName, lowercap);

middlecap = new MCAModelRenderer(this, "middlecap", 18, 85);
middlecap.mirror = false;
middlecap.addBox(0.0F, 0.0F, 0.0F, 28, 5, 28);
middlecap.setInitialRotationPoint(-14.0F, 28.0F, -14.0F);
middlecap.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
middlecap.setTextureSize(256, 256);
parts.put(middlecap.boxName, middlecap);

uppercap = new MCAModelRenderer(this, "uppercap", 0, 130);
uppercap.mirror = false;
uppercap.addBox(0.0F, 0.0F, 0.0F, 18, 2, 18);
uppercap.setInitialRotationPoint(-9.0F, 33.0F, -9.0F);
uppercap.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
uppercap.setTextureSize(256, 256);
parts.put(uppercap.boxName, uppercap);

leftleg = new MCAModelRenderer(this, "leftleg", 0, 0);
leftleg.mirror = false;
leftleg.addBox(0.0F, 0.0F, 0.0F, 8, 14, 14);
leftleg.setInitialRotationPoint(1.0F, -31.0F, -7.0F);
leftleg.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
leftleg.setTextureSize(256, 256);
parts.put(leftleg.boxName, leftleg);

rightleg = new MCAModelRenderer(this, "rightleg", 0, 0);
rightleg.mirror = false;
rightleg.addBox(0.0F, 0.0F, 0.0F, 8, 14, 14);
rightleg.setInitialRotationPoint(-9.0F, -31.0F, -7.0F);
rightleg.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
rightleg.setTextureSize(256, 256);
parts.put(rightleg.boxName, rightleg);

leftstache = new MCAModelRenderer(this, "leftstache", 50, 0);
leftstache.mirror = false;
leftstache.addBox(0.0F, 0.0F, 0.0F, 6, 2, 1);
leftstache.setInitialRotationPoint(1.0F, 6.0F, 10.0F);
leftstache.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, -0.34202012F, 0.9396926F)).transpose());
leftstache.setTextureSize(256, 256);
parts.put(leftstache.boxName, leftstache);

rightstache = new MCAModelRenderer(this, "rightstache", 50, 0);
rightstache.mirror = false;
rightstache.addBox(0.0F, 0.0F, 0.0F, 6, 2, 1);
rightstache.setInitialRotationPoint(-1.0F, 6.0F, 11.0F);
rightstache.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.34202012F, 0.9396926F, 1.4950174E-8F, -4.1075268E-8F)).transpose());
rightstache.setTextureSize(256, 256);
parts.put(rightstache.boxName, rightstache);

upperbeard = new MCAModelRenderer(this, "upperbeard", 91, 0);
upperbeard.mirror = false;
upperbeard.addBox(0.0F, 0.0F, 0.0F, 4, 7, 1);
upperbeard.setInitialRotationPoint(-2.0F, -3.0F, 10.0F);
upperbeard.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
upperbeard.setTextureSize(256, 256);
parts.put(upperbeard.boxName, upperbeard);

lowerbeard = new MCAModelRenderer(this, "lowerbeard", 83, 0);
lowerbeard.mirror = false;
lowerbeard.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1);
lowerbeard.setInitialRotationPoint(-1.0F, -7.0F, 10.0F);
lowerbeard.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
lowerbeard.setTextureSize(256, 256);
parts.put(lowerbeard.boxName, lowerbeard);

leftbrow = new MCAModelRenderer(this, "leftbrow", 0, 200);
leftbrow.mirror = false;
leftbrow.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
leftbrow.setInitialRotationPoint(1.0F, 13.0F, 10.0F);
leftbrow.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, -0.3007058F, 0.95371693F)).transpose());
leftbrow.setTextureSize(256, 256);
parts.put(leftbrow.boxName, leftbrow);

rightbrow = new MCAModelRenderer(this, "rightbrow", 0, 200);
rightbrow.mirror = false;
rightbrow.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1);
rightbrow.setInitialRotationPoint(-1.0F, 13.0F, 11.0F);
rightbrow.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(-0.3007058F, 0.95371693F, 1.3144268E-8F, -4.1688292E-8F)).transpose());
rightbrow.setTextureSize(256, 256);
parts.put(rightbrow.boxName, rightbrow);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntityEldermushan entity = (EntityEldermushan)par1Entity;

AnimationHandler.performAnimationInModel(parts, entity);

//Render every non-child part
body.render(par7);
lowercap.render(par7);
middlecap.render(par7);
uppercap.render(par7);
leftleg.render(par7);
rightleg.render(par7);
leftstache.render(par7);
rightstache.render(par7);
upperbeard.render(par7);
lowerbeard.render(par7);
leftbrow.render(par7);
rightbrow.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}