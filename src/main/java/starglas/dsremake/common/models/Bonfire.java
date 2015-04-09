package starglas.dsremake.common.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Bonfire extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  
  public Bonfire()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 45, 0);
      Shape1.addBox(0F, 0F, 0F, 3, 1, 3);
      Shape1.setRotationPoint(-1F, 23F, -1F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 3, 1);
      Shape2.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape2.setRotationPoint(-4F, 23F, -2F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 1, 5);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 11);
      Shape3.setRotationPoint(-1F, 14F, 1F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, -1.167099F, 0.2230717F, 0F);
      Shape4 = new ModelRenderer(this, 26, 0);
      Shape4.addBox(0F, 0F, 0F, 1, 11, 1);
      Shape4.setRotationPoint(0F, 15F, 0F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, -0.2040693F, -0.137251F, 0.5334098F);
      Shape5 = new ModelRenderer(this, 31, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 10, 1);
      Shape5.setRotationPoint(-1F, 15F, 0F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, -0.5205006F, -1.152537F, 0.0371786F);
      Shape6 = new ModelRenderer(this, 42, 8);
      Shape6.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape6.setRotationPoint(-3F, 23F, 1F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, -0.1115358F, -0.669215F, 0F);
      Shape7 = new ModelRenderer(this, 36, 0);
      Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape7.setRotationPoint(-2F, 23F, -3F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

public void renderModel(float f) {
	Shape1.render(f);
    Shape2.render(f);
    Shape3.render(f);
    Shape4.render(f);
    Shape5.render(f);
    Shape6.render(f);
    Shape7.render(f);
}

}
