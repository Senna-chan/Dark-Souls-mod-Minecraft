package starglas.dsremake.common.items.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.SoundHandler;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Estus extends ItemBucketMilk {

	private float playerHP;
	private float playerMaxHP;
	private int ItemDMG;
	private int ChangedItemDMG;

	public Estus() {
		super();
		this.setCreativeTab(CreateCreativeTab.tabDSConsume);
		this.setTextureName(Reference.MODID + ":myFirstItem");
		this.setMaxStackSize(1);
		this.setMaxDamage(19);
	}

	public int getMaxItemUseDuration(ItemStack Items) {
		return 15;
	}

	public ItemStack onEaten(ItemStack Items, World world, EntityPlayer player) {
		
		SoundHandler.onEntityPlay("ChugThatEstus", world, player, 1, 1);
		player.setHealth((float) (playerHP + (playerMaxHP * 0.40)));
		Items.damageItem(1, player);
		this.ChangedItemDMG = Items.getItemDamage();
		if (this.ChangedItemDMG == this.ItemDMG) {
			Items.damageItem(1, player);
		}
		return Items;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack Items, World world,
			EntityPlayer player) {
		// this.ItemDMG = Items.getItemDamage();
		// this.playerMaxHP = player.getMaxHealth();
		// this.playerHP = player.getHealth();
		// player.setHealth(10F);
		// if(this.playerHP < this.playerMaxHP){
		// SoundHandler.onEntityPlay("ChugThatEstus", world, player, 1, 1);
		// player.setHealth((float) (playerHP + (playerMaxHP*0.40)));
		// Items.damageItem(1, player);
		// this.ChangedItemDMG = Items.getItemDamage();
		// }
		// if(this.ChangedItemDMG == this.ItemDMG){
		// Items.damageItem(1, player);
		// }
		// return Items;
		player.setHealth(10F);
		if(this.ItemDMG != 19){
			this.ItemDMG = Items.getItemDamage();
			this.playerMaxHP = player.getMaxHealth();
			this.playerHP = player.getHealth();
			if (this.playerHP < this.playerMaxHP) {
				player.setItemInUse(Items, this.getMaxDamage(Items));
			}
		}
		return Items;
		
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

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) { // Sets enchanting glow
		return true;
	}

	public void refillEstus(ItemStack itemStack)
	{
	    itemStack.setItemDamage(0);
	}
}