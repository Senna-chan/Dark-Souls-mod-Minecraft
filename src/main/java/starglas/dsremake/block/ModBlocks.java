package starglas.dsremake.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import starglas.dsremake.common.helpers.ModHelper;


public class ModBlocks{
	
	public static Block bonfire = new BlockBonfire().setBlockName("blockBonfire");
	public static Block bloodstoneOre = new BloodstoneOre().setBlockName("blockBloodstoneOre");
	public static Block smallChest = new BlockSmallChest().setBlockName("blockSmallChest");
	public static Block desertBlock = new GenericBlock("desertblock").setBlockName("desertBlock");

	public static Block taintBlock = new GenericBlock("taintblock").setBlockName("taintBlock");
	public static Block ashBlock = new GenericBlock("ashblock").setBlockName("ashblock");
	public static Block dsAnvil = new DSAnvil().setBlockName("dsAnvil");

	public static Block vilebarkBlock = new VilebarkLog().setBlockName("vilebarkBlock");
	public static Block vilebarkSapling = new VilebarkSapling().setBlockName("vilebarkSapling");

	public static Block dynaTiloTrading = new DynaTiloTrading().setBlockName("dynaTiloTrading");


	public static void init(){

		ModHelper.registerBlock(desertBlock);
		ModHelper.registerBlock(ashBlock);
		ModHelper.registerBlock(taintBlock);

		ModHelper.registerBlock(vilebarkBlock);
		ModHelper.registerBlock(vilebarkSapling);
		
		ModHelper.registerBlock(bonfire);
		ModHelper.registerBlock(bloodstoneOre);
		ModHelper.registerBlock(smallChest);

		ModHelper.registerBlock(dsAnvil);

		ModHelper.registerBlock(dynaTiloTrading);
		
	}
}