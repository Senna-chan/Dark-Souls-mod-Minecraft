package starglas.dsremake.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.gui.inventory.InventoryDynaTilo;
import starglas.dsremake.gui.inventory.InventoryCustomPlayer;
import starglas.dsremake.items.shields.DSShields;

/**
 * Created by Starlight on 15-9-2015.
 */
public class ContainerDynaTilo extends Container{
    private static final int

    INV_START = 1, INV_END = INV_START + 26,
            HOTBAR_START = INV_END + 1,

    HOTBAR_END = HOTBAR_START + 8;

    public ContainerDynaTilo(EntityPlayer player,InventoryPlayer inventoryPlayer,InventoryDynaTilo inventoryDynaTilo)
    {
        ModHelper.displayChat(player, "Creating slots");
        int i;

        // Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla
        // classes

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Add ACTION BAR - just copied/pasted from vanilla classes

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    /**
     *
     * This should always return true, since custom inventory can be accessed
     * from anywhere
     */

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    /**
     *
     * Called when a player shift-clicks on a slot. You must override this or
     * you will crash when someone does that.
     *
     * Basically the same as every other container I make, since I define the
     * same constant indices for all of them
     */

    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            // Either armor slot or custom item slot was clicked
            if (par2 < INV_START)
            {
                // try to place in player inventory / action bar
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
                {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }
            // Item is in inventory / hotbar, try to place either in custom or
            // armor slots
            else
            {
                // if item is our custom item
				/*if (itemstack1.getItem() instanceof DSSpells)
				{
					if (!this.mergeItemStack(itemstack1, 0, InventoryCustomPlayer.INV_SIZE - 1, false))
					{
						return null;
					}
				}
				else*/ if (itemstack1.getItem() instanceof DSShields){
                if (!this.mergeItemStack(itemstack1, 0, InventoryCustomPlayer.SLOT_SHIELD, false))
                {
                    return null;
                }
            }
            // item in player's inventory, but not in action bar
            else if (par2 >= INV_START && par2 < HOTBAR_START)
            {
                // place in action bar
                if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_START + 1, false))
                {
                    return null;
                }
            }

            // item in action bar - place in player inventory
            else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
            {
                if (!this.mergeItemStack(itemstack1, INV_START,	INV_END + 1, false))
                {
                    return null;
                }
            }
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
}
