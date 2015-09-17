package starglas.dsremake.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
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

    }
}
