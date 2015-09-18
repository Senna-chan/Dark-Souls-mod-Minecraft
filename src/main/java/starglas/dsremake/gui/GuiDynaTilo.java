package starglas.dsremake.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.tileentity.TileEntityDynaTiloTrading;
import starglas.dsremake.gui.container.ContainerDynaTilo;

/**
 * Created by Starlight on 15-9-2015.
 */
public class GuiDynaTilo extends GuiContainer{

    InventoryPlayer playerInventory;

    public GuiDynaTilo(EntityPlayer player, TileEntityDynaTiloTrading tileEntity) {
        super(new ContainerDynaTilo(player, tileEntity));
        playerInventory = player.inventory;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i1) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(new ResourceLocation(ModVars.MODID, "/textures/gui/inventory.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public void drawScreen(int x, int y, float ticks){
        mc.getTextureManager().bindTexture(new ResourceLocation(ModVars.MODID, "/textures/gui/inventory.png"));
        super.drawScreen(x, y, ticks);
    }
}
