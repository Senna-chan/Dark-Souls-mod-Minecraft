package starglas.dsremake.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.common.helpers.ModHelper;

public class ModRecipes {
	public static void init(){
		GameRegistry.addRecipe(new ItemStack(ModItems.MK2BloodStone), new Object[] {"##", "##", '#', ModItems.MK1BloodStone});
		GameRegistry.addRecipe(new ItemStack(ModItems.MK3BloodStone), new Object[] {"##", "##", '#', ModItems.MK2BloodStone});
	}
}