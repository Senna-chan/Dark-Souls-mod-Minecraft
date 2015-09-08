package starglas.dsremake.items.spells;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

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

}
