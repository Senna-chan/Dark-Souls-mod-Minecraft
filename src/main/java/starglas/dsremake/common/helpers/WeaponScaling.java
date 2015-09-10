package starglas.dsremake.common.helpers;

import net.minecraft.entity.player.EntityPlayer;
import starglas.dsremake.handler.ExtendedPlayer;

public class WeaponScaling {
	public static float totalAR;
	private static float strScaling;
	private static float FireScaling;
	private static int playerStrength;
	private static int playerGrace;
	private static float grcScaling;
	
	//public static float WeaponScalingRaw(int weaponDamage, char strengthScaling, char dextScaling, int playerStrength, int playerDex/*, int playerWill, int playerLight, int playerWrath, int playerSerenity, int playerHarmony*/){
	public float CalcWeaponDMG(int weaponDamage, char strengthScale, char dexScale, EntityPlayer player){
		ExtendedPlayer props = ExtendedPlayer.get(player);
		
		int playerStrength = props.getPlayerStrength();
    	int playerGrace = props.getPlayerGrace();
    	
    	getStrScaling(strengthScale);
    	getGrcScaling(dexScale);
    	
		totalAR = (float) Math.ceil( weaponDamage + (weaponDamage * ((strScaling * playerStrength ) + (grcScaling * playerGrace )) /100 ) );
		return totalAR;
	}
	private void getStrScaling(char strengthScale){
		switch(strengthScale){
			case 'E': strScaling = 0.3F; break;
			case 'D': strScaling = 0.7F; break;
			case 'C': strScaling = 1.1F; break;
			case 'B': strScaling = 1.5F; break;
			case 'A': strScaling = 1.9F; break;
			case 'S': strScaling = 2.5F; break;
			default:  strScaling = 0.0F; break;
		}
	}
	private void getGrcScaling(char graceScale){
		switch(graceScale){
			case 'E': grcScaling = 0.3F; break;
			case 'D': grcScaling = 0.7F; break;
			case 'C': grcScaling = 1.1F; break;
			case 'B': grcScaling = 1.5F; break;
			case 'A': grcScaling = 1.9F; break;
			case 'S': grcScaling = 2.5F; break;
			case 'Z': grcScaling = 0.0F; break;
			default:  grcScaling = 0.0F; break;
		}
	}
	private void getFireScaling(char fireScale){
		switch(fireScale){
			case 'E': FireScaling = 0.3F; break;
			case 'D': FireScaling = 0.7F; break;
			case 'C': FireScaling = 1.1F; break;
			case 'B': FireScaling = 1.5F; break;
			case 'A': FireScaling = 1.9F; break;
			case 'S': FireScaling = 2.5F; break;
			default:  FireScaling = 0.0F; break;
		}
	}
}