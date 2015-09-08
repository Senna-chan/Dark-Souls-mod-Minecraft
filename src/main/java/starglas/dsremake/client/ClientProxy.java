package starglas.dsremake.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.item.Item;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.client.render.block.BlockRendererBloodstoneOre;
import starglas.dsremake.client.render.block.BlockRendererBonfire;
import starglas.dsremake.client.render.block.BlockRendererSmallChest;
import starglas.dsremake.client.render.item.*;
import starglas.dsremake.client.render.mob.RenderDeadsapsprout;
import starglas.dsremake.client.render.mob.RenderVilerevenant;
import starglas.dsremake.client.render.projectile.RenderWoodengreatarrow;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.entity.mobs.creature.EntityDeadsapsprout;
import starglas.dsremake.entity.mobs.trader.EntityVilerevenant;
import starglas.dsremake.entity.projectiles.arrows.EntityWoodengreatarrow;
import starglas.dsremake.entity.tileentity.TileEntityBloodstoneOre;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.entity.tileentity.TileEntitySmallChest;
import starglas.dsremake.handler.KeyHandler;
import starglas.dsremake.items.ModItems;

public class ClientProxy extends CommonProxy {
	public void registerProxies(){
		ModHelper.registerRender(ModItems.longSword, new ItemRendererLongSword());
		ModHelper.registerRender(Item.getItemFromBlock(ModBlocks.bonfire), new ItemRendererBlockBonfire());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, new BlockRendererBonfire());
		ModHelper.registerRender(ModItems.PaladinGlaive, new ItemRendererPaladinGlaive());
		ModHelper.registerRender(ModItems.Estus, new ItemRendererEstus());
		ModHelper.registerRender(ModItems.SanctifiedGreathammer, new ItemRendererSancitiedGreatHammer());
		ModHelper.registerRender(ModItems.GyroDrill, new ItemRendererGyroDrill());
		ModHelper.registerRender(ModItems.WoodenGreatArrow, new ItemRendererWoodenGreatArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityDeadsapsprout.class, new RenderDeadsapsprout());
		RenderingRegistry.registerEntityRenderingHandler(EntityVilerevenant.class, new RenderVilerevenant());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodengreatarrow.class, new RenderWoodengreatarrow());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallChest.class, new BlockRendererSmallChest());
		
		ModHelper.registerRender(Item.getItemFromBlock(ModBlocks.bloodstoneOre), new ItemRendererBloodStoneOre());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBloodstoneOre.class, new BlockRendererBloodstoneOre());
		
		FMLCommonHandler.instance().bus().register(new KeyHandler()); // Reg key and event for keystuff
	}
}