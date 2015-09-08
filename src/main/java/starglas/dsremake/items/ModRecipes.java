package starglas.dsremake.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import starglas.dsremake.block.ModBlocks;

public class ModRecipes {
	public static void init(){
		GameRegistry.addRecipe(new ItemStack(ModItems.MK2BloodStone), "##", "##", '#', ModItems.MK1BloodStone);
		GameRegistry.addRecipe(new ItemStack(ModItems.MK3BloodStone), "##", "##", '#', ModItems.MK2BloodStone);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.bonfire), "|^|", "|*|", "###", '|', Items.stick, '^', Items.iron_sword, '*', ModItems.RadiantOil, '#', Blocks.planks);
	}
}