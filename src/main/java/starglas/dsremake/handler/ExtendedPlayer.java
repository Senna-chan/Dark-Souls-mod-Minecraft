package starglas.dsremake.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.items.ModItems;
import starglas.dsremake.packet.SyncPlayerPropsPacket;

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
		if(this.playerElement==ModVars.STORMELEMENT) this.playerElement=1;
		else this.playerElement++;
		ModHelper.displayChat(this.player, ModVars.ELEMENTNAMES[this.playerElement]);
	}

	public void changeClass(){
		if(this.playerClass==ModVars.WANDERERCLASS) this.playerClass=1;
		else this.playerClass++;
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
		this.playerElement	= nbt.getInteger("element");
		this.playerClass	= nbt.getInteger("class");
		this.playerHasData	= nbt.getBoolean("playerHasData");
		this.finishedBookSetup = nbt.getBoolean("finishedBookSetup");
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
	public NBTTagCompound testFunc(){
		NBTTagCompound test = new NBTTagCompound();
		loadNBTData(test);
		System.out.println(test.getCompoundTag(ModVars.NBTExtendedName));
		return test;
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
			System.out.println("FirstLogin");

			NBTTagCompound compound = new NBTTagCompound();
			this.saveNBTData(compound);
		}
	}
	
	public void classSetup(int selectedClass){
		int vigor, strength, grace;
		switch(selectedClass){
			case 1:
				vigor 		= 14;
				strength 	= 11;
				grace 		= 11;
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.longSword));
				break;
			case 2:
				vigor 		= 8;
				strength 	= 9;
				grace 		= 11;
				break;
			case 3:
				vigor 		= 11;
				strength 	= 12;
				grace 		= 8;
				break;
			case 4:
				vigor 		= 11;
				strength	= 11;
				grace		= 11;
				break;
			default:
				vigor=0;
				strength=0;
				grace=0;
				break;
		}
		float playerHealth = player.getMaxHealth();
		float health = playerHealth + (vigor * 0.5F);
		player.setHealth(health);
		this.playerStrength =strength;
		this.playerGrace = grace;
		this.playerVigor = vigor;
		this.playerClass = selectedClass;
		this.finishedBookSetup = true;



		NBTTagCompound compound = new NBTTagCompound();
		this.saveNBTData(compound);
		System.out.println("ExtendedPlayer.classSetup");
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
		DSMain.packetPipeline.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
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
		nbt.setInteger("harmony", this.playerHarmony);
		nbt.setInteger("element", this.playerElement);
		nbt.setBoolean("playerHasData", this.playerHasData);
		nbt.setBoolean("finishedBookSetup", this.finishedBookSetup);
		nbt.setDouble("LastBonfireX", this.lastBFX);
		nbt.setDouble("LastBonfireY", this.lastBFY);
		nbt.setDouble("LastBonfireZ", this.lastBFZ);
		nbt.setInteger("MagicSlots", this.playerMagicSlots);
		this.inventoryPlayer.writeToNBT(compound);

		NBTTagCompound visitedBonfires = new NBTTagCompound();
		nbt.setTag(ModVars.NBTOwnedBonfires, visitedBonfires);
		visitedBonfires.setIntArray("01", this.bonfire1);
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
}