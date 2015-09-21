package starglas.dsremake.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.mobs.creature.EntityDeadsapsprout;
import starglas.dsremake.entity.mobs.trader.EntityVilerevenant;
import starglas.dsremake.entity.projectiles.arrows.EntityWoodengreatarrow;
import starglas.dsremake.entity.tileentity.TileEntityBloodstoneOre;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.entity.tileentity.TileEntityDynaTiloTrading;
import starglas.dsremake.entity.tileentity.TileEntitySmallChest;

public class ModEntities {
	public static void init() {

		ModHelper.createEntity(EntityDeadsapsprout.class, "DeadsapSprout", 0xD5CADB, 0x970AF0, EnumCreatureType.creature, BiomeGenBase.birchForest.birchForestHills.plains);
		ModHelper.createEntity(EntityVilerevenant.class, "VileRevenant", 0x7C4E00, 0x670075);

		GameRegistry.registerTileEntity(TileEntityBonfire.class, "bonfire");
		GameRegistry.registerTileEntity(TileEntitySmallChest.class, "smallchest");
		GameRegistry.registerTileEntity(TileEntityBloodstoneOre.class, "bloodstone");
		GameRegistry.registerTileEntity(TileEntityDynaTiloTrading.class, "dynatilo");

		EntityRegistry.registerModEntity(EntityWoodengreatarrow.class, "WoodenGreatArrow", EntityRegistry.findGlobalUniqueEntityId(), ModVars.MODID, 128, 1, true);
		
	}
}
