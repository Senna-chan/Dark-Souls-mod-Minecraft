package starglas.dsremake.items.fists;

import java.util.List;
import java.util.Random;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.WeaponInfo;
import starglas.dsremake.common.helpers.WeaponScaling;
import starglas.dsremake.items.arrows.DSArrow;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class GenericFist extends Item
{
	private float weaponDamage;
	int knockbackAdded = 0;
	
    public GenericFist(int dmg, char str, char grc)
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(20);
        this.setCreativeTab(DSMainCreativeTabs.tabDSFists);
        //this.weaponDamage = WeaponScaling.WeaponScalingRaw(dmg, str, grc);
        this.setFull3D();
        
    }
   
   @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		if(GuiScreen.isShiftKeyDown()) {
	    	for(int i=0;i<WeaponInfo.GyroDrill.length; ){
	    		list.add(WeaponInfo.GyroDrill[i]);
	    		i++;
	    	}
		} else{
			list.add("Press shift for more info");
		}
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
		NBTTagList enchantList = stack.getEnchantmentTagList();
		if(enchantList == null){
			stack.addEnchantment(Enchantment.knockback, 3);
		}
		if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack)
            {
                player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2, 2, true));
            }
        }
		super.onUpdate(stack, worldIn, entity, itemSlot, isSelected);
	}

    public float func_82803_g()
    {
        return this.weaponDamage;
    }
    
    public int getItemEnchantability()
    {
        return 100;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
    {
        par1ItemStack.damageItem(1, entityliving1);
        
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 720;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
        return multimap;
    }
}