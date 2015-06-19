package starglas.dsremake.gui.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import starglas.dsremake.items.spells.DSSpells;

//Custom Slot:

public class SlotSpells extends Slot

{

	private int disabled;

	public SlotSpells(IInventory inventory, int par2, int par3, int par4, int i)

	{

		super(inventory, par2, par3, par4);
		this.disabled = i;
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
		if(this.disabled == 0)
			return itemstack.getItem() instanceof DSSpells;
		else if (this.disabled == 1)
			return false;
		else
			return false;
	}

}