package starglas.dsremake.items.upgrades;

import net.minecraft.item.Item;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModReference;

public class GenericUpgrade extends Item{
	
	public GenericUpgrade(String texture){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
		this.setMaxStackSize(64);
		this.setTextureName(ModReference.MODID + texture);
	}

}