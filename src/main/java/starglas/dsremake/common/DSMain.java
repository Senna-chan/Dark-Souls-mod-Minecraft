package starglas.dsremake.common;
// All imports are coming here. But I am lazy so CTRL + SHIFT + O for auto imports
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.common.items.ModRecipes;
import starglas.dsremake.handler.DSPlayerHandler;
import starglas.dsremake.handler.DSRemakeEventHandler;
import starglas.dsremake.handler.GUIHandler;
import starglas.dsremake.handler.TickEvents;
import starglas.dsremake.packet.PacketPipeline;
import starglas.dsremake.world.WorldGenClass;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class DSMain {
	
	@Mod.Instance(Reference.MODID)
	public static DSMain instance;
	
	
	@SidedProxy(clientSide="starglas.dsremake.client.ClientProxy", serverSide="starglas.dsremake.common.CommonProxy")
	public static CommonProxy proxy;
	
	//public static PacketPipeline packetpipeline = new PacketPipeline();
	
	DSRemakeEventHandler handler = new DSRemakeEventHandler();
	
	TickEvents tickevents = new TickEvents();
	// Declaring vars
	
	
	public static ToolMaterial DSRemake = EnumHelper.addToolMaterial("DSRemake", 0, 1000, -40.0F, 0, 0);
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//packetpipeline.initialize();
		ModItems.init();
		ModBlocks.init();
		CreateCreativeTab.RegisterTabs();
		ModRecipes.init();
		WorldGenClass.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		
		proxy.registerProxies();
		MinecraftForge.EVENT_BUS.register(new DSRemakeEventHandler());
		FMLCommonHandler.instance().bus().register(new DSRemakeEventHandler());
		FMLCommonHandler.instance().bus().register(new TickEvents());
		//new GUIHandler();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) { // Init nice and clean because of seperate classes that init in the preInit class
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//packetpipeline.postInitialize();
	}
}