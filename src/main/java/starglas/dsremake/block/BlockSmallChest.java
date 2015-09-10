package starglas.dsremake.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.tileentity.TileEntitySmallChest;

public class BlockSmallChest extends BlockContainer{


	protected BlockSmallChest() {
		super(Material.wood);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setHardness(0.5F);
		this.setBlockBounds(0F, 0F, 0F, 2F, 1F, 1F);
		this.setBlockTextureName(ModVars.MODID + ":smallchest");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int inter) {
		return new TileEntitySmallChest();
	}
	
	public  
	int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	
}
