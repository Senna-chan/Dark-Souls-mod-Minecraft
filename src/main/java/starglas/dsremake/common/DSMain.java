package starglas.dsremake.common;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.entity.ModEntities;
import starglas.dsremake.handler.DSRemakeEventHandler;
import starglas.dsremake.handler.GUIHandler;
import starglas.dsremake.handler.TickEvents;
import starglas.dsremake.items.ModItems;
import starglas.dsremake.items.ModRecipes;
import starglas.dsremake.packet.PacketPipeline;
import starglas.dsremake.world.WorldGenClass;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModReference.MODID, name = ModReference.NAME, version = ModReference.VERSION)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class DSMain {
	
	@Mod.Instance(ModReference.MODID)
	public static DSMain instance;
	
	
	@SidedProxy(clientSide="starglas.dsremake.client.ClientProxy", serverSide="starglas.dsremake.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	DSRemakeEventHandler handler = new DSRemakeEventHandler();
	
	TickEvents tickevents = new TickEvents();
	// Declaring vars
	
	
	public static ToolMaterial DSRemake = EnumHelper.addToolMaterial("DSRemake", 0, 1000, -40.0F, 0, 0);
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		packetPipeline.initialise();
		ModItems.init();
		ModBlocks.init();
		DSMainCreativeTabs.RegisterTabs();
		ModRecipes.init();
		WorldGenClass.init();
		ModEntities.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		
		FMLCommonHandler.instance().bus().register(new TickEvents());
		proxy.registerProxies();
		//new GUIHandler();
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) { // Init nice and clean because of seperate classes that init in the preInit class
		MinecraftForge.EVENT_BUS.register(new DSRemakeEventHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		packetPipeline.postInitialise();
	}
}