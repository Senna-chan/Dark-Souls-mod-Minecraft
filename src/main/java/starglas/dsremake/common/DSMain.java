package starglas.dsremake.common;
// All imports are coming here. But I am lazy so CTRL + SHIFT + O for auto imports
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.common.items.ModRecipes;
import starglas.dsremake.world.WorldGenClass;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class DSMain {
	
	public static DSMain instance;
	
	@SidedProxy(clientSide="starglas.dsremake.client.ClientProxy", serverSide="starglas.dsremake.common.CommonProxy")
	public static CommonProxy proxy;
	
	// Declaring vars
	
	
	public static ToolMaterial DSRemake = EnumHelper.addToolMaterial("DSRemake", 0, 1000, -40.0F, 0, 0);
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		CreateCreativeTab.RegisterTabs();
		ModRecipes.init();
		WorldGenClass.init();
		proxy.registerRenderers();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) { // Init nice and clean because of seperate classes that init in the preInit class
		
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}