package starglas.dsremake.client.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class bloodstoneore extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
  
  public bloodstoneore()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 16, 16);
      Shape1.setRotationPoint(-8F, 8F, -8F);
      Shape1.setTextureSize(128, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 85, 0);
      Shape2.addBox(0F, 0F, 0F, 3, 2, 1);
      Shape2.setRotationPoint(-10F, 14F, 1F);
      Shape2.setTextureSize(128, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0.7853982F, 0.5235988F, 0F);
      Shape3 = new ModelRenderer(this, 102, 0);
      Shape3.addBox(0F, 0F, 0F, 7, 4, 5);
      Shape3.setRotationPoint(2F, 18F, 0F);
      Shape3.setTextureSize(128, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0.6981317F, 0.8726646F, 0F);
      Shape4 = new ModelRenderer(this, 66, 0);
      Shape4.addBox(0F, 0F, 0F, 5, 5, 4);
      Shape4.setRotationPoint(1F, 12F, -4F);
      Shape4.setTextureSize(128, 32);
      Shape4.mirror = true;
      setRotation(Shape4, -1.301251F, 0.8551081F, 0F);
      Shape5 = new ModelRenderer(this, 74, 17);
      Shape5.addBox(0F, 0F, 0F, 6, 3, 10);
      Shape5.setRotationPoint(2F, 14F, -1.333333F);
      Shape5.setTextureSize(128, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0.6320364F, -0.7063936F, 0.8179294F);
      Shape6 = new ModelRenderer(this, 107, 22);
      Shape6.addBox(0F, 0F, 0F, 5, 5, 4);
      Shape6.setRotationPoint(0F, 5F, 0F);
      Shape6.setTextureSize(128, 32);
      Shape6.mirror = true;
      setRotation(Shape6, -0.7807508F, 1.858931F, 0.7807508F);
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
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void renderAll(float f5){
	  Shape1.render(f5);
	  Shape2.render(f5);
	  Shape3.render(f5);
	  Shape4.render(f5);
	  Shape5.render(f5);
	  Shape6.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
