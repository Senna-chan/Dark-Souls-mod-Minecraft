package starglas.dsremake.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.tileentity.TileEntityDynaTiloTrading;

import java.util.Random;

/**
 * Created by Starlight on 15-9-2015.
 */
public class DynaTiloTrading extends BlockContainer {

    Random random = new Random();

    public DynaTiloTrading() {
        super(Material.rock);
        this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDynaTiloTrading();
    }

    public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (!world.isRemote)
        {
            player.openGui(ModVars.MODID, ModVars.GUI_DYNATILO, world, X, Y, Z);
        }
        return true;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
        return super.onBlockPlaced(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
    }
}
