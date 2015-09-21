package starglas.dsremake.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSTeamWrapper;

/**
 * Created by Starlight on 16-8-2015.
 */
public class TestItem extends Item {

    public TestItem(){
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player) {
        //DSTeamWrapper.registerPlayerToTeam(world, player, "TeamName");
        DSTeamWrapper.setCoopTeam(player);

        DSTeamWrapper.removeCoopTeam(player);
        return items;
    }
}
