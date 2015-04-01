package starglas.dsremake.common;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public final class CreateCreativeTab extends CreativeTabs
{
public CreateCreativeTab(int ID, String name)
{
super(ID, name);
}
//sets the image for the creative tab
@SideOnly(Side.CLIENT)
//public int getTabIconItemIndex()
//{
//
//}
//sets the title/name for the creative tab
public String getTranslatedTabLabel()
{
return "Syn Tutorial Mod";
}
}