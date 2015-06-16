package starglas.dsremake.handler;

import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.gui.BookGui;
import starglas.dsremake.gui.ContainerDSInv;
import starglas.dsremake.gui.GuiDSInv;
import starglas.dsremake.gui.container.ContainerCustomPlayer;
import starglas.dsremake.gui.inventory.GuiCustomPlayerInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {

	public GUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ModReference.MODID, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case ModReference.GUI_DSINV:
			return new ContainerCustomPlayer(player, player.inventory, ExtendedPlayer.get(player).inventory);
		default:
			return null;
		}

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case ModReference.GUI_DSINV:
			return new GuiCustomPlayerInventory(player, player.inventory, ExtendedPlayer.get(player).inventory);
		default:
			return null;
		}
	}

}
