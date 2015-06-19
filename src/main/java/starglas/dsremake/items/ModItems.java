package starglas.dsremake.items;

import net.minecraft.item.Item;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.items.arrows.WoodenGreatArrow;
import starglas.dsremake.items.bows.VileBarkGreatbow;
import starglas.dsremake.items.consumables.Estus;
import starglas.dsremake.items.consumables.HeartStone;
import starglas.dsremake.items.consumables.HomewardBone;
import starglas.dsremake.items.consumables.VitaCrystal;
import starglas.dsremake.items.fists.GyroDrill;
import starglas.dsremake.items.greathammers.GenericGreatHammer;
import starglas.dsremake.items.halberts.GenericHalbert;
import starglas.dsremake.items.rings.RingofVigor;
import starglas.dsremake.items.swords.GenericSword;
import starglas.dsremake.items.upgrades.BloodStone;
import starglas.dsremake.items.upgrades.GenericUpgrade;

public class ModItems{
	public static Item XPDrainer = new XPDrainer().setUnlocalizedName("XPDrainer");
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
	
	// Rings
	public static Item RingofVigor = new RingofVigor().setUnlocalizedName("RingofVigor");
	
	// Bows
	public static Item VileBarkGreatbow = new VileBarkGreatbow().setUnlocalizedName("VileBarkGreatbow");
	// Arrows
	public static Item WoodenGreatArrow = new WoodenGreatArrow().setUnlocalizedName("WoodenGreatArrow");
	// Swords
	public static Item longSword = new GenericSword(9, 'B', 'B').setUnlocalizedName("longSword"); 
	
	// Halberts
	public static Item PaladinGlaive = new GenericHalbert("dsremake:paladinglaive").setUnlocalizedName("PaladinGlaive");
	
	// Great Hamers
	public static Item SanctifiedGreathammer = new GenericGreatHammer(20, 'B', 'Z').setUnlocalizedName("SanctifiedGreathammer");
	
	// Fist Weapons
	public static Item GyroDrill = new GyroDrill(8, 'S', 'B').setUnlocalizedName("GyroDrill");
	
	// Spells
	public static Item Spell = new starglas.dsremake.items.spells.Spell().setUnlocalizedName("Spell");
	
	public static void init(){
		ModHelper.registerItem(Spell);
		ModHelper.registerItem(XPDrainer);
		// Items
		ModHelper.registerItem(HomewardBone);
		// Heart Crystals
		ModHelper.registerItem(MK1HeartStone);
		ModHelper.registerItem(MK2HeartStone);
		ModHelper.registerItem(MK3HeartStone);
		
		// Vita crystals
		ModHelper.registerItem(MK1VitaCrystal);
		ModHelper.registerItem(MK2VitaCrystal);
		ModHelper.registerItem(MK3VitaCrystal);
		ModHelper.registerItem(MK4VitaCrystal);
		ModHelper.registerItem(MK5VitaCrystal);
		
		ModHelper.registerItem(Estus);
		
		// BloodStones
		ModHelper.registerItem(MK1BloodStone);
		ModHelper.registerItem(MK2BloodStone);
		ModHelper.registerItem(MK3BloodStone);
		ModHelper.registerItem(MK4BloodStone);
		ModHelper.registerItem(PrismaticBloodStone);
		
		// Upgrade Items
		ModHelper.registerItem(RadiantOil);
		ModHelper.registerItem(AbyssalRunestone);
		ModHelper.registerItem(AngelicFeather);
		ModHelper.registerItem(BottledTaintcapSpored);
		ModHelper.registerItem(DancingVapor);
		ModHelper.registerItem(DragonboneAsh);
		ModHelper.registerItem(HeartPetal);
		ModHelper.registerItem(LiquidDeath);
		ModHelper.registerItem(MadmansKnowledge);
		ModHelper.registerItem(ShimmeringShoalPearl);
		ModHelper.registerItem(SolarLens);
		ModHelper.registerItem(TreantSeed);
		
		// Rings
		ModHelper.registerItem(RingofVigor);
		
		// Weapons
		// Bows
		ModHelper.registerItem(VileBarkGreatbow);
		
		// Arrows
		ModHelper.registerItem(WoodenGreatArrow);
		
		// Sword
		ModHelper.registerItem(longSword);
		
		// Halberts
		ModHelper.registerItem(PaladinGlaive);
		
		// Great Hammers
		ModHelper.registerItem(SanctifiedGreathammer);
		
		// Fist weapons
		ModHelper.registerItem(GyroDrill);
	}
}