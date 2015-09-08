package starglas.dsremake.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 15-7-2015.
 */
public class TheBook extends Item {
    public TheBook(){
        super();
        this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        ExtendedPlayer props = ExtendedPlayer.get(player);
            player.openGui(ModVars.MODID, ModVars.GUI_BOOK, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
        return item;
    }
}
