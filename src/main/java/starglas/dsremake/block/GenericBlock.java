package starglas.dsremake.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;

public class GenericBlock extends Block{
	public GenericBlock(String texture){
		super(Material.rock);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setBlockTextureName(ModVars.MODID + ":"+ texture);
	}
	public GenericBlock(String texture, Material material){
		super(material);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setBlockTextureName(ModVars.MODID + ":"+ texture);
	}
}
