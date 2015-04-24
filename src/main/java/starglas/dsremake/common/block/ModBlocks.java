package starglas.dsremake.common.block;

import net.minecraft.block.Block;
import starglas.dsremake.common.helpers.RegisterHelper;


public class ModBlocks{
	
	public static Block BloodstoneshardOre;
	public static Block blockBonfire;
	public static Block BloodstonechipOre;
	public static void init(){

		blockBonfire = new BlockBonfire().setBlockName("blockBonfire");
		BloodstonechipOre = new BloodstoneOre(1).setBlockName("blockBloodstonechipOre");
		BloodstoneshardOre = new BloodstoneOre(2).setBlockName("blockBloodstoneshardOre");
		RegisterHelper.registerBlock(blockBonfire);
		RegisterHelper.registerBlock(BloodstonechipOre);
		RegisterHelper.registerBlock(BloodstoneshardOre);
		
	}
}