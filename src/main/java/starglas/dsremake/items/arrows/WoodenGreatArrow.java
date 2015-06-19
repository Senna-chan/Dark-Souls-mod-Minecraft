package starglas.dsremake.items.arrows;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;

public class WoodenGreatArrow extends DSArrow {
	public WoodenGreatArrow(){
		this.setCreativeTab(DSMainCreativeTabs.tabDSBows);
		this.setMaxStackSize(64);
	}
	public ItemStack onItemRightClick(ItemStack Items, World world, EntityPlayer player) {
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30F);
		return Items;
	}
}
