package starglas.dsremake.gui.slots;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import starglas.dsremake.items.shields.DSShields;
import starglas.dsremake.items.spells.DSSpells;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

//Custom Slot:

public class SlotShields extends Slot

{

	public SlotShields(IInventory inventory, int par2, int par3, int par4)

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

		return itemstack.getItem() instanceof DSSpells;

	}
	@SideOnly(Side.CLIENT)
	public IIcon getBackgroundIconIndex()
	{
		return DSSpells.getBackgroundIcon();
	}

}