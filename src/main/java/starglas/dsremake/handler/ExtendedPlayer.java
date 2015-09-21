package starglas.dsremake.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.gui.inventory.InventoryCustomPlayer;
import starglas.dsremake.network.PacketHandler;
import starglas.dsremake.network.SyncPlayerPropsPacket;

import java.util.UUID;

public class ExtendedPlayer implements IExtendedEntityProperties {
	
	private int 	playerLevel;
	private int		playerClass;
	private int 	playerElement;
	private float 	playerVigor;
	private float 	playerCurrentStamina;
	private float	playerMaxStamina;
	private int 	playerStrength;
	private int 	playerGrace;
	private int 	playerWill;
	private int		playerResolve;
	private int 	playerWrath;
	private int 	playerSerenity;
	private int 	playerHarmony;
	private boolean playerHasData;
	private boolean finishedBookSetup;
	private int 	playerTeam;
	private EntityPlayer player;
	// Bonfire
	private double lastBFX;
	private double lastBFY;
	private double lastBFZ;
	public final InventoryCustomPlayer inventoryPlayer = new InventoryCustomPlayer();
	//public final InventoryBonfire inventoryBonfire = new InventoryBonfire();
	private int playerMagicSlots;
	private int[] bonfire20, bonfire19, bonfire18, bonfire17, bonfire16, bonfire15, bonfire14, bonfire13, bonfire12, bonfire11, bonfire10,
			bonfire9, bonfire8, bonfire7, bonfire6, bonfire5, bonfire4, bonfire3, bonfire2, bonfire1;
	private NBTTagCompound tesst;
	// Public values for dirty tricks
	public float staminaNeeded;
	public boolean allowedRegeneration;
	private int playerEndurance;


	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.player.getDataWatcher().addObject(ModVars.STAMINA_WATCHER, this.playerCurrentStamina);
	}

	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ModVars.NBTExtendedName, new ExtendedPlayer(player));
	}
	
	public static final ExtendedPlayer get(EntityPlayer player)
	{
		return (ExtendedPlayer) player.getExtendedProperties(ModVars.NBTExtendedName);
	}

	public void changeElement(){
		if(this.playerElement==ModVars.ELEMENTNAMES.length) this.playerElement=1;
		else this.playerElement++;
		ModHelper.displayChat(this.player, ModVars.ELEMENTNAMES[this.playerElement]);
	}

	public void changeClass(){
		if(this.playerClass==ModVars.CLASSNAMES.length) this.classSetup(1);
		else {this.playerClass++; this.classSetup(this.playerClass);}
		ModHelper.displayChat(this.player, ModVars.CLASSNAMES[this.playerClass]);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound playerNbt) {
		System.out.println("LOADING");
		NBTTagCompound nbt = playerNbt.getCompoundTag(ModVars.NBTExtendedName);

		this.playerLevel 	= nbt.getInteger("level");		
		this.playerVigor 	= nbt.getFloat("vigor");
		this.player.getDataWatcher().updateObject(ModVars.STAMINA_WATCHER, nbt.getFloat("currentStamina"));
		this.playerMaxStamina = nbt.getFloat("maxStamina");
		this.playerStrength = nbt.getInteger("strength");
		this.playerGrace 	= nbt.getInteger("grace");
		this.playerWill		= nbt.getInteger("will");
		this.playerResolve	= nbt.getInteger("resolve");
		this.playerWrath	= nbt.getInteger("wrath");
		this.playerSerenity = nbt.getInteger("serenity");
		this.playerHarmony	= nbt.getInteger("harmony");
		this.playerEndurance= nbt.getInteger("endurance");
		this.playerElement	= nbt.getInteger("element");
		this.playerClass	= nbt.getInteger("class");
		this.playerHasData	= nbt.getBoolean("playerHasData");
		this.finishedBookSetup = nbt.getBoolean("finishedBookSetup");
		this.playerTeam 	= nbt.getInteger("playerTeam");
		this.inventoryPlayer.readFromNBT(playerNbt);
		if(nbt.getDouble("LastBonfireX") != 0 && nbt.getDouble("LastBonfireY") != 0 && nbt.getDouble("LastBonfireZ") != 0){
			this.lastBFX		= nbt.getDouble("LastBonfireX");
			this.lastBFY		= nbt.getDouble("LastBonfireY"); 
			this.lastBFZ		= nbt.getDouble("LastBonfireZ");
		}
		this.playerMagicSlots = nbt.getInteger("MagicSlots");

		NBTTagCompound nbt2 = nbt.getCompoundTag(ModVars.NBTOwnedBonfires);
		this.bonfire1 = nbt2.getIntArray("01");

	}
	
	public int getPlayerStrength(){
		return this.playerStrength;
	}
	public int getPlayerGrace(){
		return this.playerGrace;
	}
	public int getPlayerElement(){
		return this.playerElement;
	}
	public int getMagicSlots(){
		return this.playerMagicSlots;
	}
	public int getPlayerWrath() {
		return this.playerWrath;
	}
	public int getPlayerWill(){
		return this.playerWill;
	}
	public float getMaxStamina() {
		return this.playerMaxStamina;
	}
	public boolean finishedBookSetup() {
		return this.finishedBookSetup;
	}
	public float getPlayerVigor() {
		return this.playerVigor;
	}
	public int getPlayerClass() {
		return this.playerClass;
	}
	public int getPlayerTeam() {
		return this.playerTeam;
	}


	public void consumeStamina(float stamina){
		float curStamina = this.player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER);
		this.player.getDataWatcher().updateObject(ModVars.STAMINA_WATCHER, curStamina - stamina);
	}
	public void refillStamine(float stamina){
		float curStamina = this.player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER);
		this.player.getDataWatcher().updateObject(ModVars.STAMINA_WATCHER, curStamina + stamina);
	}
	
	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public void doLevelUp(int hp, int stamina, int strength, int grace, int will, int resolve, int wrath, int serenity, int harmony, int level){
		this.playerLevel = this.playerLevel + level;
		this.playerVigor = this.playerVigor + hp;
		this.playerMaxStamina = this.playerMaxStamina + (stamina * 2);
		this.playerCurrentStamina = this.playerMaxStamina;
		this.playerStrength = this.playerStrength + strength;
		this.playerGrace = this.playerGrace + grace;
		this.playerWill = this.playerWill + will;
		this.playerResolve = this.playerResolve + resolve;
		this.playerWrath = this.playerWrath + wrath;
		this.playerSerenity = this.playerSerenity + serenity;
		this.playerHarmony = this.playerHarmony + harmony;
	}
	
	public void FirstLogin() {// Already making the tag shit for easy stuff
		if(this.playerHasData==false){
			this.playerLevel 	= 0;
			this.playerClass	= 0;
			this.playerVigor 	= 20;
			this.playerMaxStamina 	= 80;
			this.playerCurrentStamina = 80;
			this.playerStrength = 0;
			this.playerGrace 	= 0;
			this.playerWill		= 0;
			this.playerResolve	= 0;
			this.playerWrath	= 0;
			this.playerSerenity = 0;
			this.playerHarmony	= 0;
			this.playerElement	= 0;
			this.playerHasData	= true;
			this.lastBFX		= 0;
			this.lastBFY		= 0;
			this.lastBFZ		= 0;
			this.playerMagicSlots = 3;
			this.playerTeam 	= ModVars.TEAM_NONE;
			System.out.println("FirstLogin");

			NBTTagCompound compound = new NBTTagCompound();
			this.saveNBTData(compound);
		}
	}

	
	public void classSetup(int selectedClass){
		int vit, end, str, grc, wil, rsv, wth, srn, har;
		switch(selectedClass){
			case ModVars.KNIGHTCLASS:
				vit 	= 12;
				end		= 9;
				str		= 10;
				grc		= 8;
				wil		= 9;
				rsv		= 9;
				wth		= 6;
				srn		= 9;
				har		= 9;
				break;
			case ModVars.WARRIORCLASS:
				vit 	= 7;
				end		= 13;
				str		= 13;
				grc		= 13;
				wil		= 7;
				rsv		= 7;
				wth		= 7;
				srn		= 7;
				har		= 7;
				break;
			case ModVars.WANDERERCLASS:
				vit 	= 6;
				end		= 15;
				str		= 7;
				grc		= 16;
				wil		= 11;
				rsv		= 6;
				wth		= 9;
				srn		= 8;
				har		= 8;
				break;
			case ModVars.PYROMANCERCLASS:
				vit 	= 8;
				end		= 12;
				str		= 9;
				grc		= 5;
				wil		= 16;
				rsv		= 6;
				wth		= 9;
				srn		= 8;
				har		= 8;
				break;
			case ModVars.PALADINCLASS:
				vit 	= 9;
				end		= 9;
				str		= 10;
				grc		= 7;
				wil		= 9;
				rsv		= 15;
				wth		= 4;
				srn		= 9;
				har		= 9;
				break;
			case ModVars.WARLOCKCLASS:
				vit 	= 8;
				end		= 12;
				str		= 7;
				grc		= 7;
				wil		= 10;
				rsv		= 8;
				wth		= 16;
				srn		= 7;
				har		= 6;
				break;
			case ModVars.TIDEHUNTERCLASS:
				vit 	= 9;
				end		= 9;
				str		= 9;
				grc		= 12;
				wil		= 5;
				rsv		= 7;
				wth		= 7;
				srn		= 16;
				har		= 7;
				break;
			case ModVars.DRUIDCLASS:
				vit 	= 8;
				end		= 10;
				str		= 8;
				grc		= 10;
				wil		= 8;
				rsv		= 8;
				wth		= 5;
				srn		= 8;
				har		= 16;
				break;
			default:
				vit 	= 0;
				end		= 0;
				str		= 0;
				grc		= 0;
				wil		= 0;
				rsv		= 0;
				wth		= 0;
				srn		= 0;
				har		= 0;
				break;
		}
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);// DEBUG
		float playerHealth = player.getMaxHealth();
		float health = playerHealth + (vit * 0.5F);
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(health);
		player.setHealth(health);
		this.playerVigor = vit;
		this.playerEndurance = end;
		this.playerStrength =str;
		this.playerGrace = grc;
		this.playerWill = wil;
		this.playerResolve = rsv;
		this.playerWrath = wth;
		this.playerSerenity = srn;
		this.playerHarmony = har;
		this.playerClass = selectedClass;
		this.finishedBookSetup = true;
		NBTTagCompound tag = new NBTTagCompound();
		this.saveNBTData(tag);
	}

	public double[] getLastUsedBonfire(){
		double[] lastBFUsed = {this.lastBFX, this.lastBFY, this.lastBFZ};
		return lastBFUsed;
	}
	
	public void saveLastVisitedBonfire(double posX, double posY, double posZ) {
		this.lastBFX = posX;
		this.lastBFY = posY;
		this.lastBFZ = posZ;
	}
	
	private static UUID getSaveKey(EntityPlayer player) {
		return player.getUniqueID();
	}
	
	public static void saveProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		// Note that we made the CommonProxy method storeEntityData static,
		// so now we don't need an instance of CommonProxy to use it! Great!
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	public static final void loadProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		if (savedData != null) { playerData.loadNBTData(savedData); }
		PacketHandler.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
	}

	public void saveBonfire(int x, int y, int z) {
		this.bonfire20 = this.bonfire19;
		this.bonfire19 = this.bonfire18;
		this.bonfire18 = this.bonfire17;
		this.bonfire17 = this.bonfire16;
		this.bonfire16 = this.bonfire15;
		this.bonfire15 = this.bonfire14;
		this.bonfire14 = this.bonfire13;
		this.bonfire13 = this.bonfire12;
		this.bonfire12 = this.bonfire11;
		this.bonfire11 = this.bonfire10;
		this.bonfire10 = this.bonfire9;
		this.bonfire9 = this.bonfire8;
		this.bonfire8 = this.bonfire7;
		this.bonfire7 = this.bonfire6;
		this.bonfire6 = this.bonfire5;
		this.bonfire5 = this.bonfire4;
		this.bonfire4 = this.bonfire3;
		this.bonfire3 = this.bonfire2;
		this.bonfire2 = this.bonfire1;
		this.bonfire1 = new int[]{x, y, z};
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();
		
		compound.setTag(ModVars.NBTExtendedName, nbt);
		
		nbt.setInteger("level", this.playerLevel);
		nbt.setInteger("class", this.playerClass);
		nbt.setFloat("vigor", this.playerVigor);
		nbt.setFloat("currentStamina", this.player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER));
		nbt.setFloat("maxStamina", this.playerMaxStamina);
		nbt.setInteger("strength", this.playerStrength);
		nbt.setInteger("grace", 	this.playerGrace);
		nbt.setInteger("will", 		this.playerWill);
		nbt.setInteger("resolve", 	this.playerResolve);
		nbt.setInteger("wrath", this.playerWrath);
		nbt.setInteger("serenity", this.playerSerenity);
		nbt.setInteger("endurance", this.playerEndurance);
		nbt.setInteger("harmony", this.playerHarmony);
		nbt.setInteger("element", this.playerElement);
		nbt.setBoolean("playerHasData", this.playerHasData);
		nbt.setBoolean("finishedBookSetup", this.finishedBookSetup);
		nbt.setDouble("LastBonfireX", this.lastBFX);
		nbt.setDouble("LastBonfireY", this.lastBFY);
		nbt.setDouble("LastBonfireZ", this.lastBFZ);
		nbt.setInteger("MagicSlots", this.playerMagicSlots);
		nbt.setInteger("playerTeam", this.playerTeam);
		this.inventoryPlayer.writeToNBT(compound);

//		NBTTagCompound visitedBonfires = new NBTTagCompound();
//		nbt.setTag(ModVars.NBTOwnedBonfires, visitedBonfires);
//		visitedBonfires.setIntArray("01", this.bonfire1);
//		visitedBonfires.setIntArray("02", this.bonfire2);
//		visitedBonfires.setIntArray("03", this.bonfire3);
//		visitedBonfires.setIntArray("04", this.bonfire4);
//		visitedBonfires.setIntArray("05", this.bonfire5);
//		visitedBonfires.setIntArray("06", this.bonfire6);
//		visitedBonfires.setIntArray("07", this.bonfire7);
//		visitedBonfires.setIntArray("08", this.bonfire8);
//		visitedBonfires.setIntArray("09", this.bonfire9);
//		visitedBonfires.setIntArray("10", this.bonfire10);
//		visitedBonfires.setIntArray("11", this.bonfire11);
//		visitedBonfires.setIntArray("12", this.bonfire12);
//		visitedBonfires.setIntArray("13", this.bonfire13);
//		visitedBonfires.setIntArray("14", this.bonfire14);
//		visitedBonfires.setIntArray("15", this.bonfire15);
//		visitedBonfires.setIntArray("16", this.bonfire16);
//		visitedBonfires.setIntArray("17", this.bonfire17);
//		visitedBonfires.setIntArray("18", this.bonfire18);
//		visitedBonfires.setIntArray("19", this.bonfire19);
//		visitedBonfires.setIntArray("20", this.bonfire20);


	}


	public void setPlayerTeam(int playerTeam) {
		this.playerTeam = playerTeam;
	}
}