package starglas.dsremake.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.entity.TileEntityBloodstoneOre;
import starglas.dsremake.items.ModItems;

public class BloodstoneOre extends BlockContainer{
	private Random rand = new Random();
	private int least_quantity = 1;
	private int most_quantity = 2;
	
	public BloodstoneOre(){
		 super(Material.iron);
	     this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
	     this.setHardness(6F);
	     this.setResistance(10F);
	     this.setBlockTextureName(ModReference.MODID + ":bloodstoneparticle");
	     this.setStepSound(soundTypeStone);
	}
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.MK1BloodStone;
    }
	
    @Override
    public int getExpDrop(IBlockAccess par1, int par2, int par3)
    {
		int j1 = 0;
		j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
		return j1;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (this.least_quantity >= this.most_quantity)
            return this.least_quantity;
        return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        drops.add(new ItemStack(ModItems.MK1BloodStone, world.rand.nextInt(2) + 1));
        if (world.rand.nextFloat() < 0.15F)
            drops.add(new ItemStack(ModItems.MK2BloodStone));
        return drops;
    }
    
    @Override
	public TileEntity createNewTileEntity(World world, int inter) {
		return new TileEntityBloodstoneOre();
	}
    
    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public int getRenderType(){
        return -1;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
    
}
