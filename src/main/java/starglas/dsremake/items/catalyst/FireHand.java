package starglas.dsremake.items.catalyst;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.handler.ExtendedPlayer;
import starglas.dsremake.handler.KeyHandler;

/**
 * Created by Starlight on 10-7-2015.
 */
public class FireHand extends DSCatalyst {
    public FireHand(){
        this.setCreativeTab(DSMainCreativeTabs.tabDSFists);
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(item, world, entity, itemSlot, isSelected);
        if(entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            ExtendedPlayer props = ExtendedPlayer.get(player);
            if (item.getTagCompound() == null) {
                item.setTagCompound(new NBTTagCompound());
                item.getTagCompound().setInteger("slot", 0);
            }
            if (isSelected) {
                NBTTagCompound nbt = item.getTagCompound();
                int slot = nbt.getInteger("slot");
                if (KeyHandler.keys[KeyHandler.SPELLMINUS].isPressed()) {
                    System.out.println(slot);
                    if (slot != 0) {
                        nbt.setInteger("slot", slot - 1);
                    } else {
                        nbt.setInteger("slot", 9);
                    }
                }
            }

            if (!world.isRemote) {
                if (isSelected) {

                    int fireLevel = props.getPlayerWrath();
                    props.staminaNeeded = 20;
                    fireLevel = fireLevel / 5;
                    if (fireLevel < 1) {
                        fireLevel = 1;
                    }
                    weaponDamage = fireLevel;
                }
            }

        }
    }

    public boolean hitEntity(ItemStack item, EntityLivingBase target, EntityLivingBase player)
    {
        target.setFire(5);
        return true;
    }

    @Override
    public ItemStack onEaten(ItemStack item, World world, EntityPlayer player) {
        ModHelper.displayChat(player, "Is this the server "+world.isRemote+"?");
        int slot = item.getTagCompound().getInteger("slot");
        ItemStack Mahou = ExtendedPlayer.get(player).inventoryPlayer.getStackInSlot(slot);
        if(Mahou!=null){
            if(!world.isRemote) {
                Mahou.useItemRightClick(world, player);
            }
        }
        return item;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.block;
    }


    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {

        player.setItemInUse(item, 10);
        return item;
    }
}
