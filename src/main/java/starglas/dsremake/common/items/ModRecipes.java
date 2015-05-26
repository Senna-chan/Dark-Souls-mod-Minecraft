package starglas.dsremake.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.RegisterHelper;

public class ModRecipes {
	public static void init(){
		GameRegistry.addRecipe(new ItemStack(ModItems.MK2BloodStone), new Object[] {"##", "##", '#', ModItems.MK1BloodStone});
		GameRegistry.addRecipe(new ItemStack(ModItems.MK3BloodStone), new Object[] {"##", "##", '#', ModItems.MK2BloodStone});
	}
}