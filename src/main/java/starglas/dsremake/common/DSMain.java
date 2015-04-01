package starglas.dsremake.common;
// All imports are comming here. But I am lazy so CTRL + SHIFT + O for auto imports
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "tutorial", name = "Tutorial Mod", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class DSMain {
	
	@Instance("tutorial")
	public static DSMain instance;
	
	@SidedProxy(clientSide="starglas.dsremake.client.ClientProxy", serverSide="starglas.dsremake.common.CommonProxy")
	public static CommonProxy proxy;
	
	// Declaring vars
	
	// Blocks
	public static Block myFirstBlock;
	
	// Items
	public static Item myFirstItem;
	public static Item MK1HeartStone;
	public static Item MK1VitaCrystal;
	public static Item MK2VitaCrystal;
	public static Item MK3VitaCrystal;
	public static Item MK4VitaCrystal;
	public static Item MK5VitaCrystal;
	// Tools
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) { // Init almost everything go's in here
		
		// Creating creative tabs
		//public static CreativeTabs DSRemakeConsumebleTab - new CreateCreativeTab(CreativeTabs.getNextID(), "DSRemake Consumeble Tab");
		
		// Registering of blocks
		myFirstBlock = (new BlockFirst(538, Material.rock)).setUnlocalizedName("myFirstBlock");
		
		// Registering of items
		myFirstItem = (new ItemFirst(900)).setUnlocalizedName("myFirstItem");
		//MK1HeartStone = (new HeartStone(900)).setUnlocalizedName("MK1HeartStone");
		
		// Vita crystals
		MK1VitaCrystal = (new VitaCrystal(901,"dsremake:MK1vita")).setUnlocalizedName("MK1VitaCrystal");
		MK2VitaCrystal = (new VitaCrystal(902,"dsremake:MK2vita")).setUnlocalizedName("MK2VitaCrystal");
		MK3VitaCrystal = (new VitaCrystal(903,"dsremake:MK3vita")).setUnlocalizedName("MK3VitaCrystal");
		MK4VitaCrystal = (new VitaCrystal(904,"dsremake:MK4vita")).setUnlocalizedName("MK4VitaCrystal");
		MK5VitaCrystal = (new VitaCrystal(905,"dsremake:MK5vita")).setUnlocalizedName("MK5VitaCrystal");
		
		// Language shit
		
		// BLocks
		
		LanguageRegistry.addName(myFirstBlock, "My first block");
		GameRegistry.registerBlock(myFirstBlock, "My First Block");
		
		//Items
		LanguageRegistry.addName(myFirstItem, "My first item");
		
		//Vita Crystals
		LanguageRegistry.addName(MK1VitaCrystal, "Small Vita Crystal");
		LanguageRegistry.addName(MK2VitaCrystal, "Medium Vita Crystal");
		LanguageRegistry.addName(MK3VitaCrystal, "Large Vita Crystal");
		LanguageRegistry.addName(MK4VitaCrystal, "Giant Vita Crystal");
		LanguageRegistry.addName(MK5VitaCrystal, "Legendary Vita Crystal");

		// Tabs
		
	}

	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}