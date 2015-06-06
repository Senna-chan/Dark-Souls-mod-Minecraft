package starglas.dsremake.items.upgrades;

import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModReference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BloodStone extends Item {

	private int mark;
	public BloodStone(int mark) {
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
		if(mark != 5){
			this.setTextureName(ModReference.MODID + ":bloodstone" + mark);
		}
		else{
			this.setTextureName(ModReference.MODID + ":prismaticbloodstone");
		}
		this.mark = mark;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		switch(this.mark){
		case 1:
			return EnumRarity.common;
		case 2:
			return EnumRarity.common;
		case 3:
			return EnumRarity.uncommon;
		case 4:
			return EnumRarity.rare;
		case 5:
			return EnumRarity.epic;
		default:
			return EnumRarity.common;
		}
	}
	public boolean hasEffect(ItemStack par1ItemStack){
		if(this.mark == 5){
			return true;
		}
		else{
			return false;
		}
	}

}
