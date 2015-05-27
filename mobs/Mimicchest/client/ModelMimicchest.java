package yourModPackage.client.models;

import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

import yourModPackage.client.MCAClientLibrary.MCAModelRenderer;
import yourModPackage.common.MCACommonLibrary.MCAVersionChecker;
import yourModPackage.common.MCACommonLibrary.animation.AnimationHandler;
import yourModPackage.common.MCACommonLibrary.math.Matrix4f;
import yourModPackage.common.MCACommonLibrary.math.Quaternion;
import yourModPackage.common.entities.mobs.EntityMimicchest;

public class ModelMimicchest extends ModelBase {
public final int MCA_MIN_REQUESTED_VERSION = 5;
public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

MCAModelRenderer shape1;
MCAModelRenderer shape2;
MCAModelRenderer shape3;
MCAModelRenderer shape4;
MCAModelRenderer shape5;
MCAModelRenderer shape6;
MCAModelRenderer shape7;
MCAModelRenderer shape8;
MCAModelRenderer shape9;
MCAModelRenderer shape10;
MCAModelRenderer shape11;
MCAModelRenderer shape12;
MCAModelRenderer shape13;
MCAModelRenderer shape14;
MCAModelRenderer shape15;
MCAModelRenderer shape16;
MCAModelRenderer shape17;
MCAModelRenderer shape18;
MCAModelRenderer shape19;
MCAModelRenderer shape20;
MCAModelRenderer shape21;
MCAModelRenderer shape22;

public ModelMimicchest()
{
MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

textureWidth = 512;
textureHeight = 512;

shape1 = new MCAModelRenderer(this, "Shape1", 0, 0);
shape1.mirror = false;
shape1.addBox(0.0F, -20.0F, -3.0F, 40, 20, 3);
shape1.setInitialRotationPoint(-20.0F, 2.0F, -4.0F);
shape1.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape1.setTextureSize(512, 512);
parts.put(shape1.boxName, shape1);

shape2 = new MCAModelRenderer(this, "Shape2", 0, 42);
shape2.mirror = false;
shape2.addBox(0.0F, -6.0F, -20.0F, 40, 6, 20);
shape2.setInitialRotationPoint(-20.0F, -12.0F, 16.0F);
shape2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape2.setTextureSize(512, 512);
parts.put(shape2.boxName, shape2);

shape3 = new MCAModelRenderer(this, "Shape3", 0, 0);
shape3.mirror = false;
shape3.addBox(0.0F, -20.0F, -3.0F, 40, 20, 3);
shape3.setInitialRotationPoint(-20.0F, 2.0F, 19.0F);
shape3.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape3.setTextureSize(512, 512);
parts.put(shape3.boxName, shape3);

shape4 = new MCAModelRenderer(this, "Shape4", 155, 0);
shape4.mirror = false;
shape4.addBox(0.0F, -20.0F, -20.0F, 3, 20, 20);
shape4.setInitialRotationPoint(-23.0F, 2.0F, 16.0F);
shape4.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape4.setTextureSize(512, 512);
parts.put(shape4.boxName, shape4);

shape5 = new MCAModelRenderer(this, "Shape5", 155, 0);
shape5.mirror = false;
shape5.addBox(0.0F, -20.0F, -20.0F, 3, 20, 20);
shape5.setInitialRotationPoint(20.0F, 2.0F, 16.0F);
shape5.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape5.setTextureSize(512, 512);
parts.put(shape5.boxName, shape5);

shape6 = new MCAModelRenderer(this, "Shape6", 125, 0);
shape6.mirror = false;
shape6.addBox(0.0F, -20.0F, -5.0F, 5, 20, 5);
shape6.setInitialRotationPoint(20.0F, 2.0F, -4.0F);
shape6.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape6.setTextureSize(512, 512);
parts.put(shape6.boxName, shape6);

shape7 = new MCAModelRenderer(this, "Shape7", 125, 0);
shape7.mirror = false;
shape7.addBox(0.0F, -20.0F, -5.0F, 5, 20, 5);
shape7.setInitialRotationPoint(-25.0F, 2.0F, -4.0F);
shape7.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape7.setTextureSize(512, 512);
parts.put(shape7.boxName, shape7);

shape8 = new MCAModelRenderer(this, "Shape8", 125, 0);
shape8.mirror = false;
shape8.addBox(0.0F, -20.0F, -5.0F, 5, 20, 5);
shape8.setInitialRotationPoint(20.0F, 2.0F, 21.0F);
shape8.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape8.setTextureSize(512, 512);
parts.put(shape8.boxName, shape8);

shape9 = new MCAModelRenderer(this, "Shape9", 125, 0);
shape9.mirror = false;
shape9.addBox(0.0F, -20.0F, -5.0F, 5, 20, 5);
shape9.setInitialRotationPoint(-25.0F, 2.0F, 21.0F);
shape9.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape9.setTextureSize(512, 512);
parts.put(shape9.boxName, shape9);

shape10 = new MCAModelRenderer(this, "Shape10", 204, 0);
shape10.mirror = false;
shape10.addBox(0.0F, -12.0F, -12.0F, 3, 12, 12);
shape10.setInitialRotationPoint(21.0F, 2.0F, 10.0F);
shape10.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
shape10.setTextureSize(512, 512);
parts.put(shape10.boxName, shape10);

shape11 = new MCAModelRenderer(this, "Shape11", 204, 0);
shape11.mirror = false;
shape11.addBox(0.0F, -12.0F, -12.0F, 3, 12, 12);
shape11.setInitialRotationPoint(21.0F, 2.0F, 19.0F);
shape11.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
shape11.setTextureSize(512, 512);
parts.put(shape11.boxName, shape11);

shape12 = new MCAModelRenderer(this, "Shape12", 204, 0);
shape12.mirror = false;
shape12.addBox(0.0F, -12.0F, -12.0F, 3, 12, 12);
shape12.setInitialRotationPoint(-24.0F, 2.0F, 19.0F);
shape12.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
shape12.setTextureSize(512, 512);
parts.put(shape12.boxName, shape12);

shape13 = new MCAModelRenderer(this, "Shape13", 204, 0);
shape13.mirror = false;
shape13.addBox(0.0F, -12.0F, -12.0F, 3, 12, 12);
shape13.setInitialRotationPoint(-24.0F, 2.0F, 10.0F);
shape13.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
shape13.setTextureSize(512, 512);
parts.put(shape13.boxName, shape13);

shape14 = new MCAModelRenderer(this, "Shape14", 237, 0);
shape14.mirror = false;
shape14.addBox(0.0F, -8.0F, -9.0F, 4, 8, 9);
shape14.setInitialRotationPoint(21.0F, 10.5F, 10.5F);
shape14.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape14.setTextureSize(512, 512);
parts.put(shape14.boxName, shape14);

shape15 = new MCAModelRenderer(this, "Shape15", 237, 0);
shape15.mirror = false;
shape15.addBox(0.0F, -8.0F, -9.0F, 4, 8, 9);
shape15.setInitialRotationPoint(-25.0F, 10.5F, 10.5F);
shape15.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape15.setTextureSize(512, 512);
parts.put(shape15.boxName, shape15);

shape16 = new MCAModelRenderer(this, "Shape16", 0, 70);
shape16.mirror = false;
shape16.addBox(0.0F, -3.0F, -20.0F, 4, 4, 22);
shape16.setInitialRotationPoint(21.0F, 1.0F, 15.0F);
shape16.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape16.setTextureSize(512, 512);
parts.put(shape16.boxName, shape16);

shape17 = new MCAModelRenderer(this, "Shape17", 0, 70);
shape17.mirror = false;
shape17.addBox(0.0F, -3.0F, -20.0F, 4, 4, 22);
shape17.setInitialRotationPoint(-25.0F, 1.0F, 15.0F);
shape17.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape17.setTextureSize(512, 512);
parts.put(shape17.boxName, shape17);

shape18 = new MCAModelRenderer(this, "Shape18", 204, 40);
shape18.mirror = false;
shape18.addBox(0.0F, -11.0F, -11.0F, 42, 11, 3);
shape18.setInitialRotationPoint(-21.0F, 2.0F, 10.0F);
shape18.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
shape18.setTextureSize(512, 512);
parts.put(shape18.boxName, shape18);

shape19 = new MCAModelRenderer(this, "Shape19", 204, 40);
shape19.mirror = false;
shape19.addBox(0.0F, -11.0F, -11.0F, 42, 3, 11);
shape19.setInitialRotationPoint(-21.0F, 8.0F, 23.0F);
shape19.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.38268346F, 0.0F, 0.0F, 0.9238795F)).transpose());
shape19.setTextureSize(512, 512);
parts.put(shape19.boxName, shape19);

shape20 = new MCAModelRenderer(this, "Shape20", 237, 64);
shape20.mirror = false;
shape20.addBox(0.0F, -7.0F, -7.0F, 42, 7, 7);
shape20.setInitialRotationPoint(-21.0F, 9.5F, 9.5F);
shape20.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape20.setTextureSize(512, 512);
parts.put(shape20.boxName, shape20);

shape21 = new MCAModelRenderer(this, "Shape21", 50, 80);
shape21.mirror = false;
shape21.addBox(0.0F, -8.0F, -1.0F, 12, 8, 1);
shape21.setInitialRotationPoint(-6.0F, 0.0F, 20.0F);
shape21.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape21.setTextureSize(512, 512);
parts.put(shape21.boxName, shape21);

shape22 = new MCAModelRenderer(this, "Shape22", 58, 28);
shape22.mirror = false;
shape22.addBox(0.0F, -6.0F, -1.0F, 6, 6, 1);
shape22.setInitialRotationPoint(-3.0F, -1.0F, 21.0F);
shape22.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
shape22.setTextureSize(512, 512);
parts.put(shape22.boxName, shape22);

}

@Override
public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) 
{
EntityMimicchest entity = (EntityMimicchest)par1Entity;

AnimationHandler.performAnimationInModel(parts, entity);

//Render every non-child part
shape1.render(par7);
shape2.render(par7);
shape3.render(par7);
shape4.render(par7);
shape5.render(par7);
shape6.render(par7);
shape7.render(par7);
shape8.render(par7);
shape9.render(par7);
shape10.render(par7);
shape11.render(par7);
shape12.render(par7);
shape13.render(par7);
shape14.render(par7);
shape15.render(par7);
shape16.render(par7);
shape17.render(par7);
shape18.render(par7);
shape19.render(par7);
shape20.render(par7);
shape21.render(par7);
shape22.render(par7);
}
@Override
public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {}

public MCAModelRenderer getModelRendererFromName(String name)
{
return parts.get(name);
}
}