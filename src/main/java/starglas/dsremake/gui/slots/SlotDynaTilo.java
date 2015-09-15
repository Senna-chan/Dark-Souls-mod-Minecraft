package starglas.dsremake.gui.slots;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import starglas.dsremake.items.rings.DSRings;

public class SlotDynaTilo extends Slot{

    public SlotDynaTilo(IInventory inventory, int par2, int par3, int par4)

    {

        super(inventory, par2, par3, par4);

    }

    /**
     *
     * Check if the stack is a valid item for this slot. Always true beside for
     * the armor slots
     *
     * (and now also not always true for our custom inventory slots)
     */

    @Override
    public boolean isItemValid(ItemStack itemstack)
    {
        // We only want our custom item to be storable in this slot
        Item item = itemstack.getItem();
        if(item == Items.gold_ingot || item == Items.diamond || item == Items.emerald){
            return true;
        }
        else {
            return false;
        }
    }
}
