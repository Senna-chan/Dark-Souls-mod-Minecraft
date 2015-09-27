package starglas.dsremake.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Starlight on 16-8-2015.
 */
public class TestItem extends Item {

    public TestItem(){
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player) {
        //DSTeamWrapper.registerPlayerToTeam(player, "Sun_Bro");
        //DSTeamWrapper.setTeamPrefix(world.getScoreboard().getTeam("Sub_Bro"), "Sun bro");
        //DSTeamWrapper.removeCoopTeam(player);
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100, 5));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 5));
        player.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
        return items;
    }
}
