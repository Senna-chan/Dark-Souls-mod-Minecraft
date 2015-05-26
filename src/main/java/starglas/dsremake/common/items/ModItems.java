package starglas.dsremake.common.items;

import net.minecraft.item.Item;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.common.items.consumables.Estus;
import starglas.dsremake.common.items.consumables.HeartStone;
import starglas.dsremake.common.items.consumables.HomewardBone;
import starglas.dsremake.common.items.consumables.VitaCrystal;
import starglas.dsremake.common.items.fists.GenericFist;
import starglas.dsremake.common.items.greathammers.GenericGreatHammer;
import starglas.dsremake.common.items.halberts.GenericHalbert;
import starglas.dsremake.common.items.swords.GenericSword;
import starglas.dsremake.common.items.upgrades.BloodStone;
import starglas.dsremake.common.items.upgrades.GenericUpgrade;
import starglas.dsremake.common.items.upgrades.RadiantOil;

public class ModItems{
	public static Item myFirstItem;
	public static Item MK1HeartStone = new HeartStone(":MK1Heart",1).setUnlocalizedName("MK1HeartStone");
	public static Item MK2HeartStone = new HeartStone(":MK2Heart",2).setUnlocalizedName("MK2HeartStone");
	public static Item MK3HeartStone = new HeartStone(":MK3Heart",3).setUnlocalizedName("MK3HeartStone");
	public static Item MK1VitaCrystal = new VitaCrystal(":MK1vita",1).setUnlocalizedName("MK1VitaCrystal");
	public static Item MK2VitaCrystal = new VitaCrystal(":MK2vita",2).setUnlocalizedName("MK2VitaCrystal");
	public static Item MK3VitaCrystal = new VitaCrystal(":MK3vita",3).setUnlocalizedName("MK3VitaCrystal");
	public static Item MK4VitaCrystal = new VitaCrystal(":MK4vita",4).setUnlocalizedName("MK4VitaCrystal");
	public static Item MK5VitaCrystal = new VitaCrystal(":MK5vita",5).setUnlocalizedName("MK5VitaCrystal");
	public static Item Estus = new Estus().setUnlocalizedName("Estus");
	public static Item MK1BloodStone = new BloodStone(1).setUnlocalizedName("MK1BloodStone");
	public static Item MK2BloodStone = new BloodStone(2).setUnlocalizedName("MK2BloodStone");
	public static Item MK3BloodStone = new BloodStone(3).setUnlocalizedName("MK3BloodStone");
	public static Item MK4BloodStone = new BloodStone(4).setUnlocalizedName("MK4BloodStone");
	public static Item PrismaticBloodStone = new BloodStone(5).setUnlocalizedName("PrismaticBloodStone");
	public static Item RadiantOil = new GenericUpgrade(":radiantoil").setUnlocalizedName("RadiantOil");
	public static Item TehBook = new TehBook().setUnlocalizedName("TehBook");
	public static Item HomewardBone = new HomewardBone().setUnlocalizedName("HomewardBone");
	public static Item AbyssalRunestone = new GenericUpgrade(":abyssalrunestone").setUnlocalizedName("AbyssalRunestone");
	public static Item AngelicFeather = new GenericUpgrade(":angelicfeather").setUnlocalizedName("AngelicFeather");
	public static Item BottledTaintcapSpored = new GenericUpgrade(":bottledtaintcapspores").setUnlocalizedName("BottledTaintcapSpores");
	public static Item DancingVapor = new GenericUpgrade(":dancingvapor").setUnlocalizedName("DancingVapor");
	public static Item DragonboneAsh = new GenericUpgrade(":dragonboneash").setUnlocalizedName("DragonboneAsh");
	public static Item HeartPetal = new GenericUpgrade(":heartpetal").setUnlocalizedName("HeartPetal");
	public static Item LiquidDeath = new GenericUpgrade(":liquiddeath").setUnlocalizedName("LiquidDeath");
	public static Item MadmansKnowledge = new GenericUpgrade(":madmansknowledge").setUnlocalizedName("MadmansKnowledge");
	public static Item ShimmeringShoalPearl = new GenericUpgrade(":shimmeringshoalpearl").setUnlocalizedName("ShimmeringShoalPearl");
	public static Item SolarLens = new GenericUpgrade(":solarlens").setUnlocalizedName("SolarLens");
	public static Item TreantSeed = new GenericUpgrade(":treantseed").setUnlocalizedName("TreantSeed");
	 // Swords
	static char[] scales = new char[] { 'C','C' };
	public static Item longSword = new GenericSword("dsremake:longsword", scales).setUnlocalizedName("longSword"); 
	
	// Halberts
	public static Item PaladinGlaive = new GenericHalbert("dsremake:paladinglaive").setUnlocalizedName("PaladinGlaive");
	
	// Great Hamers
	public static Item SanctifiedGreathammer = new GenericGreatHammer().setUnlocalizedName("SanctifiedGreathammer");
	
	// Fist Weapons
	public static Item GyroDrill = new GenericFist().setUnlocalizedName("GyroDrill");
	
	public static void init(){
		// Items
		RegisterHelper.registerItem(TehBook);
		RegisterHelper.registerItem(HomewardBone);
		// Heart Crystals
		RegisterHelper.registerItem(MK1HeartStone);
		RegisterHelper.registerItem(MK2HeartStone);
		RegisterHelper.registerItem(MK3HeartStone);
		
		// Vita crystals
		RegisterHelper.registerItem(MK1VitaCrystal);
		RegisterHelper.registerItem(MK2VitaCrystal);
		RegisterHelper.registerItem(MK3VitaCrystal);
		RegisterHelper.registerItem(MK4VitaCrystal);
		RegisterHelper.registerItem(MK5VitaCrystal);
		
		RegisterHelper.registerItem(Estus);
		
		// BloodStones
		RegisterHelper.registerItem(MK1BloodStone);
		RegisterHelper.registerItem(MK2BloodStone);
		RegisterHelper.registerItem(MK3BloodStone);
		RegisterHelper.registerItem(MK4BloodStone);
		RegisterHelper.registerItem(PrismaticBloodStone);
		
		// Upgrade Items
		RegisterHelper.registerItem(RadiantOil);
		RegisterHelper.registerItem(AbyssalRunestone);
		RegisterHelper.registerItem(AngelicFeather);
		RegisterHelper.registerItem(BottledTaintcapSpored);
		RegisterHelper.registerItem(DancingVapor);
		RegisterHelper.registerItem(DragonboneAsh);
		RegisterHelper.registerItem(HeartPetal);
		RegisterHelper.registerItem(LiquidDeath);
		RegisterHelper.registerItem(MadmansKnowledge);
		RegisterHelper.registerItem(ShimmeringShoalPearl);
		RegisterHelper.registerItem(SolarLens);
		RegisterHelper.registerItem(TreantSeed);
		
		// Weapons
		// Sword
		RegisterHelper.registerItem(longSword);
		
		// Halberts
		RegisterHelper.registerItem(PaladinGlaive);
		
		// Great Hammers
		RegisterHelper.registerItem(SanctifiedGreathammer);
		
		// Fist weapons
		RegisterHelper.registerItem(GyroDrill);
	}
}