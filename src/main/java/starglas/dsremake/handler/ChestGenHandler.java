package starglas.dsremake.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import starglas.dsremake.items.ModItems;

/**
 * Created by Starlight on 15-7-2015.
 */
public class ChestGenHandler {
    public static void init(){
        ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.MK1HeartStone),0,2,2));
        ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.longSword),0,1,1));
    }
}
