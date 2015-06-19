package starglas.dsremake.block;

import starglas.dsremake.common.helpers.ModReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DesertTempleBlock extends Block{
	public DesertTempleBlock(){
		super(Material.rock);
		this.setBlockTextureName(ModReference.MODID + ":");
		this.setHardness(-1);
	}
}
