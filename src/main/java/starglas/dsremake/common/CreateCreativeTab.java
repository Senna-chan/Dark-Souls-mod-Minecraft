package starglas.dsremake.common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import starglas.dsremake.common.items.ModItems;

public class CreateCreativeTab
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
			return ModItems.Estus;
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

	public static void RegisterTabs(){

		
		
	}
}