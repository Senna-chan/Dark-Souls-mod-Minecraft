package starglas.dsremake.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VitaCrystal extends Item {

	public VitaCrystal(int ID, String texture) {
		super(ID);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(texture);
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
		if (!player.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

		player.addExperience(20);

        return par1ItemStack;
    }

}
