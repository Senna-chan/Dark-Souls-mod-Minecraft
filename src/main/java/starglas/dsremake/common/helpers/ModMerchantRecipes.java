package starglas.dsremake.common.helpers;

import starglas.dsremake.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class ModMerchantRecipes {
	public static MerchantRecipeList getRecipes(String type){
		MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
		if(type == "poison"){
		 merchantrecipelist.add(new MerchantRecipe(new ItemStack(ModItems.MK2VitaCrystal, 3, 0), new ItemStack(ModItems.LiquidDeath)));
		 //merchantrecipelist.add(new MerchantRecipe(new ItemStack(ModItems.LiquidDeath, 8, 0), new ItemStack(ModItems.MadmansKnowledge)));
		}
		return merchantrecipelist;
	}
}
