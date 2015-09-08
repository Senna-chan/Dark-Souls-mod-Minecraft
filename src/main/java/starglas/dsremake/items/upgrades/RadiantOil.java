package starglas.dsremake.items.upgrades;

import net.minecraft.item.Item;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;

public class RadiantOil extends Item{
	public RadiantOil(){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
		this.setMaxStackSize(1);
	}
}