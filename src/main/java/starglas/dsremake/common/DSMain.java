package starglas.dsremake.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import org.apache.logging.log4j.Logger;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.fluids.ModFluids;
import starglas.dsremake.handler.*;
import starglas.dsremake.items.ModItems;
import starglas.dsremake.items.ModRecipes;
import starglas.dsremake.network.PacketHandler;
import starglas.dsremake.world.ChunkProviderGenerator;
import starglas.dsremake.world.WorldGenClass;
import starglas.dsremake.world.WorldTypeDSRemake;
import starglas.dsremake.world.biome.BiomeRegistry;


@Mod(modid = ModVars.MODID, name = ModVars.NAME, version = ModVars.VERSION)

public class DSMain {
	
	@Mod.Instance(ModVars.MODID)
	public static DSMain instance;
	
	@SidedProxy(clientSide="starglas.dsremake.client.ClientProxy", serverSide="starglas.dsremake.common.CommonProxy")
	public static CommonProxy proxy;

	public static Logger log;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PacketHandler.init();

		ModItems.init();
		ModFluids.init(); // Fluids go before blocks
		ModBlocks.init();
		DSMainCreativeTabs.RegisterTabs();
		ModRecipes.init();
		ChestGenHandler.init(); // Gen Handler for chest loot

		WorldGenClass.init();
		BiomeRegistry.init();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		MinecraftForge.EVENT_BUS.register(new DSRemakeBucketFill());
		FMLCommonHandler.instance().bus().register(new NetworkEventHandler());
		MinecraftForge.EVENT_BUS.register(new DSRemakeEventHandler());

		proxy.registerProxies();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) { // Init nice and clean because of seperate classes that init in the preInit class
		GameRegistry.registerWorldGenerator(new ChunkProviderGenerator(), 0);
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
		FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(FluidRegistry.getFluidStack(ModFluids.fluidPoison.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModFluids.PoisonBucket), new ItemStack(Items.bucket)));
		WorldType DSREMAKE = new WorldTypeDSRemake(10, "DSRemake");
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		// register server commands
		event.registerServerCommand(new CommandCheatLevel());
	}
}