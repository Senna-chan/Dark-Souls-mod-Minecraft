package starglas.dsremake.common.helpers;

import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import starglas.dsremake.items.ModItems;

public class ModMerchantRecipes {
	public static MerchantRecipeList getRecipes(String type){
		MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
		if(type == "poison"){
			merchantrecipelist.add(new MerchantRecipe(new ItemStack(ModItems.MK2VitaCrystal, 3, 0), new ItemStack(ModItems.LiquidDeath)));
			merchantrecipelist.add(new MerchantRecipe(new ItemStack(ModItems.LiquidDeath, 1, 0), new ItemStack(ModItems.MK2VitaCrystal, 2, 0)));
		}
		return merchantrecipelist;
	}
}
