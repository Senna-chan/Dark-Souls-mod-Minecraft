package starglas.dsremake.common.block;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.common.helpers.Reference;

public class BloodstoneOre extends BlockOre{
	int mark;
	public BloodstoneOre(int mark){
		 super();
	     this.setCreativeTab(CreateCreativeTab.tabDSBlocks);
	     this.mark = mark;
	     this.setBlockTextureName(Reference.MODID + ":" + "bloodstoneore" + mark);
	}
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(this);
    }
	private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess par1, int par2, int par3)
    {
		int j1 = 0;
		if(this.mark==1){
			j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
		}
		else if(this.mark==2){
			j1 = MathHelper.getRandomIntegerInRange(rand, 5, 10);
		}
		return j1;
    }
}
