package starglas.dsremake.common;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import starglas.dsremake.common.items.ModItems;

public class CreateCreativeTab extends CreativeTabs
{

	private String tabName;
	public CreateCreativeTab(int ID, String name, String tabName)
	{
		super(ID, name);
		this.tabName = tabName ;
	}
	//sets the image for the creative tab
	
	//sets the title/name for the creative tab
	public String getTranslatedTabLabel()
	{
		return this.tabName;
	}
	@Override
	public Item getTabIconItem() {
		return ModItems.MK1VitaCrystal;
	}
}