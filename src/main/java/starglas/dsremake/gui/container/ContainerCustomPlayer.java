package starglas.dsremake.gui.container;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.gui.inventory.InventoryCustomPlayer;
import starglas.dsremake.gui.slots.SlotArmor;
import starglas.dsremake.gui.slots.SlotShields;
import starglas.dsremake.gui.slots.SlotSpells;
import starglas.dsremake.handler.ExtendedPlayer;
import starglas.dsremake.items.shields.DSShields;
import starglas.dsremake.items.spells.DSSpells;

public class ContainerCustomPlayer extends Container

{

	/**
	 * Avoid magic numbers! This will greatly reduce the chance of you making
	 * errors in 'transferStackInSlot' method
	 */

	private static final int ARMOR_START = InventoryCustomPlayer.INV_SIZE,
			ARMOR_END = ARMOR_START + 3,

			INV_START = ARMOR_END + 1, INV_END = INV_START + 26,
			HOTBAR_START = INV_END + 1,

			HOTBAR_END = HOTBAR_START + 8;

	public ContainerCustomPlayer(EntityPlayer player,InventoryPlayer inventoryPlayer,InventoryCustomPlayer inventoryCustom)
	{
		ExtendedPlayer props = ExtendedPlayer.get(player);
		int MagicSlots = props.getMagicSlots(); 
		ModHelper.displayChat(player, "Creating slots");
		int i;
		// Spell slots
		for(i = 0; i < 5; i++){
			this.addSlotToContainer(new SlotSpells(inventoryCustom, i, 80 + (18*i), 8, 0));
		}
		for(i = 0; i < 5; i++){
			this.addSlotToContainer(new SlotSpells(inventoryCustom, i+5, 80+ (18*i), 26, 0));		
		}
		this.addSlotToContainer(new SlotShields(inventoryCustom, 10, 80, 62)); // Shield slot

		// Add ARMOR slots; note you need to make a public version of SlotArmor
		// just copy and paste the vanilla code into a new class and change what
		// you need

		for (i = 0; i < 4; ++i)
		{
			this.addSlotToContainer(new SlotArmor(player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18, i));
		}

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
				// if item is armor
				else if (itemstack1.getItem() instanceof ItemArmor)
				{
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
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
				slot.putStack((ItemStack) null);
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