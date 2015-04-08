package starglas.dsremake.common.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.renderer.ItemRendererTest;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper
{
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, Reference.MODID + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, Reference.MODID + item.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Item item, IItemRenderer toRender){
		MinecraftForgeClient.registerItemRenderer(item , toRender);
	}
}