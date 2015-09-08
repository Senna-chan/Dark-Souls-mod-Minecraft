package starglas.dsremake.items.upgrades;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;

public class BloodStone extends Item {

	private int mark;
	public BloodStone(int mark) {
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
		if(mark != 5){
			this.setTextureName(ModVars.MODID + ":bloodstone" + mark);
		}
		else{
			this.setTextureName(ModVars.MODID + ":prismaticbloodstone");
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
		return this.mark == 5;
	}

}
