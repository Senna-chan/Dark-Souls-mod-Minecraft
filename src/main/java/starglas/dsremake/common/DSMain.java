package starglas.dsremake.common;
// All imports are comming here. But I am lazy so CTRL + SHIFT + O for auto imports
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.ModItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
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
	public static Block myFirstBlock;
	
	public static CreativeTabs tabDSConsume = new CreateCreativeTab(CreativeTabs.getNextID(), "tabDSConsume","DSRemake consumebles");
	public static ToolMaterial DSRemake = EnumHelper.addToolMaterial("DSRemake", 0, 1000, -40.0F, 0, 0);
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) { // Init almost everything go's in here
		// Creating creative tabs
		
		
		// Registering of blocks
		
		// Registering of items
		
		

		
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}