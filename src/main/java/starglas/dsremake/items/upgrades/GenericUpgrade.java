package starglas.dsremake.items.upgrades;

import net.minecraft.item.Item;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;

public class GenericUpgrade extends Item{
	
	public GenericUpgrade(String texture){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
		this.setMaxStackSize(8);
		this.setTextureName(ModVars.MODID + texture);
	}

}
