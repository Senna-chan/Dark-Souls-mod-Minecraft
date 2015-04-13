package starglas.dsremake.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.block.TileEntityBonfire;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.renderer.ItemRendererBlockBonfire;
import starglas.dsremake.renderer.ItemRendererHeartStone;
import starglas.dsremake.renderer.ItemRendererLongSword;
import starglas.dsremake.renderer.ItemRendererPaladinGlaive;
import starglas.dsremake.renderer.RendererBonfire;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	public void registerRenderers(){
		RegisterHelper.registerRender(ModItems.longSword, (IItemRenderer)new ItemRendererLongSword());
		RegisterHelper.registerRender(Item.getItemFromBlock(ModBlocks.blockBonfire), (IItemRenderer)new ItemRendererBlockBonfire());
		GameRegistry.registerTileEntity(TileEntityBonfire.class, "blockBonfire");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, new RendererBonfire());
		RegisterHelper.registerRender(ModItems.PaladinGlaive, new ItemRendererPaladinGlaive());
		RegisterHelper.registerRender(ModItems.MK1HeartStone, new ItemRendererHeartStone());
		
	}
}