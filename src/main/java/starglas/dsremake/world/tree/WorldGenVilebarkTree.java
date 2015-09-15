package starglas.dsremake.world.tree;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;
import starglas.dsremake.block.ModBlocks;

public class WorldGenVilebarkTree extends WorldGenAbstractTree
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;

    public WorldGenVilebarkTree(boolean p_i2028_1_, int p_i2028_2_)
    {
        super(p_i2028_1_);
        this.minTreeHeight = p_i2028_2_;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        int l = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (y >= 1 && y + l + 1 <= 256)
        {
            byte b0;
            int k1;
            Block block;

            for (int i1 = y; i1 <= y + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == y)
                {
                    b0 = 0;
                }

                if (i1 >= y + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1)
                {
                    for (k1 = z - b0; k1 <= z + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            block = world.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(world, j1, i1, k1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = world.getBlock(x, y - 1, z);
                int i = 1;
                boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && y < 256 - l - 1)
                {
                    block2.onPlantGrow(world, x, y - 1, z, x, y, z);

                    for (k1 = 0; k1 < l; ++k1)
                    {
                        block = world.getBlock(x, y + k1, z);

                        if (block.isAir(world, x, y + k1, z) || block.isLeaves(world, x, y + k1, z))
                        {
                            this.setBlockAndNotifyAdequately(world, x, y + k1, z, ModBlocks.vilebarkBlock, 0);
                            if(k1 > 4){

                                for(int k2 = k1; k2 < l; k2++) {
                                    i++;
                                    this.setBlockAndNotifyAdequately(world, x = i, y + k1, z + i, ModBlocks.vilebarkBlock, 0);
                                }
                            }
                        }
                    }
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}