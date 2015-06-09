package starglas.dsremake.items.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.handler.DSPlayerHandler;

public class HomewardBone extends Item{
	
	
	public HomewardBone(){
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSConsume);
		this.setMaxStackSize(1);
		this.setTextureName("minecraft:bone");
	}
	
	public ItemStack onItemRightClick(ItemStack Items, World world,EntityPlayer player){
		DSPlayerHandler handler = new DSPlayerHandler(player);
		double[] LastBFUsed = handler.getLastUsedBonfire();
		player.setPositionAndUpdate(LastBFUsed[0]+1, LastBFUsed[1], LastBFUsed[2]+1);
		return Items;
	}
	
}