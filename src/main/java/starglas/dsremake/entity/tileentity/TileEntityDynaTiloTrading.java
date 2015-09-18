package starglas.dsremake.entity.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * Created by Starlight on 15-9-2015.
 */
public class TileEntityDynaTiloTrading extends TileEntity implements ISidedInventory {

    private static int slotInput = 0;
    private static int slotOutput = 1;

    private ItemStack[] slotContent = new ItemStack[2];

    @Override
    public int getSizeInventory() {
        return this.slotContent.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.slotContent[slot];
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if(this.slotContent[var1] != null){
            ItemStack items;
            if(this.slotContent[var1].stackSize <= var2){
                items = this.slotContent[var1];
                this.slotContent[var1] = null;
                return items;
            }
            else {
                items = this.slotContent[var1].splitStack(var2);
                if(this.slotContent[var1].stackSize == 0){
                    this.slotContent[var1] = null;
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
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
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
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList taglist = nbt.getTagList("Items", 10);
        this.slotContent = new ItemStack[this.getSizeInventory()];
        for(int i = 0; i < taglist.tagCount(); i++){
            NBTTagCompound tagCompound = taglist.getCompoundTagAt(i);
            byte byte0 = tagCompound.getByte("slot");
            if(byte0 != 0 && byte0 < this.slotContent.length){
                this.slotContent[byte0] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < this.slotContent.length; i++){
            if(this.slotContent[i] != null){
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("slot", (byte)i);
                this.slotContent[i].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbt.setTag("Items", tagList);

        if(this.hasCustomInventoryName()){
            nbt.setString("customName", this.getInventoryName());
        }

    }

    @Override
    public void updateEntity() {
        if(this.slotContent[0]!=null && this.slotContent[1]==null){
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
        switch (mark){
            case 1:
                int index = random.nextInt(1);
                this.slotContent[1] = mark1Items[index];
                this.slotContent[0] = null;

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                break;
        }
    }
}
