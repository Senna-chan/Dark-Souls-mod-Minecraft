package starglas.dsremake.items.coop;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 27-9-2015.
 */
public class BeckoningBell extends Item {
    public BeckoningBell() {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(DSMainCreativeTabs.tabDSCoop);
    }
    @Override
    public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player){
        ExtendedPlayer props = ExtendedPlayer.get(player);
        if(props.getPlayerTeam()!=0){

        }
    	return items;
    }
}
