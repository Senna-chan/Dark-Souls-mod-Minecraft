package telinc.tutorialmod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
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

public class TutorialMain {
	
	@Instance("tutorial")
	public static TutorialMain instance;
	
	@SidedProxy(clientSide="telinc.tutorialmod.client.TutorialClientProxy", serverSide="telinc.tutorialmod.common.TutorialCommonProxy")
	public static TutorialCommonProxy proxy;
	
	public static Block myFirstBlock;
	
	public static Item myFirstItem;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		myFirstBlock = (new BlockFirst(538, Material.rock)).setUnlocalizedName("myFirstBlock");
		LanguageRegistry.addName(myFirstBlock, "My first block");
		MinecraftForge.setBlockHarvestLevel(myFirstBlock, "pickaxe", 3);
		GameRegistry.registerBlock(myFirstBlock, "My First Block");
		
		myFirstItem = (new ItemFirst(900)).setUnlocalizedName("myFirstItem");
		LanguageRegistry.addName(myFirstItem, "My first item");
	}

	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}