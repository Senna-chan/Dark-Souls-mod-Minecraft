package starglas.dsremake.common;
// All imports are coming here. But I am lazy so CTRL + SHIFT + O for auto imports
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class DSMain {
	
	public static DSMain instance;
	
	@SidedProxy(clientSide="starglas.dsremake.client.ClientProxy", serverSide="starglas.dsremake.common.CommonProxy")
	public static CommonProxy proxy;
	
	// Declaring vars
	
	// Blocks
	
	public static CreativeTabs tabDSConsume = new CreateCreativeTab(CreativeTabs.getNextID(), "tabDSConsume",ModItems.Estus);
	public static CreativeTabs tabDSSwords = new CreateCreativeTab(CreativeTabs.getNextID(), "tabDSSwords",ModItems.longSword);
	public static CreativeTabs tabDSHalberts = new CreateCreativeTab(CreativeTabs.getNextID(), "tabDSHalberts",ModItems.PaladinGlaive);
	public static CreativeTabs tabDSBlocks = new CreateCreativeTab(CreativeTabs.getNextID(), "tabDSBlocks", ModItems.MK1BloodStone);
	public static ToolMaterial DSRemake = EnumHelper.addToolMaterial("DSRemake", 0, 1000, -40.0F, 0, 0);
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		proxy.registerRenderers();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) { // Init almost everything go's in here
		
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}