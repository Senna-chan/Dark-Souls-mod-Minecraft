package starglas.dsremake.common;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class CreateCreativeTab extends CreativeTabs
{

	private String tabName;
	public CreateCreativeTab(int ID, String name, String tabName)
	{
		super(ID, name);
		this.tabName = tabName ;
	}
	//sets the image for the creative tab
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return DSMain.MK1VitaCrystal.itemID;
	}
	//sets the title/name for the creative tab
	public String getTranslatedTabLabel()
	{
		return this.tabName;
	}
}