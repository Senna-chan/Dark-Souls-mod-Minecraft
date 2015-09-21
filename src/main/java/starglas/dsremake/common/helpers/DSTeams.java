package starglas.dsremake.common.helpers;

import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.handler.ExtendedPlayer;

/**
 * Created by Starlight on 20-9-2015.
 */
public class DSTeams {
    public static void addPlayerToTeam(EntityPlayer player, int team){
        ExtendedPlayer props = ExtendedPlayer.get(player);
        props.setPlayerTeam(team);
    }

}
