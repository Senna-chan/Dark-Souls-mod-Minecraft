package starglas.dsremake.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;

public class VilebarkLog extends BlockRotatedPillar
{
    @SideOnly(Side.CLIENT)
    protected IIcon top;
    @SideOnly(Side.CLIENT)
    protected IIcon side;

    public VilebarkLog()
    {
        super(Material.wood);
        this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
        this.setHardness(2.0F);
        this.setStepSound(soundTypeWood);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }

    public void registerBlockIcons(IIconRegister icon) {

        side = icon.registerIcon("dsremake:vilebarkblock");
        top = icon.registerIcon("minecraft:log_oak_top");
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_)
    {
        return this.side;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_)
    {
        return this.top;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}