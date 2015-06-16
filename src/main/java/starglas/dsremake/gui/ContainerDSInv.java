package starglas.dsremake.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDSInv extends Container{
	
	public ContainerDSInv(EntityPlayer player) {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
}
