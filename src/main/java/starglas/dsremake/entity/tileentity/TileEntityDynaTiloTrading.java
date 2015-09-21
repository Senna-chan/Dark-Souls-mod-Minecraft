package starglas.dsremake.entity.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * Created by Starlight on 15-9-2015.
 */
public class TileEntityDynaTiloTrading extends TileEntity implements IInventory {

    private ItemStack[] slotContent;

    public TileEntityDynaTiloTrading(){
        this.slotContent = new ItemStack[2];
    }

    @Override
    public int getSizeInventory() {
        return this.slotContent.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.slotContent[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        if(this.slotContent[slot] != null){
            ItemStack items;
            if(this.slotContent[slot].stackSize <= amt){
                items = this.slotContent[0];
                this.slotContent[slot] = null;
                return items;
            }
            else {
                items = this.slotContent[slot].splitStack(amt);
                if(this.slotContent[slot].stackSize == 0){
                    this.slotContent[slot] = null;
                }
                return items;
            }
        }
        else{
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if(this.slotContent[slot] != null){
            this.markDirty();
            ItemStack items = this.slotContent[slot];
            this.slotContent[slot] = null;
            return items;
        }
        else{
            return null;
        }

    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack items) {
        this.slotContent[slot] = items;

        if(items != null && items.stackSize > this.getInventoryStackLimit()){
            items.stackSize = this.getInventoryStackLimit();
        }
        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return "Dyna and Tilo";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack item ) {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList tagList = nbt.getTagList("Items", 10);
        this.slotContent = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < slotContent.length) {
                slotContent[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < slotContent.length; i++) {
            ItemStack stack = slotContent[i];
            if (stack != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        nbt.setTag("Inventory", itemList);

    }

    @Override
    public void updateEntity() {
        if(this.slotContent[0]!=null && this.slotContent[1]==null){
            this.markDirty();
            ItemStack items = this.slotContent[0];
            int mark = 0;
            if(items.getItem() == Items.gold_ingot){
                mark = 1;
            }
            if(items.getItem() == Items.diamond){
                mark = 2;
            }
            if(items.getItem() == Items.emerald){
                mark = 3;
            }
            this.tradeItem(mark);

        }
    }
    public void tradeItem(int mark){
        Random random = new Random();
        ItemStack[] mark1Items = new ItemStack[]{new ItemStack(Items.diamond), new ItemStack(Items.cooked_beef, 16)};
        ItemStack[] mark2Items = new ItemStack[]{new ItemStack(Items.emerald), new ItemStack(Items.cooked_beef, 32)};
        ItemStack[] mark3Items = new ItemStack[]{new ItemStack(Blocks.iron_block, 2), new ItemStack(Blocks.diamond_block)};
        int index = random.nextInt(2);

        switch (mark){
            case 1:
                this.setInventorySlotContents(1, mark1Items[index]);
                this.decrStackSize(0, 1);
                break;
            case 2:
                this.setInventorySlotContents(1, mark2Items[index]);
                this.decrStackSize(0, 1);
                break;
            case 3:
                this.setInventorySlotContents(1, mark3Items[index]);
                this.decrStackSize(0, 1);
                break;
            default:
                break;
        }
    }
}
