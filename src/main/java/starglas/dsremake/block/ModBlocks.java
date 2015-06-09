package starglas.dsremake.block;

import net.minecraft.block.Block;
import starglas.dsremake.common.helpers.ModHelper;


public class ModBlocks{
	
	public static Block blockBonfire;
	public static Block BloodstoneOre;
	public static Block blockSmallChest;
	public static void init(){

		blockBonfire = new BlockBonfire().setBlockName("blockBonfire");
		BloodstoneOre = new BloodstoneOre().setBlockName("blockBloodstoneOre");
		blockSmallChest = new BlockSmallChest().setBlockName("blockSmallChest");
		ModHelper.registerBlock(blockBonfire);
		ModHelper.registerBlock(BloodstoneOre);
		ModHelper.registerBlock(blockSmallChest);
		
	}
}