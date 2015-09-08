package starglas.dsremake.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.items.ModItems;
import starglas.dsremake.items.TheBook;
import starglas.dsremake.items.consumables.Estus;

/**
 * Created by Starlight on 7-7-2015.
 */
public class NetworkHandler {
    @SubscribeEvent
    public void onClientConnected(FMLNetworkEvent.ClientConnectedToServerEvent event){
        System.out.println("Connected");
    }
    @SubscribeEvent
    public void onPlayerJoined(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        // Give player their beginner items
        ItemStack[] playerInventory = player.inventory.mainInventory;
        boolean beginnerItemFound = false;
        for(ItemStack itemStack : playerInventory) {
            if((itemStack != null && itemStack.getItem() instanceof Estus) || (itemStack != null && itemStack.getItem() instanceof TheBook)) {
                beginnerItemFound = true;
                break;
            }
        }
        if(!beginnerItemFound){
            // non debug items
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.Estus));
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.theBook));
            // Debug items
            player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.bonfire));
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.testItem));
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.ElementChanger));
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.ClassChanger));
        }
    }

}
