package starglas.dsremake.items.spells.dark;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.items.spells.DSSpells;

/**
 * Created by Starlight on 8-9-2015.
 */
public class Bloodtinge extends DSSpells {

    public Bloodtinge(){
        super();
    }

    public ItemStack onEaten(ItemStack items, World world, EntityPlayer player){
        //int playerHP
        return items;
    }
    public int getMaxItemUseDuration(ItemStack items) {
        return 15;
    }
    @Override
    public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player) {
        player.setItemInUse(items, this.getMaxItemUseDuration(items));
        return items;
    }
}
