package starglas.dsremake.common.block;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.renderer.RendererBonfire;
import net.minecraft.block.Block;


public class ModBlocks{
	
	public static Block blockBonfire;
	public static Block blockTest;
		
	public static void init(){

		blockBonfire = new BlockBonfire().setBlockName("blockBonfire");
		blockTest = new BlockSnowball().setBlockName("blockTest");
		RegisterHelper.registerBlock(blockBonfire);
		RegisterHelper.registerBlock(blockTest);
		
		
		
	}
}