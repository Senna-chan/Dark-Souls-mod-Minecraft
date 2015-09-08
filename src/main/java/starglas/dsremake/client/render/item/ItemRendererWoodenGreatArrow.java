package starglas.dsremake.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.client.models.entities.ModelWoodengreatarrow;
import starglas.dsremake.common.helpers.ModVars;

public class ItemRendererWoodenGreatArrow implements IItemRenderer {

    public static ModelWoodengreatarrow model;

    public ItemRendererWoodenGreatArrow() {
        model = new ModelWoodengreatarrow();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return helper != ItemRendererHelper.EQUIPPED_BLOCK;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        GL11.glPushMatrix();

        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModVars.MODID, "textures/items/Woodengreatarrow.png"));
        if (type == ItemRenderType.EQUIPPED) {
            GL11.glRotatef(270, 0, 1, 0);
            GL11.glRotatef(30, 1, 0, 0);
            GL11.glRotatef(40, 0, 0, 1);
            GL11.glTranslatef(0.1F, -1.0F, -1);
        } else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glRotatef(10F, 0, 0, 1);
            GL11.glTranslatef(1.0F, -1.0F, 0.6F);
        } else if (type == ItemRenderType.INVENTORY) {
            GL11.glRotatef(270, 0, 1, 0);
            GL11.glRotatef(30, 1, 0, 0);
            GL11.glRotatef(-30, 0, 0, 1);
            //GL11.glTranslatef();
        } else if (type == ItemRenderType.ENTITY) {
            GL11.glRotatef(270, 0, 1, 0);
            GL11.glRotatef(30, 1, 0, 0);
            GL11.glRotatef(-30, 0, 0, 1);
        }
        model.renderModel(0.0625F);
        GL11.glPopMatrix();
    }
}
