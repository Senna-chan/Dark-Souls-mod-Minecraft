package starglas.dsremake.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.block.TileEntityBonfire;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.renderer.ItemRendererBlockBonfire;
import starglas.dsremake.renderer.ItemRendererLongSword;
import starglas.dsremake.renderer.ItemRendererPaladinGlaive;
import starglas.dsremake.renderer.RendererBonfire;
import starglas.dsremake.renderer.ItemRendererLance;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	public void registerRenderers(){
		MinecraftForgeClient.registerItemRenderer(ModItems.longSword, (IItemRenderer)new ItemRendererLongSword());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockBonfire), (IItemRenderer)new ItemRendererBlockBonfire());
		GameRegistry.registerTileEntity(TileEntityBonfire.class, "blockBonfire");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, new RendererBonfire());
		RegisterHelper.registerRender(ModItems.PaladinGlaive, new ItemRendererPaladinGlaive());
		MinecraftForgeClient.registerItemRenderer(ModItems.MK1BloodStone, new ItemRendererLance());
		
	}
}