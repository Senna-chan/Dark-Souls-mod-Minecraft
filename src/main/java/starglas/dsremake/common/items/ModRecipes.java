package starglas.dsremake.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.RegisterHelper;

public class ModRecipes {
	public static void init(){
		//RegisterHelper.registerSmelting(ModItems.BloodstonechipOre, new ItemStack(ModItems.MK1BloodStone), 0.5F);
		GameRegistry.addSmelting(ModBlocks.BloodstonechipOre, new ItemStack(ModItems.MK1BloodStone), 0.2F);
		GameRegistry.addSmelting(ModBlocks.BloodstoneshardOre, new ItemStack(ModItems.MK2BloodStone), 0.5F);
	}
}
