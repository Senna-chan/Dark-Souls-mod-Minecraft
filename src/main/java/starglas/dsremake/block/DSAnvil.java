package starglas.dsremake.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.entity.tileentity.TileEntityDSAnvil;

/**
 * Created by Starlight on 9-9-2015.
 */
public class DSAnvil extends BlockFalling implements ITileEntityProvider {
    public DSAnvil(){
        super();
        this.blockHardness = 10F;
        this.setHardness(5.0F);
        this.setStepSound(soundTypeAnvil);
        this.setResistance(2000.0F);
        this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDSAnvil();
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }
}
