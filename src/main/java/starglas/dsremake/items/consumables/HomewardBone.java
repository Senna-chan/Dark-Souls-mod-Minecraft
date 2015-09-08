package starglas.dsremake.items.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.handler.ExtendedPlayer;

public class HomewardBone extends Item{
	
	
	public HomewardBone(){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSConsume);
		this.setMaxStackSize(1);
		this.setTextureName("minecraft:bone");
	}
	
	public ItemStack onItemRightClick(ItemStack Items, World world,EntityPlayer player){
		ExtendedPlayer props = ExtendedPlayer.get(player);
		double[] LastBFUsed = props.getLastUsedBonfire();
		player.setPositionAndUpdate(LastBFUsed[0], LastBFUsed[1], LastBFUsed[2]);
		if (!player.capabilities.isCreativeMode)
        {
            --Items.stackSize;
        }
		return Items;
	}
	
}