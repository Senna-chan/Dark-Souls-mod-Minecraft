package starglas.dsremake.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;

public class XPDrainer extends Item{
	public XPDrainer(){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSConsume);
	}
	public int getMaxItemUseDuration(ItemStack Items) {
		return 15;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack Items, World world, EntityPlayer player) {
		if(player.experienceTotal > 50){
			if(player.inventory.getFirstEmptyStack() != -1){
				player.experienceTotal = player.experienceTotal - 50;
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.MK1VitaCrystal,1));
			}
		}
		return Items;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.block;
	}
}
