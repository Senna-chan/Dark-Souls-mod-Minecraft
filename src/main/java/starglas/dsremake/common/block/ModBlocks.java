package starglas.dsremake.common.block;

import net.minecraft.block.Block;
import starglas.dsremake.common.helpers.RegisterHelper;


public class ModBlocks{
	
	public static Block blockBonfire;
	public static Block BloodstoneOre;
	public static Block blockSmallChest;
	public static void init(){

		blockBonfire = new BlockBonfire().setBlockName("blockBonfire");
		BloodstoneOre = new BloodstoneOre().setBlockName("blockBloodstoneOre");
		blockSmallChest = new BlockSmallChest().setBlockName("blocksmallchest");
		RegisterHelper.registerBlock(blockBonfire);
		RegisterHelper.registerBlock(BloodstoneOre);
		RegisterHelper.registerBlock(blockSmallChest);
		
	}
}