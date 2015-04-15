package starglas.dsremake.common.block;

import net.minecraft.block.Block;
import starglas.dsremake.common.helpers.RegisterHelper;


public class ModBlocks{
	
	public static Block blockBonfire;
	public static Block testBlock;
	public static void init(){

		blockBonfire = new BlockBonfire().setBlockName("blockBonfire");
		
		RegisterHelper.registerBlock(blockBonfire);
		
		
		
	}
}