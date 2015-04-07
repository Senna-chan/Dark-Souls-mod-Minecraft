package starglas.dsremake.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.renderer.ItemRendererLongSword;

public class ClientProxy extends CommonProxy {
	public void registerRenderers(){
		MinecraftForgeClient.registerItemRenderer(ModItems.longSword, (IItemRenderer)new ItemRendererLongSword());
	}
}