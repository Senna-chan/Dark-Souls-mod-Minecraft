package starglas.dsremake.common;

public class WeaponScaling {
	public static float totalAR;
	private static float strScaling;
	private static float dexScaling;

	public static float WeaponScalingRaw(int weaponDamage, char strengthScaling, char dextScaling, int playerStrength, int playerDex){
		switch(strengthScaling){
		case 'E':
			strScaling = 0.3F;
			break;
		case 'D':
			strScaling = 0.7F;
			break;
		case 'C':
			strScaling = 1.1F;
			break;
		case 'B':
			strScaling = 1.5F;
			break;
		case 'A':
			strScaling = 1.9F;
			break;
		case 'S':
			strScaling = 2.5F;
			break;
		default:
			strScaling = 0.0F;
			break;
		}
		switch(dextScaling){
		case 'E':
			dexScaling = 0.3F;
			break;
		case 'D':
			dexScaling = 0.7F;
			break;
		case 'C':
			dexScaling = 1.1F;
			break;
		case 'B':
			dexScaling = 1.5F;
			break;
		case 'A':
			dexScaling = 1.9F;
			break;
		case 'S':
			dexScaling = 2.5F;
			break;
		default:
			dexScaling = 0.0F;
			break;
		}
		if(strScaling != 0.0F && dexScaling !=0.0F){
			totalAR = (float) Math.ceil( weaponDamage + (weaponDamage * ((strScaling * playerStrength ) + (dexScaling * playerDex ))/100 ) );
		}
		if(strScaling != 0 && dexScaling == 0.0F){
			totalAR = (float) Math.ceil( weaponDamage + (weaponDamage * ((strScaling * playerStrength))/100) );
		}
		if(dexScaling != 0 && strScaling == 0.0F){
			totalAR = (float) Math.ceil( weaponDamage + (weaponDamage * ((dexScaling * playerDex))/100) );
		}
		return totalAR;
	}
}