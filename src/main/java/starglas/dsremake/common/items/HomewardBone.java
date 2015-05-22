package starglas.dsremake.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.handler.DSPlayerHandler;

public class HomewardBone extends Item{
	
	
	public HomewardBone(){
		super();
		this.setCreativeTab(CreateCreativeTab.tabDSConsume);
		this.setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack Items, World world,EntityPlayer player){
		DSPlayerHandler handler = new DSPlayerHandler(player);
//		LastBFX = handler.getLastVisitedBonfireX();
//		LastBFY = handler.getLastVisitedBonfireY();
//		LastBFZ = handler.getLastVisitedBonfireZ();
		return Items;
	}
	
}