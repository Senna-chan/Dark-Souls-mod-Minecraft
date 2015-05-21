package starglas.dsremake.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import starglas.dsremake.client.render.BlockRendererBloodstoneOre;
import starglas.dsremake.client.render.BlockRendererBonfire;
import starglas.dsremake.client.render.BlockRendererSmallChest;
import starglas.dsremake.client.render.ItemRendererBlockBonfire;
import starglas.dsremake.client.render.ItemRendererBloodStoneOre;
import starglas.dsremake.client.render.ItemRendererEstus;
import starglas.dsremake.client.render.ItemRendererGyroDrill;
import starglas.dsremake.client.render.ItemRendererLongSword;
import starglas.dsremake.client.render.ItemRendererPaladinGlaive;
import starglas.dsremake.client.render.ItemRendererSancitiedGreatHammer;
import starglas.dsremake.client.render.ItemRendererSmallChest;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.entity.TileEntityBloodstoneOre;
import starglas.dsremake.common.entity.TileEntityBonfire;
import starglas.dsremake.common.entity.TileEntitySmallChest;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.ModItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	public void registerProxies(){
		RegisterHelper.registerRender(ModItems.longSword, (IItemRenderer)new ItemRendererLongSword());
		RegisterHelper.registerRender(Item.getItemFromBlock(ModBlocks.blockBonfire), (IItemRenderer)new ItemRendererBlockBonfire());
		GameRegistry.registerTileEntity(TileEntityBonfire.class, "blockBonfire");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, new BlockRendererBonfire());
		RegisterHelper.registerRender(ModItems.PaladinGlaive, new ItemRendererPaladinGlaive());
		RegisterHelper.registerRender(ModItems.Estus, new ItemRendererEstus());
		RegisterHelper.registerRender(ModItems.SanctifiedGreathammer, new ItemRendererSancitiedGreatHammer());
		RegisterHelper.registerRender(ModItems.GyroDrill, new ItemRendererGyroDrill());
		RegisterHelper.registerRender(Item.getItemFromBlock(ModBlocks.blockSmallChest), (IItemRenderer)new ItemRendererSmallChest());
		GameRegistry.registerTileEntity(TileEntitySmallChest.class, "blockSmallChest");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallChest.class, new BlockRendererSmallChest());
		
		RegisterHelper.registerRender(Item.getItemFromBlock(ModBlocks.BloodstoneOre), (IItemRenderer)new ItemRendererBloodStoneOre());
		GameRegistry.registerTileEntity(TileEntityBloodstoneOre.class, "BloodstoneOre");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBloodstoneOre.class, new BlockRendererBloodstoneOre());
		
		
	}
}