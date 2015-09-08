package starglas.dsremake.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.gui.BonFireGui;
import starglas.dsremake.gui.BookGui;
import starglas.dsremake.gui.container.ContainerCustomPlayer;
import starglas.dsremake.gui.inventory.GuiCustomPlayerInventory;

public class GUIHandler implements IGuiHandler {

	public GUIHandler() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case ModVars.GUI_DSINV:
				return new ContainerCustomPlayer(player, player.inventory, ExtendedPlayer.get(player).inventoryPlayer);
//			case ModVars.GUI_BONFIRE:
//				return new ContainerBonfire(player, player.inventory);
//			case ModVars.GUI_BONFIRECHEST:
//				return new ContainerBonfireChest(player, player.inventory, ExtendedPlayer.get(player).inventoryBonfire);
		default:
			return null;
		}

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case ModVars.GUI_DSINV:
				return new GuiCustomPlayerInventory(player, player.inventory, ExtendedPlayer.get(player).inventoryPlayer);
			case ModVars.GUI_BONFIRE:
				return new BonFireGui(player, player.inventory, ExtendedPlayer.get(player));
			case ModVars.GUI_BOOK:
				return new BookGui(player);
//			case ModVars.GUI_BONFIRECHEST:
//				return new GuiBonfireChest(player, player.inventory, ExtendedPlayer.get(player).inventoryBonfire);
			default:
				return null;
		}
	}

}
