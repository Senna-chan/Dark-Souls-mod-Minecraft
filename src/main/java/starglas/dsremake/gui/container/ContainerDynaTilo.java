package starglas.dsremake.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import starglas.dsremake.entity.tileentity.TileEntityDynaTiloTrading;
import starglas.dsremake.gui.slots.SlotDynaTilo;

/**
 * Created by Starlight on 15-9-2015.
 */
public class ContainerDynaTilo extends Container{
    InventoryPlayer inventoryPlayer;
    TileEntityDynaTiloTrading tileEntity;
    public ContainerDynaTilo(EntityPlayer player,TileEntityDynaTiloTrading tileEntity)
    {
        inventoryPlayer = player.inventory;
        this.tileEntity = tileEntity;
        this.addSlotToContainer(new SlotDynaTilo(tileEntity, 0, 20, 20));
        this.addSlotToContainer(new SlotDynaTilo(tileEntity, 0, 40, 20));
        int i;
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

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2){
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if(slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(par2 == 1){
                if(!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if(par2 != 1 && par2 != 0){
                if(par2 >=3 && par2 < 30){
                    if(!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
                    return null;
                }
            }else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
                return null;
            }
            if(itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }else{
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
}
