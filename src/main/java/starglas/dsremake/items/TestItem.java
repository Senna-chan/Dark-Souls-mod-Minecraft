package starglas.dsremake.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Starlight on 16-8-2015.
 */
public class TestItem extends Item {
    public TestItem(){
        super();
        setHasSubtypes(true);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player) {
        return items;
    }


    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }
}
