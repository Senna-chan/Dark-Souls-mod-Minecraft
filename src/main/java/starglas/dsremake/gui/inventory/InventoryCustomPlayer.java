package starglas.dsremake.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.items.shields.DSShields;
import starglas.dsremake.items.spells.DSSpells;
public class InventoryCustomPlayer implements IInventory

{

	/** The name for your custom inventory, possibly just "Inventory" */

	private final String name = "Custom Inventory";

	/**
	 * In case your inventory name is too generic, define a name to store the
	 * NBT tag in as well
	 */



	/** Define the inventory size here for easy reference */

	// This is also the place to define which slot is which if you have
	// different types,

	// for example SLOT_SHIELD = 0, SLOT_AMULET = 1;

	public static final int INV_SIZE = 11;
	public static final int SLOT_SHIELD = 11;

	public Minecraft mc;
	/**
	 * Inventory's size must be same as number of slots you add to the Container
	 * class
	 */

	ItemStack[] inventory = new ItemStack[INV_SIZE];

	public InventoryCustomPlayer()

	{
		// don't need anything here!
	}

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}
	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		ItemStack stack = getStackInSlot(slot);
		if (stack != null)
		{
			if (stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0)
				{
					setInventorySlotContents(slot, null);
				}
			}
			else
			{
				setInventorySlotContents(slot, null);
			}
			this.markDirty();
		}
		return stack;
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		ItemStack stack = getStackInSlot(slot);
		if (stack != null)
		{
			setInventorySlotContents(slot, null);
		}
		return stack;
	}
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		this.inventory[slot] = itemstack;
		if (itemstack != null
				&& itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		this.markDirty();
	}
	@Override
	public String getInventoryName()
	{
		return name;
	}
	@Override
	public boolean hasCustomInventoryName()
	{
		return name.length() > 0;
	}
	/**
	 * 
	 * Our custom slots are similar to armor - only one item per slot
	 */
	@Override
	public int getInventoryStackLimit()
	{
		return 1;
	}
	@Override
	public void markDirty()
	{
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
			if (this.getStackInSlot(i) != null
					&& this.getStackInSlot(i).stackSize == 0)
				this.setInventorySlotContents(i, null);
		}
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return true;
	}
	@Override
	public void openInventory() {}
	@Override
	public void closeInventory() {}
	
	/**
	 * 
	 * This method doesn't seem to do what it claims to do, as
	 * 
	 * items can still be left-clicked and placed in the inventory
	 * 
	 * even when this returns false
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		// If you have different kinds of slots, then check them here:
		// if (slot == SLOT_SHIELD && itemstack.getItem() instanceof ItemShield)
		// return true;

		// For now, only ItemUseMana items can be stored in these slots
		if(slot == SLOT_SHIELD && itemstack.getItem() instanceof DSShields){
			return true;
		}
		else return itemstack.getItem() instanceof DSSpells;
	}
	public void writeToNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
			if (this.getStackInSlot(i) != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		// We're storing our items in a custom tag list using our 'tagName' from
		// above to prevent potential conflicts
		tagcompound.setTag(ModVars.PLAYERINVTAGNAME, nbttaglist);
	}
	public void readFromNBT(NBTTagCompound compound) {

		// now you must include the NBTBase type ID when getting the list; NBTTagCompound's ID is 10
		NBTTagList items = compound.getTagList(ModVars.PLAYERINVTAGNAME, compound.getId());
		for (int i = 0; i < items.tagCount(); ++i) {
			// tagAt(int) has changed to getCompoundTagAt(int)
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}
}
