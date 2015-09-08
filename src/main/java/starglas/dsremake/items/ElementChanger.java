package starglas.dsremake.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 12-7-2015.
 */
public class ElementChanger extends Item {
    public ElementChanger(){
        super();
        this.setTextureName(ModVars.MODID + ":testtexture");
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setMaxStackSize(1);
    }

    public int getMaxItemUseDuration(ItemStack Items) {
        return 15;
    }
    public ItemStack onEaten(ItemStack Items, World world, EntityPlayer player) {
        return Items;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack Items, World world, EntityPlayer player) {
        ExtendedPlayer props = ExtendedPlayer.get(player);
        if(!world.isRemote) {
            props.changeElement();
        }
        return Items;

    }
}
