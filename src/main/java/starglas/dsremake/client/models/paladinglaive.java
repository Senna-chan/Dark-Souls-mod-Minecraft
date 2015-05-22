package starglas.dsremake.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class paladinglaive extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
  
  public paladinglaive()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 17, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 28, 1);
      Shape1.setRotationPoint(1F, -11F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0.7853982F, 0F);
      Shape2 = new ModelRenderer(this, 28, 11);
      Shape2.addBox(0F, 0F, 0F, 3, 4, 2);
      Shape2.setRotationPoint(-1F, 16.5F, -0.7F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0.7853982F, 0.7853982F, 0F);
      Shape3 = new ModelRenderer(this, 41, 10);
      Shape3.addBox(0F, 0F, 0F, 2, 9, 1);
      Shape3.setRotationPoint(0.5F, 17F, 0F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0.7853982F, 0F);
      Shape4 = new ModelRenderer(this, 13, 17);
      Shape4.addBox(0F, 0F, 0F, 0, 12, 2);
      Shape4.setRotationPoint(2.5F, 30F, -0.7F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 3.141593F, 3.403392F, 0F);
      Shape5 = new ModelRenderer(this, 8, 17);
      Shape5.addBox(0F, 0F, 0F, 0, 12, 2);
      Shape5.setRotationPoint(1.1F, 18F, 0.6F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 1.308997F, 0.0174533F);
      Shape6 = new ModelRenderer(this, 55, 0);
      Shape6.addBox(0F, 0F, 0F, 2, 5, 2);
      Shape6.setRotationPoint(-0.5F, 26F, -0.9F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0.4363323F, 0.7853982F, 0F);
      Shape7 = new ModelRenderer(this, 24, 0);
      Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape7.setRotationPoint(0.7F, 5F, 1F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 1.570796F, 0F);
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

}
