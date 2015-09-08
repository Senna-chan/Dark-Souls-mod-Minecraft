package starglas.dsremake.common.helpers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.items.ModItems;

public class DSMainCreativeTabs
{
	public static CreativeTabs tabDSConsume = new CreativeTabs("tabDSConsume"){
		@Override
		public Item getTabIconItem(){
			return ModItems.Estus;
		}
	};
	public static CreativeTabs tabDSBlocks = new CreativeTabs("tabDSBlocks"){
		@Override
		public Item getTabIconItem(){
			return Item.getItemFromBlock(ModBlocks.bonfire);
		}
	};
	public static CreativeTabs tabDSSwords = new CreativeTabs("tabDSSwords"){
		@Override
		public Item getTabIconItem(){
			return ModItems.Estus;
		}
	};
	public static CreativeTabs tabDSHalberts = new CreativeTabs("tabDSHalberts"){
		@Override
		public Item getTabIconItem(){
			return ModItems.Estus;
		}
	};
	public static CreativeTabs tabDSUpgrade = new CreativeTabs("tabDSUpgrade"){
		@Override
		public Item getTabIconItem(){
			return ModItems.MadmansKnowledge;
		}
	};
	
	public static CreativeTabs tabDSGreatHammers = new CreativeTabs("tabDSGreatHammers"){
		@Override
		public Item getTabIconItem(){
			return ModItems.SanctifiedGreathammer;
		}
	};
	public static CreativeTabs tabDSFists = new CreativeTabs("tabDSFists"){
		@Override
		public Item getTabIconItem(){
			return ModItems.GyroDrill;
		}
	};
	public static CreativeTabs tabDSBows = new CreativeTabs("tabDSBows"){
		@Override
		public Item getTabIconItem(){
			return Items.bow;
		}
	};
	public static CreativeTabs tabDSSpells = new CreativeTabs("tabDSSpells"){
		@Override
		public Item getTabIconItem(){
			return Items.paper;
		}
	};
	public static CreativeTabs tabDSFluids = new CreativeTabs("tabDSFluids"){
		@Override
		public Item getTabIconItem(){
			return Item.getItemFromBlock(Blocks.water);
		}
	};
	public static void RegisterTabs(){

		
		
	}
}