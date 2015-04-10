package starglas.dsremake.common;

import java.util.Arrays;

public class WeaponScaling {
	public static float totalAR;
	private static float strScaling;
	private static float dexScaling;
	private static float FireScaling;

	//public static float WeaponScalingRaw(int weaponDamage, char strengthScaling, char dextScaling, int playerStrength, int playerDex/*, int playerWill, int playerLight, int playerWrath, int playerSerenity, int playerHarmony*/){
	public static float WeaponScalingRaw(int weaponDamage, char[] scaleArray, int playerStrength, int playerDex/*, int playerWill, int playerLight, int playerWrath, int playerSerenity, int playerHarmony*/){
		System.out.println(Arrays.toString(scaleArray));
		switch(scaleArray[0]){
			case 'E': strScaling = 0.3F;
			case 'D': strScaling = 0.7F;
			case 'C': strScaling = 1.1F;
			case 'B': strScaling = 1.5F;
			case 'A': strScaling = 1.9F;
			case 'S': strScaling = 2.5F;
			default:  strScaling = 0.0F;
		}
		switch(scaleArray[1]){
			case 'E': dexScaling = 0.3F;
			case 'D': dexScaling = 0.7F;
			case 'C': dexScaling = 1.1F;
			case 'B': dexScaling = 1.5F;
			case 'A': dexScaling = 1.9F;
			case 'S': dexScaling = 2.5F;
			default:  dexScaling = 0.0F;
		}
		System.out.println(dexScaling + "Dex; " + strScaling + " Str;");
		/*switch(FireScaling){
		case 'E': FireScaling = 0.3F;
		case 'D': FireScaling = 0.7F;
		case 'C': FireScaling = 1.1F;
		case 'B': FireScaling = 1.5F;
		case 'A': FireScaling = 1.9F;
		case 'S': FireScaling = 2.5F;
		default:  FireScaling = 0.0F;
		}*/
		totalAR = (float) Math.ceil( weaponDamage + (weaponDamage * ((strScaling * playerStrength ) + (dexScaling * playerDex ))/100 ) );
		return totalAR;
	}
}