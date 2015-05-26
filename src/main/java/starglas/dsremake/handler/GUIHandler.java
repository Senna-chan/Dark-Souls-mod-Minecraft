package starglas.dsremake.handler;

import starglas.dsremake.common.gui.BookGui;
import starglas.dsremake.common.gui.ContainerDSInv;
import starglas.dsremake.common.gui.GuiDSInv;
import starglas.dsremake.common.helpers.ModReference;
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
			return new ContainerDSInv(player);
		default:
			return null;
		}

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case ModReference.GUI_DSINV:
			return new GuiDSInv(player);
		default:
			return null;
		}
	}

}
