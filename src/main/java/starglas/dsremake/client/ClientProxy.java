package starglas.dsremake.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.client.render.RenderWoodengreatarrow;
import starglas.dsremake.client.render.block.BlockRendererBloodstoneOre;
import starglas.dsremake.client.render.block.BlockRendererBonfire;
import starglas.dsremake.client.render.block.BlockRendererSmallChest;
import starglas.dsremake.client.render.item.ItemRendererBlockBonfire;
import starglas.dsremake.client.render.item.ItemRendererBloodStoneOre;
import starglas.dsremake.client.render.item.ItemRendererEstus;
import starglas.dsremake.client.render.item.ItemRendererGyroDrill;
import starglas.dsremake.client.render.item.ItemRendererLongSword;
import starglas.dsremake.client.render.item.ItemRendererPaladinGlaive;
import starglas.dsremake.client.render.item.ItemRendererSancitiedGreatHammer;
import starglas.dsremake.client.render.mob.RenderDeadsapsprout;
import starglas.dsremake.client.render.mob.RenderVilerevenant;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.entity.arrows.EntityWoodengreatarrow;
import starglas.dsremake.entity.mobs.EntityDeadsapsprout;
import starglas.dsremake.entity.mobs.EntityVilerevenant;
import starglas.dsremake.entity.tileentity.TileEntityBloodstoneOre;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.entity.tileentity.TileEntitySmallChest;
import starglas.dsremake.handler.KeyHandler;
import starglas.dsremake.items.ModItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	public void registerProxies(){
		ModHelper.registerRender(ModItems.longSword, (IItemRenderer)new ItemRendererLongSword());
		ModHelper.registerRender(Item.getItemFromBlock(ModBlocks.bonfire), (IItemRenderer)new ItemRendererBlockBonfire());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, new BlockRendererBonfire());
		ModHelper.registerRender(ModItems.PaladinGlaive, new ItemRendererPaladinGlaive());
		ModHelper.registerRender(ModItems.Estus, new ItemRendererEstus());
		ModHelper.registerRender(ModItems.SanctifiedGreathammer, new ItemRendererSancitiedGreatHammer());
		ModHelper.registerRender(ModItems.GyroDrill, new ItemRendererGyroDrill());
		RenderingRegistry.registerEntityRenderingHandler(EntityDeadsapsprout.class, new RenderDeadsapsprout());
		RenderingRegistry.registerEntityRenderingHandler(EntityVilerevenant.class, new RenderVilerevenant());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodengreatarrow.class, new RenderWoodengreatarrow());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallChest.class, new BlockRendererSmallChest());
		
		ModHelper.registerRender(Item.getItemFromBlock(ModBlocks.bloodstoneOre), (IItemRenderer)new ItemRendererBloodStoneOre());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBloodstoneOre.class, new BlockRendererBloodstoneOre());
		
		FMLCommonHandler.instance().bus().register(new KeyHandler()); // Reg key and event for keystuff
	}
}