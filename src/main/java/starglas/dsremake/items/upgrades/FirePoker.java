package starglas.dsremake.items.upgrades;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 11-9-2015.
 */
public class FirePoker extends Item {
    public FirePoker(){
        super();
        this.setCreativeTab(DSMainCreativeTabs.tabDSUpgrade);
        this.setMaxStackSize(8);
        this.setTextureName(ModVars.MODID + ":firepoker");
    }

    public boolean hitEntity(ItemStack item, EntityLivingBase target, EntityLivingBase player)
    {
        ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)player);
        props.staminaNeeded = 20;
        target.setFire(1);
        return true;
    }
}
