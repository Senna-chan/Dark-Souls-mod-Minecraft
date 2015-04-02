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
	public static Item MK2HeartStone;
	public static Item MK3HeartStone;
	public static Item MK1VitaCrystal;
	public static Item MK2VitaCrystal;
	public static Item MK3VitaCrystal;
	public static Item MK4VitaCrystal;
	public static Item MK5VitaCrystal;
	// Tools
	
	
	public static CreativeTabs tabDSConsume = new CreateCreativeTab(CreativeTabs.getNextID(), "tabDSConsume","DSRemake consumebles");
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) { // Init almost everything go's in here
		
		// Creating creative tabs
		
		
		// Registering of blocks
		myFirstBlock = (new BlockFirst(538, Material.rock)).setUnlocalizedName("myFirstBlock");
		
		// Registering of items
		myFirstItem = (new ItemFirst(900)).setUnlocalizedName("myFirstItem");
		MK1HeartStone = (new HeartStone(901,"dsremake:MK1Heart",1)).setUnlocalizedName("MK1HeartStone");
		MK2HeartStone = (new HeartStone(902,"dsremake:MK2Heart",2)).setUnlocalizedName("MK2HeartStone");
		MK3HeartStone = (new HeartStone(903,"dsremake:MK3Heart",3)).setUnlocalizedName("MK3HeartStone");
		
		// Vita crystals
		MK1VitaCrystal = (new VitaCrystal(910,"dsremake:MK1vita",1)).setUnlocalizedName("MK1VitaCrystal");
		MK2VitaCrystal = (new VitaCrystal(911,"dsremake:MK2vita",2)).setUnlocalizedName("MK2VitaCrystal");
		MK3VitaCrystal = (new VitaCrystal(912,"dsremake:MK3vita",3)).setUnlocalizedName("MK3VitaCrystal");
		MK4VitaCrystal = (new VitaCrystal(913,"dsremake:MK4vita",4)).setUnlocalizedName("MK4VitaCrystal");
		MK5VitaCrystal = (new VitaCrystal(914,"dsremake:MK5vita",5)).setUnlocalizedName("MK5VitaCrystal");
		
		// Language shit
		
		// BLocks
		
		LanguageRegistry.addName(myFirstBlock, "My first block");
		GameRegistry.registerBlock(myFirstBlock, "My First Block");
		
		//Item
		LanguageRegistry.addName(myFirstItem, "My first item");
		
		// Heart Gems
		LanguageRegistry.addName(MK1HeartStone, "Heart Stone");
		LanguageRegistry.addName(MK2HeartStone, "Incandescent Heart Stone");
		LanguageRegistry.addName(MK3HeartStone, "Radiant Heart Stone");
		
		//Vita Crystals
		LanguageRegistry.addName(MK1VitaCrystal, "Small Vita Crystal");
		LanguageRegistry.addName(MK2VitaCrystal, "Medium Vita Crystal");
		LanguageRegistry.addName(MK3VitaCrystal, "Large Vita Crystal");
		LanguageRegistry.addName(MK4VitaCrystal, "Giant Vita Crystal");
		LanguageRegistry.addName(MK5VitaCrystal, "Legendary Vita Crystal");

	}

	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}