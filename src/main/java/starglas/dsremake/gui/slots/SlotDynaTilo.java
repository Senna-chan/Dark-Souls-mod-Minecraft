package starglas.dsremake.gui.slots;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotDynaTilo extends Slot{

    public SlotDynaTilo(IInventory inventory, int par2, int par3, int par4) {
        super(inventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        Item item = itemstack.getItem();
        if(item == Items.gold_ingot || item == Items.diamond || item == Items.emerald){
            return true;
        }
        else {
            return false;
        }
    }
}
