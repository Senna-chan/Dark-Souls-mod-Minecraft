package starglas.dsremake.common.block;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.renderer.RendererBonfire;
import net.minecraft.block.Block;


public class ModBlocks{
	
	public static Block blockBonfire;
		
	public static void init(){

		blockBonfire = new BlockBonfire().setBlockName("blockBonfire");
		
		RegisterHelper.registerBlock(blockBonfire);
		
		GameRegistry.registerTileEntity(TileEntityBonfire.class, "blockBonfire");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, new RendererBonfire());
		
	}
}