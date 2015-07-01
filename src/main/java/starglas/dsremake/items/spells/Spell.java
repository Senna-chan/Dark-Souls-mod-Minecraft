package starglas.dsremake.items.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.handler.ExtendedPlayer;

public class Spell extends DSSpells {
	public Spell(){
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		props.FinishedBookSetup("taint");
		return super.onItemRightClick(items, world, player);
	}
}
