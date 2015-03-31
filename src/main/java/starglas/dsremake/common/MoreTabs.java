package starglas.dsremake.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MoreTabs extends CreativeTabs {

	public MoreTabs(int id, String unlocalizedName) {

		super(id, unlocalizedName);
		this.setNoTitle();
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {

		//return Item.getItemFromBlock(Blocks.chest);
		return Item.shears;
	}
}