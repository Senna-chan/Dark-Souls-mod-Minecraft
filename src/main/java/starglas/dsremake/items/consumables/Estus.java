package starglas.dsremake.items.consumables;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.common.helpers.SoundHandler;
import starglas.dsremake.handler.ExtendedPlayer;

public class Estus extends Item {

	private float playerHP;
	private float playerMaxHP;
	private int ItemDMG;
	private int MaxEstusUses = 4;
	
	public Estus() {
		super();
		this.setCreativeTab(DSMainCreativeTabs.tabDSConsume);
		this.setMaxStackSize(1);
		this.setMaxDamage(4);
	}

	public int getMaxItemUseDuration(ItemStack Items) {
		return 15;
	}
	public ItemStack onEaten(ItemStack Items, World world, EntityPlayer player) {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		int playerElement = props.getPlayerElement();
		SoundHandler.onEntityPlay("ChugThatEstus", world, player, 1, 1);
		player.setHealth((float) (playerHP + (playerMaxHP * 0.40)));
		if(playerElement!= ModVars.TAINTELEMENT){
			if (!world.isRemote)
	        {
				player.removePotionEffect(Potion.hunger.id);
				player.removePotionEffect(Potion.confusion.id);
				player.removePotionEffect(Potion.poison.id);
				player.removePotionEffect(Potion.weakness.id);
				player.removePotionEffect(Potion.wither.id);
				player.removePotionEffect(Potion.blindness.id);
				player.removePotionEffect(Potion.digSlowdown.id);
				player.removePotionEffect(Potion.moveSlowdown.id);
	        }
		}
		Items.damageItem(1, player);
		int ChangedItemDMG = Items.getItemDamage();
		if (ChangedItemDMG == this.ItemDMG) {
			Items.damageItem(1, player);
		}
		return Items;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		this.ItemDMG = item.getItemDamage();
		if(this.ItemDMG != this.MaxEstusUses){
			this.playerMaxHP = player.getMaxHealth();
			this.playerHP = player.getHealth();
			if (this.playerHP < this.playerMaxHP) {
				player.setItemInUse(item, this.getMaxItemUseDuration(item));
			}
		}
		return item;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) { // Sets name coloring
		return EnumRarity.rare;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.drink;
	}

	public void refillEstus(ItemStack itemStack, int mark)
	{
		if(mark==1){
			this.setMaxDamage(4);
			this.MaxEstusUses = 4;
			this.ItemDMG = 0;
			itemStack.setItemDamage(0);
		}
		else if(mark==2){
			this.setMaxDamage(9);
			this.MaxEstusUses = 9;
			this.ItemDMG = 0;
			itemStack.setItemDamage(0);
		}
		else if(mark==3){
			this.setMaxDamage(14);
			this.MaxEstusUses = 14;
			this.ItemDMG = 0;
			itemStack.setItemDamage(0);
		}
		else if(mark==4){
			this.setMaxDamage(19);
			this.MaxEstusUses = 19;
			this.ItemDMG = 0;
			itemStack.setItemDamage(0);
		}
	}
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		ModHelper.displayChat(player, "Can't drop this. Sorry brah");
		return false;
	}
}