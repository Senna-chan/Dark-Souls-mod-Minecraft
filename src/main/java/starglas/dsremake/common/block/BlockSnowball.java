package starglas.dsremake.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockSnowball extends BlockContainer {
	private static final String name = "snowball";

	public BlockSnowball() {
		super(Material.snow);
		//setBlockBounds(0.25F, 0, 0.25F, 0.75F, 0.5F, 0.75F);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y,
			int z, int side) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TESnowball();
	}
}