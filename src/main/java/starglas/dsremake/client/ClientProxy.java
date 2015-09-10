package starglas.dsremake.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
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
import starglas.dsremake.entity.tileentity.TileEntityDSAnvil;
import starglas.dsremake.entity.tileentity.TileEntitySmallChest;
import starglas.dsremake.handler.KeyHandler;
import starglas.dsremake.items.ModItems;

public class ClientProxy extends CommonProxy {
	public void registerProxies(){

		// Block rendering
		ModHelper.registerBlockRender(TileEntityBonfire.class, new BlockRendererBonfire());
		ModHelper.registerBlockRender(TileEntityBloodstoneOre.class, new BlockRendererBloodstoneOre());
		ModHelper.registerBlockRender(TileEntityDSAnvil.class, new BlockRendererBloodstoneOre());


		// Item rendering
		ModHelper.registerItemRender(ModBlocks.bonfire, new ItemRendererBlockBonfire());
		ModHelper.registerItemRender(ModBlocks.bloodstoneOre, new ItemRendererBloodStoneOre());
		ModHelper.registerItemRender(ModItems.PaladinGlaive, new ItemRendererPaladinGlaive());
		ModHelper.registerItemRender(ModItems.Estus, new ItemRendererEstus());
		ModHelper.registerItemRender(ModItems.SanctifiedGreathammer, new ItemRendererSancitiedGreatHammer());
		ModHelper.registerItemRender(ModItems.GyroDrill, new ItemRendererGyroDrill());
		ModHelper.registerItemRender(ModItems.WoodenGreatArrow, new ItemRendererWoodenGreatArrow());
		ModHelper.registerItemRender(ModItems.longSword, new ItemRendererLongSword());

		// Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityDeadsapsprout.class, new RenderDeadsapsprout());
		RenderingRegistry.registerEntityRenderingHandler(EntityVilerevenant.class, new RenderVilerevenant());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodengreatarrow.class, new RenderWoodengreatarrow());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallChest.class, new BlockRendererSmallChest());
		

		
		FMLCommonHandler.instance().bus().register(new KeyHandler()); // Reg key and event for keystuff
	}
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		// Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
		// your packets will not work because you will be getting a client
		// player even when you are on the server! Sounds absurd, but it's true.

		// Solution is to double-check side before returning the player:
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}