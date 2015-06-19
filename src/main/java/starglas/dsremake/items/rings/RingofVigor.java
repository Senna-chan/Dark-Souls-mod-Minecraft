package starglas.dsremake.items.rings;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RingofVigor
  extends Item
  implements IBauble
{
  public IIcon icon;
private float playerMaxHP;
  
  public RingofVigor()
  {
    setMaxStackSize(1);
    setMaxDamage(0);
    setCreativeTab(CreativeTabs.tabTools);
  }
  
  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister ir)
  {
    this.icon = ir.registerIcon("baubles:ring");
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIconFromDamage(int meta)
  {
    return this.icon;
  }
  
  @SideOnly(Side.CLIENT)
  public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
  {
    par3List.add(new ItemStack(this, 1, 0));
  }
  
  public BaubleType getBaubleType(ItemStack itemstack)
  {
    return BaubleType.RING;
  }
  
  public boolean hasEffect(ItemStack par1ItemStack, int a)
  {
    return true;
  }
  
  public EnumRarity getRarity(ItemStack par1ItemStack)
  {
    return EnumRarity.rare;
  }
  
  
  public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
	  	this.playerMaxHP = player.getMaxHealth();
		System.out.println(Math.round(this.playerMaxHP * 0.10 - 1));
		player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 800000, (int) Math.round(this.playerMaxHP * 0.10 - 2), true));
		System.out.println(Math.round(this.playerMaxHP * 0.10 - 1));
  }
  
  public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
	  player.removePotionEffect(Potion.field_76434_w.id);
  }
  
  public boolean canEquip(ItemStack itemstack, EntityLivingBase player)
  {
    return true;
  }
  
  public boolean canUnequip(ItemStack itemstack, EntityLivingBase player)
  {
    return true;
  }

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		
	}
}
