package starglas.dsremake.handler;

import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.gui.inventory.InventoryCustomPlayer;
import starglas.dsremake.packet.SyncPlayerPropsPacket;

public class ExtendedPlayer implements IExtendedEntityProperties {
	
	private int 	playerLevel;
	private String 	playerClass = "";
	private int 	playerVigor;
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
	private double lastBFX;
	private double lastBFY;
	private double lastBFZ;
	public final InventoryCustomPlayer inventory = new InventoryCustomPlayer();
	private int playerMagicSlots;
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.playerGrace = 30;
		this.playerStrength = 14;
		this.player.getDataWatcher().addObject(ModReference.STAMINA_WATCHER, this.playerStamina);
	}

	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ModReference.NBTExtendedName, new ExtendedPlayer(player));
	}
	
	public static final ExtendedPlayer get(EntityPlayer player)
	{
		return (ExtendedPlayer) player.getExtendedProperties(ModReference.NBTExtendedName);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound playerNbt) {
		System.out.println("LOADING");
		NBTTagCompound nbt = playerNbt.getCompoundTag(ModReference.NBTExtendedName);
		
		this.playerLevel 	= nbt.getInteger("level");		
		this.playerVigor 	= nbt.getInteger("vigor");
		this.player.getDataWatcher().updateObject(ModReference.STAMINA_WATCHER, nbt.getInteger("stamina"));
		this.playerStrength = nbt.getInteger("strength");
		this.playerGrace 	= nbt.getInteger("grace");
		this.playerWill		= nbt.getInteger("will");
		this.playerResolve	= nbt.getInteger("resolve");
		this.playerWrath	= nbt.getInteger("wrath");
		this.playerSerenity = nbt.getInteger("serenity");
		this.playerHarmony	= nbt.getInteger("harmony");
		this.playerClass	= nbt.getString ("class");
		this.playerHasData	= nbt.getInteger("playerHasData");
		this.inventory.readFromNBT(playerNbt);
		if(nbt.getDouble("LastBonfireX") != 0 && nbt.getDouble("LastBonfireY") != 0 && nbt.getDouble("LastBonfireZ") != 0){
			this.lastBFX		= nbt.getDouble("LastBonfireX");
			this.lastBFY		= nbt.getDouble("LastBonfireY"); 
			this.lastBFZ		= nbt.getDouble("LastBonfireZ");
			System.out.println("We have loaded some values");
		}
		this.playerMagicSlots = nbt.getInteger("MagicSlots");
	}
	
	public int getPlayerStrength(){
		return this.playerStrength;
	}
	public int getPlayerGrace(){
		return this.playerGrace;
	}
	public String getPlayerClass(){
		return this.playerClass;
	}
	public int getMagicSlots(){
		return this.playerMagicSlots;
	}
	
	
	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public void doLevelUp(int hp, int stamina, int strength, int grace, int will, int resolve, int wrath, int serenity, int harmony){
		this.playerLevel++;
		if(hp != 0)
			this.playerVigor++;
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
		if(this.playerHasData==0){
			this.playerLevel 	= 0;
			this.playerVigor 	= 20;
			this.playerStamina 	= 80;
			this.playerStrength = 10;
			this.playerGrace 	= 30;
			this.playerWill		= 0;
			this.playerResolve	= 0;
			this.playerWrath	= 0;
			this.playerSerenity = 0;
			this.playerHarmony	= 0;
			this.playerClass	= "NONE";
			this.playerHasData	= 1;
			this.lastBFX		= 0;
			this.lastBFY		= 0;
			this.lastBFZ		= 0;
			this.playerMagicSlots = 3;
			System.out.println("FirstLogin");
	
			NBTTagCompound compound = new NBTTagCompound();
			this.saveNBTData(compound);
		}
	}
	
	public void FinishedBookSetup(int SelectedClass){
		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setInteger("level", 	0);
		nbt.setInteger("vigor",		0);
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

	
	
	public double[] getLastUsedBonfire(){
		double[] lastBFUsed = {this.lastBFX, this.lastBFY, this.lastBFZ};
		return lastBFUsed;
	}
	
	public void saveLastVisitedBonfire(double posX, double posY, double posZ) {
		this.lastBFX = posX;
		this.lastBFY = posY;
		this.lastBFZ = posZ;
		System.out.println("Saved Bonfire data?");
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
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();
		
		compound.setTag(ModReference.NBTExtendedName, nbt);
		
		nbt.setInteger("level", 	this.playerLevel);
		nbt.setInteger("vigor",		this.playerVigor);
		nbt.setInteger("stamina", 	this.player.getDataWatcher().getWatchableObjectInt(ModReference.STAMINA_WATCHER));
		nbt.setInteger("strength", 	this.playerStrength);
		nbt.setInteger("grace", 	this.playerGrace);
		nbt.setInteger("will", 		this.playerWill);
		nbt.setInteger("resolve", 	this.playerResolve);
		nbt.setInteger("wrath", 	this.playerWrath);
		nbt.setInteger("serenity",	this.playerSerenity);
		nbt.setInteger("harmony", 	this.playerHarmony);
		nbt.setString ("class",		this.playerClass);
		nbt.setInteger("playerHasData", this.playerHasData);
		nbt.setDouble("LastBonfireX", this.lastBFX);
		nbt.setDouble("LastBonfireY", this.lastBFY);
		nbt.setDouble("LastBonfireZ", this.lastBFZ);
		nbt.setInteger("MagicSlots", this.playerMagicSlots);
		this.inventory.writeToNBT(compound);
		System.out.println("SAVING");
	}
	
}