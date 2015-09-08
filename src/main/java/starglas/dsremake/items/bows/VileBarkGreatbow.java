package starglas.dsremake.items.bows;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.entity.projectiles.arrows.EntityWoodengreatarrow;
import starglas.dsremake.items.arrows.DSArrow;

public class VileBarkGreatbow extends ItemBow
{
    @SideOnly(Side.CLIENT)
	private boolean arrowsFound;

    public VileBarkGreatbow()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(DSMainCreativeTabs.tabDSBows);
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int useTimer)
    {
        int j = this.getMaxItemUseDuration(stack) - useTimer;

        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
        
        ItemStack[] playerInventory = player.inventory.mainInventory;

        for(ItemStack itemStack : playerInventory)
        {
            if(itemStack != null && itemStack.getItem() instanceof DSArrow)
            {
            	arrowsFound = true;
            	ModHelper.displayChat(player, "DSARrow Found for check");
            	break;
            }
        }
        
        if (flag || arrowsFound){
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D){
                return;
            }

            if (f > 1.0F){
                f = 1.0F;
            }

            EntityWoodengreatarrow entityarrow = new EntityWoodengreatarrow(world, player, f, 4);

            if (f == 1.0F){
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

            if (k > 0) {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

            if (l > 0){
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
                entityarrow.setFire(100);
            }

            stack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag) {
                entityarrow.canBePickedUp = 2;
            }
            else {
                for(ItemStack itemStack : playerInventory)
                {
                    if(itemStack != null && itemStack.getItem() instanceof DSArrow)
                    {
                    	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
                    	ModHelper.displayChat(player, "DSARrow Found for usage");
                    	player.inventory.consumeInventoryItem(itemStack.getItem());
                    	break;
                    }
                }
            }

            if (!world.isRemote)
            {
            	world.spawnEntityInWorld(entityarrow);
            }
        }
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        return p_77654_1_;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World p_77659_2_, EntityPlayer player)
    {
        ArrowNockEvent event = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (player.capabilities.isCreativeMode)
        {
        	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }
        else if(EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0){
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }
        else
        {

        	ItemStack[] playerInventory = player.inventory.mainInventory;

            for(ItemStack itemStack : playerInventory)
            {
                if(itemStack != null && itemStack.getItem() instanceof DSArrow)
                {
                	ModHelper.displayChat(player, "DSARrow Found OnRightClick");
                	player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
                	break;
                }
            }
        }

        return stack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}
