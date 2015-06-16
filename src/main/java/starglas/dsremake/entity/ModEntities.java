package starglas.dsremake.entity;

import starglas.dsremake.client.render.RenderWoodengreatarrow;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.entity.arrows.EntityWoodengreatarrow;
import starglas.dsremake.entity.mobs.EntityDeadsapsprout;
import starglas.dsremake.entity.mobs.EntityVilerevenant;
import starglas.dsremake.entity.tileentity.TileEntityBloodstoneOre;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.entity.tileentity.TileEntitySmallChest;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModEntities {
	public static void init() {
		ModHelper.createEntity(EntityDeadsapsprout.class, "DeadsapSprout", 0xD5CADB, 0x970AF0);
		ModHelper.createEntity(EntityVilerevenant.class, "VileRevenant", 0x7C4E00, 0x670075);
		// Fix for error cuz CommonProxy won't work well 
		GameRegistry.registerTileEntity(TileEntityBonfire.class, "blockBonfire");
		GameRegistry.registerTileEntity(TileEntitySmallChest.class, "blockSmallChest");
		GameRegistry.registerTileEntity(TileEntityBloodstoneOre.class, "BloodstoneOre");
		
	}
}
