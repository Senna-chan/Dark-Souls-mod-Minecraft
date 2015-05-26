package starglas.dsremake.common.items.upgrades;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.DSMainCreativeTabs;

public class RadiantOil extends Item{
	public RadiantOil(){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
		this.setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack Items, World world,EntityPlayer player){
		
		
		return Items;
	}
	
}