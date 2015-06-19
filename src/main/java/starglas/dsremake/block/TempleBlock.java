package starglas.dsremake.block;

import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TempleBlock extends Block{
	public TempleBlock(String texture){
		super(Material.rock);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setBlockTextureName(ModReference.MODID + ":"+ texture);
		this.setHardness(-1);
	}
}
