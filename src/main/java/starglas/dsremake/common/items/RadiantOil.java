package starglas.dsremake.common.items;

import starglas.dsremake.common.CreateCreativeTab;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RadiantOil extends Item{
	public RadiantOil(){
		super();
		this.setCreativeTab(CreateCreativeTab.tabDSUpgrade);
		this.setMaxStackSize(1);
	}
	public EnumRarity getRarity(ItemStack par1ItemStack){ // Sets name coloring
		return EnumRarity.uncommon;
	}
}