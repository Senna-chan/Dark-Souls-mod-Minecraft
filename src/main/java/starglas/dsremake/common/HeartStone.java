package starglas.dsremake.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HeartStone extends Item {
	public HeartStone(int ID){
		super(ID);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName("tutorialmod:myFirstItem");
	}
	
//	public ItemStack onItemRightclick(ItemStack itemstack,World world, EntityPlayer entityplayer){
//		
//	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.epic;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
}