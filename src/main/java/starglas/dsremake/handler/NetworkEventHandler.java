package starglas.dsremake.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.items.ModItems;

/**
 * Created by Starlight on 7-7-2015.
 */
public class NetworkEventHandler {
    @SubscribeEvent
    public void onClientConnected(FMLNetworkEvent.ClientConnectedToServerEvent event){

    }
    @SubscribeEvent
    public void onPlayerJoined(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        ExtendedPlayer props = ExtendedPlayer.get(player);
        if(!props.finishedBookSetup()){

        }
        // Give player their beginner items
        if(ModHelper.playerHasItem(player, ModItems.Estus )== -1){
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
