package starglas.dsremake.items.spells;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import starglas.dsremake.common.helpers.ModHelper;

public class DSSpells extends Item{
	private static IIcon emptySlotIcon;
	public DSSpells(){
		super();
		this.maxStackSize = 1;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister IIcon)
    {
        super.registerIcons(IIcon);
        emptySlotIcon = IIcon.registerIcon("empty_armor_slot_helmet");
    }

	public static IIcon getBackgroundIcon() {
		return emptySlotIcon;
	}



	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		ModHelper.displayChat(player, "Can't drop it(Insert beat here");
		return false;
	}
}
