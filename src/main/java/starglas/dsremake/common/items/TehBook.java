package starglas.dsremake.common.items;

import starglas.dsremake.common.gui.BookGui;
import starglas.dsremake.common.helpers.ModReference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TehBook extends Item{
	
	public TehBook(){
		super();
		this.setTextureName("minecraft:book_normal");
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		//player.openGui(Reference.MODID, 0, world, (int)player.posX,(int) player.posY, (int)player.posX);
		if(!world.isRemote)
			Minecraft.getMinecraft().displayGuiScreen(new BookGui());
		return itemstack;
	}
}
