package starglas.dsremake.common;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import starglas.dsremake.common.items.ModItems;

public class CreateCreativeTab extends CreativeTabs
{

	private Item tabItem;
	public CreateCreativeTab(int ID, String name, Item item)
	{
		super(ID, name);
		this.tabItem = item;
	}
	//sets the image for the creative tab
	
	@Override
	public Item getTabIconItem() {
		return this.tabItem;
	}
}