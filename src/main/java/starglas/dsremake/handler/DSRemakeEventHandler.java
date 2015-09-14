package starglas.dsremake.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.common.CommonProxy;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.mobs.trader.DSTrader;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.items.ModItems;

import java.util.List;
// https://dl.dropboxusercontent.com/s/h777x7ugherqs0w/forgeevents.html
// Detailed website with events
public class DSRemakeEventHandler{

	@SubscribeEvent
	public void OnPlayerConstruct(EntityEvent.EntityConstructing event){
		
		if(event.entity instanceof EntityPlayer){
			System.out.println("EntityConstructing event called; is this the client side? " + event.entity.worldObj.isRemote);
			EntityPlayer player = (EntityPlayer)event.entity;
			if (ExtendedPlayer.get(player) == null) {
				ExtendedPlayer.register(player);
				ExtendedPlayer props = ExtendedPlayer.get(player);
				props.FirstLogin();
			}
		}
	}
	@SubscribeEvent
	public void OnLivingDeath(LivingDeathEvent event){
		// we only want to save data for players (most likely, anyway)
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			// NOTE: See step 6 for a way to do this all in one line!!!
			// create a new NBT Tag Compound to store the IExtendedEntityProperties data
			NBTTagCompound playerData = new NBTTagCompound();
			// write the data to the new compound
			event.entity.getExtendedProperties(ModVars.NBTExtendedName).saveNBTData(playerData);
			// and store it in our proxy
			CommonProxy.storeEntityData(event.entity.getUniqueID(), playerData);
			// call our handy static one-liner to save custom data to the proxy
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event){
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			// NOTE: See step 6 for a way to do this all in one line!!!
			// before syncing the properties, we must first check if the player has some saved in the proxy
			// recall that 'getEntityData' also removes it from the map, so be sure to store it locally
			NBTTagCompound playerData = CommonProxy.getEntityData(event.entity.getUniqueID());
			// make sure the compound isn't null
			if (playerData != null) {
				((ExtendedPlayer)(event.entity.getExtendedProperties(ModVars.NBTExtendedName))).loadNBTData(playerData);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(LivingEvent.LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){ // We only want to use the player

			EntityPlayer player = (EntityPlayer)event.entity;
			ExtendedPlayer props = ExtendedPlayer.get(player);
			int playerElement = props.getPlayerElement();
			// Part for passive player effects
			// Fire

			// Light

			// Dark

			// Water
			if(playerElement==ModVars.WATERELEMENT){
				player.setAir(300);
				for(int i=-2;i<3;i++){
					for(int j=-2;j<3;j++) {
						for(int k =-2;k<3;k++) {
							Block block = player.worldObj.getBlock((int) player.posX + i, (int) player.posY + k, (int) player.posZ + j);
							if (block instanceof BlockFire || block==Blocks.lava || block==Blocks.flowing_lava || block==Blocks.lit_furnace ){
								System.out.println("BURN BABY BURN");
								player.setFire(3);
							}
						}
					}
				}
			}
			// Nature

			// Steam

			// Poison
			if(playerElement == ModVars.POISONELEMENT){
				PotionEffect poisonActive = player.getActivePotionEffect(Potion.poison);
				if(poisonActive!=null) {
					int amp = poisonActive.getAmplifier();
					int dur = poisonActive.getDuration();
					player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), dur, amp));
					player.removePotionEffect(Potion.poison.getId());
				}
				List foundEntities;
				if(!player.isInWater()) {
					foundEntities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX - 5, player.posY - 4, player.posZ - 5, player.posX + 5, player.posY + 4, player.posZ + 5));
					for(int i=0; i < foundEntities.size();i++) {
						Object currentElement = foundEntities.get(i);
						if(currentElement instanceof EntityMob && currentElement != player){
							if(((EntityLivingBase) currentElement).getActivePotionEffect(Potion.poison)==null) {
								((EntityLivingBase) currentElement).addPotionEffect(new PotionEffect(Potion.poison.getId(), 100, 1));
							}
						}
					}
				}
				else {
					foundEntities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX - 11, player.posY - 4, player.posZ - 11, player.posX + 11, player.posY + 4, player.posZ + 11));
					for(int i=0; i < foundEntities.size();i++) {
						Object currentElement = foundEntities.get(i);
						if(currentElement instanceof EntityMob && currentElement != player){
							if(((EntityLivingBase) currentElement).getActivePotionEffect(Potion.poison)==null) {
								if(((EntityLivingBase)currentElement).isInWater()) {
									((EntityLivingBase) currentElement).addPotionEffect(new PotionEffect(Potion.poison.getId(), 100, 1));
								}
							}
						}
					}
				}

			}

			// Sunfire
			if(playerElement==ModVars.SUNFIREELEMENT){
				List foundEntities = player.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox(player.posX - 12, player.posY - 5, player.posZ - 12, player.posX + 12, player.posY + 5, player.posZ + 12));
				for(int i=0; i < foundEntities.size();i++) {
					Object currentElement = foundEntities.get(i);
					if(currentElement instanceof EntitySkeleton || currentElement instanceof EntityZombie){
						if(player.canEntityBeSeen((Entity)currentElement)){
							((Entity) currentElement).setFire(5);
						}
					}
				}
				int lightLevel = player.worldObj.getFullBlockLightValue((int) player.posX, (int) player.posY, (int) player.posZ);
				if(lightLevel < 9){
					player.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 5, 1));
				}
			}
			// Taint
			if(playerElement==ModVars.TAINTELEMENT){
				List foundEntities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX - 5, player.posY - 1, player.posZ - 5, player.posX + 5, player.posY + 5, player.posZ + 5));
				for(int i=0; i < foundEntities.size();i++) {
					Object currentElement = foundEntities.get(i);
					if(currentElement instanceof EntityLivingBase && currentElement != player && !(currentElement instanceof DSTrader)){
						PotionEffect posionActive = player.getActivePotionEffect(Potion.poison);
						if(posionActive!=null){
							//((EntityLivingBase) currentElement).addPotionEffect(new PotionEffect(Potion.poison.getId(), ));
						}
					}
				}
			}
			// Curse

			// Flower
			if(playerElement==ModVars.FLOWERELEMENT){
				for(int i=-5;i<6;i++){
					for(int j=-5;j<6;j++) {
						for(int k =-2;k<3;k++) {
							Block block = player.worldObj.getBlock((int) player.posX + i, (int) player.posY + k, (int) player.posZ + j);
							int dmgValue = block.getDamageValue(player.worldObj, (int) player.posX + i, (int) player.posY + k, (int) player.posZ + j);
							if (block instanceof BlockFlower || block instanceof BlockDoublePlant && dmgValue != 2 && dmgValue != 3){
								player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 60, 1));
							}
						}
					}
				}
			}
			// Ash

			// Ice

			// Spirit
			if(playerElement==ModVars.SPIRITELEMENT){
				ModHelper.removeBadPotions(player);
				player.removePotionEffect(Potion.moveSpeed.id);
				player.removePotionEffect(Potion.digSpeed.id);
				player.removePotionEffect(Potion.damageBoost.id);
				player.removePotionEffect(Potion.fireResistance.id);
				player.removePotionEffect(Potion.heal.id);
				player.removePotionEffect(Potion.invisibility.id);
				if(player.getActivePotionEffect(Potion.regeneration)!=null && !props.allowedRegeneration) {
					player.removePotionEffect(Potion.regeneration.id);
				}
				else if(player.getActivePotionEffect(Potion.regeneration)==null){
					props.allowedRegeneration=false;
				}
				player.removePotionEffect(Potion.waterBreathing.id);
				player.removePotionEffect(Potion.jump.id);
				player.removePotionEffect(Potion.nightVision.id);
			}

			// Storm

			// Stamina Regeneration
			float currentStamina = player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER);
			if(currentStamina < props.getMaxStamina()){
				props.refillStamine(0.4F);
			}
		}// End of IF statement
	}
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event){ // Event for on block break
		if(event.block == ModBlocks.bonfire) {// We only want to do everything when the block is the bonfire. Or else we crash like hell.
			TileEntityBonfire t = (TileEntityBonfire) event.world.getTileEntity(event.x, event.y, event.z);
			String owner = t.getOwner();
			String playerBreaking = event.getPlayer().getDisplayName();
			if (owner == playerBreaking) {
				event.setCanceled(false);
			}
			else {
				ItemStack currentItem = event.getPlayer().inventory.getCurrentItem();
				if(currentItem != null && currentItem.getItem() == ModItems.testItem){
					event.setCanceled(false);
				}
				else{
					event.setCanceled(true);
					ModHelper.displayChat(event.getPlayer(), "You are not the owner.");
				}
			}
		}
	}
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event){
		EntityPlayer player = event.entityPlayer;
		ExtendedPlayer props = ExtendedPlayer.get(player);
		float currentStamina = player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER);
		if(currentStamina >= props.staminaNeeded) {
			props.consumeStamina(props.staminaNeeded);
			props.staminaNeeded = 0;
		}
		else {
			ModHelper.displayChat(player, "Your stamina is to low " + currentStamina);
			event.setCanceled(true);
		}
		// Ash for blindness
		if(props.getPlayerElement()==ModVars.ASHELEMENT){
			if(event.target instanceof EntityPlayer) {
				EntityLivingBase target = (EntityLivingBase) event.target;
				target.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 60, 0));
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Pre event) {
		// called before the vanilla rendering occurs
		// canceling will prevent normal rendering
		if(event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE)
			event.setCanceled(true);

	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Post event) {
		// called after vanilla rendering completed (or canceled)
		// maybe try doing your rendering here
		Minecraft mc = Minecraft.getMinecraft();
		EntityClientPlayerMP player = mc.thePlayer;
		ExtendedPlayer props = ExtendedPlayer.get(player);
		int playerElement = props.getPlayerElement();
		int playerClass = props.getPlayerClass();
		if (event.isCancelable() || event.type == RenderGameOverlayEvent.ElementType.FOOD)
		{
			mc.fontRenderer.drawString("Stamina: "+player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER) +"", 100, 190, 0x000000);
			mc.fontRenderer.drawString("HP:      "+ player.getHealth() + "", 100, 200, 0xffff80);
			mc.fontRenderer.drawString("EXP:     "+ player.experienceTotal + "", 100, 210, 0xffff80);
			mc.fontRenderer.drawString("Class:   " + ModVars.CLASSNAMES[playerClass], 160, 200, 0xffff80);
			mc.fontRenderer.drawString("Element: " + ModVars.ELEMENTNAMES[playerElement], 160, 210, 0xffff80);
		}

	}

}