package starglas.dsremake.common;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public final class CreateCreativeTab extends CreativeTabs
{
public CreateCreativeTab(int par1, String par2Str)
{
super(par1, par2Str);
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