package starglas.dsremake.block;

import net.minecraft.block.Block;
import starglas.dsremake.common.helpers.ModHelper;


public class ModBlocks{
	
	public static Block bonfire = new BlockBonfire().setBlockName("blockBonfire");
	public static Block bloodstoneOre = new BloodstoneOre().setBlockName("blockBloodstoneOre");
	public static Block smallChest = new BlockSmallChest().setBlockName("blockSmallChest");
	public static Block desertBlock = new TempleBlock("desertblock").setBlockName("desertBlock");
	public static Block vilebarkBlock = new TempleBlock("vilebarkblock").setBlockName("vilebarkBlock");
	public static Block taintBlock = new TempleBlock("taintblock").setBlockName("taintBlock");
	public static Block ashBlock = new TempleBlock("ashblock").setBlockName("ashblock");


	public static void init(){

		ModHelper.registerBlock(desertBlock);
		ModHelper.registerBlock(vilebarkBlock);
		ModHelper.registerBlock(ashBlock);
		ModHelper.registerBlock(taintBlock);
		
		ModHelper.registerBlock(bonfire);
		ModHelper.registerBlock(bloodstoneOre);
		ModHelper.registerBlock(smallChest);
		
	}
}