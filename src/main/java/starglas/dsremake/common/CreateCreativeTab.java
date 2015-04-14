package starglas.dsremake.common;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import starglas.dsremake.common.items.ModItems;

public class CreateCreativeTab
{
	public static CreativeTabs tabDSConsume;
	public static CreativeTabs tabDSBlocks;
	public static CreativeTabs tabDSSwords;
	public static CreativeTabs tabDSHalberts;

	public CreateCreativeTab(){
		tabDSConsume = new CreativeTabs("tabDSConsume"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return ModItems.Estus;
			}
		};
		tabDSBlocks = new CreativeTabs("tabDSBlocks"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return ModItems.Estus;
			}
		};
		tabDSSwords = new CreativeTabs("tabDSSwords"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return ModItems.Estus;
			}
		};
		tabDSHalberts = new CreativeTabs("tabDSHalberts"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return ModItems.Estus;
			}
		};
	}
}