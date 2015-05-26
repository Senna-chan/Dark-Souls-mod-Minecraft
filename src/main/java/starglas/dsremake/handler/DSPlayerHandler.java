package starglas.dsremake.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import starglas.dsremake.common.helpers.ModReference;

public class DSPlayerHandler implements IExtendedEntityProperties {
	
	private int 	playerLevel;
	private String 	playerClass = "";
	private int 	playerHP;
	private int 	playerStamina;
	private int 	playerStrength;
	private int 	playerGrace;
	private int 	playerWill;
	private int 	playerResolve;
	private int 	playerWrath;
	private int 	playerSerenity;
	private int 	playerHarmony;
	private int		playerHasData;
	private EntityPlayer player;
	private int ticksExisted;
	// Bonfire
	private int lastBFX;
	private int lastBFY;
	private int lastBFZ;
	
	public DSPlayerHandler(EntityPlayer player) {
		this.player = player;
		this.ticksExisted = player.ticksExisted;
		this.playerHP = (int) player.getMaxHealth();
	}

	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ModReference.NBTExtendedName, new DSPlayerHandler(player));
	}
	
	public static final DSPlayerHandler get(EntityPlayer player)
	{
		return (DSPlayerHandler) player.getExtendedProperties(ModReference.NBTExtendedName);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound playerNbt) {
		NBTTagCompound nbt = playerNbt.getCompoundTag(ModReference.NBTExtendedName);
		
		this.playerLevel 	= nbt.getInteger("level");		
		this.playerHP	 	= nbt.getInteger("hp");
		this.playerStamina 	= nbt.getInteger("stamina");
		this.playerStrength = nbt.getInteger("strength");
		this.playerGrace 	= nbt.getInteger("grace");
		this.playerWill		= nbt.getInteger("will");
		this.playerResolve	= nbt.getInteger("resolve");
		this.playerWrath	= nbt.getInteger("wrath");
		this.playerSerenity = nbt.getInteger("serenity");
		this.playerHarmony	= nbt.getInteger("harmony");
		this.playerClass	= nbt.getString ("class");
		this.playerHasData	= nbt.getInteger("initlevel");
		if(nbt.getDouble("LastBonfireX") != 0 && nbt.getDouble("LastBonfireY") != 0 && nbt.getDouble("LastBonfireZ") != 0){
			this.lastBFX		= nbt.getInteger("LastBonfireX");
			this.lastBFY		= nbt.getInteger("LastBonfireY"); 
			this.lastBFZ		= nbt.getInteger("LastBonfireZ");
			System.out.println("We have loaded some values");
		}
	}
	
	
	
	
	
	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public void doLevelUp(int hp, int stamina, int strength, int grace, int will, int resolve, int wrath, int serenity, int harmony){
		this.playerLevel++;
		if(hp != 0)
			this.playerHP++;
		if(stamina != 0)
			this.playerStamina = this.playerStamina + 2;
		if(strength != 0)
			this.playerStrength++;
		if(grace != 0)
			this.playerGrace++;
		if(will != 0)
			this.playerWill++;
		if(resolve != 0)
			this.playerResolve++;
		if(wrath != 0)
			this.playerWrath++;
		if(serenity != 0)
			this.playerSerenity++;
		if(harmony != 0)
			this.playerHarmony++;
		
	}
	
	public void FirstLogin() {// Already making the tag shit for easy stuff
		if(this.playerHasData!=1){
		this.playerLevel 	= 0;
		this.playerHP	 	= 20;
		this.playerStamina 	= 0;
		this.playerStrength = 0;
		this.playerGrace 	= 0;
		this.playerWill		= 0;
		this.playerResolve	= 0;
		this.playerWrath	= 0;
		this.playerSerenity = 0;
		this.playerHarmony	= 0;
		this.playerClass	= "None";
		this.playerHasData	= 1;
		this.lastBFX		= 80;
		this.lastBFY		= 80;
		this.lastBFZ		= 80;
		System.out.println("FirstLogin");

		NBTTagCompound compound = new NBTTagCompound();
		this.saveNBTData(compound);
		}
	}
	
	public void FinishedBookSetup(int SelectedClass){
		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setInteger("level", 	0);
		nbt.setInteger("hp", 		20);
		nbt.setInteger("stamina", 	80);
		nbt.setInteger("strength", 	0);
		nbt.setInteger("grace", 	0);
		nbt.setInteger("will", 		0);
		nbt.setInteger("resolve", 	0);
		nbt.setInteger("wrath", 	0);
		nbt.setInteger("serenity",	0);
		nbt.setInteger("harmony", 	0);
		nbt.setString ("class",		"CLASS");
	}
	
	public String getPlayerClass(){
		return this.playerClass;
	}

	
	
	public double[] getLastUsedBonfire(){
		double[] lastBFUsed = {this.lastBFX, this.lastBFY, this.lastBFZ};
		return lastBFUsed;
	}
	
	public void saveLastVisitedBonfire(double posX, double posY, double posZ) {
		this.lastBFX = (int)posX;
		this.lastBFY = (int)posY;
		this.lastBFZ = (int)posZ;
	}
	
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();
		
		compound.setTag(ModReference.NBTExtendedName, nbt);
		
		nbt.setInteger("level", 	this.playerLevel);
		nbt.setInteger("hp", 		this.playerHP);
		nbt.setInteger("stamina", 	this.playerStamina);
		nbt.setInteger("strength", 	this.playerStrength);
		nbt.setInteger("grace", 	this.playerGrace);
		nbt.setInteger("will", 		this.playerWill);
		nbt.setInteger("resolve", 	this.playerResolve);
		nbt.setInteger("wrath", 	this.playerWrath);
		nbt.setInteger("serenity",	this.playerSerenity);
		nbt.setInteger("harmony", 	this.playerHarmony);
		nbt.setString ("class",		this.playerClass);
		nbt.setInteger("playerHasData", this.playerHasData);
//		if(this.lastBFX != 0 && this.lastBFY != 0 && this.lastBFZ !=0){
//			System.out.println("We can save some values");
			nbt.setInteger("LastBonfireX", this.lastBFX);
			nbt.setInteger("LastBonfireY", this.lastBFY);
			nbt.setInteger("LastBonfireZ", this.lastBFZ);
		//}
			
	}
	
}