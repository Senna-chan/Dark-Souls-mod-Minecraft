package starglas.dsremake.common.items.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IChatComponent;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.SoundHandler;
import starglas.dsremake.common.helpers.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Estus extends Item {

	private float playerHP;
	private float playerMaxHP;
	private int ItemDMG;
	private int ChangedItemDMG;
	public Estus(){
		super();
		this.setCreativeTab(DSMain.tabDSConsume);
		this.setTextureName(Reference.MODID + ":myFirstItem");
		this.setMaxStackSize(1);
		this.setMaxDamage(19);
	}
	
	public ItemStack onItemRightClick(ItemStack Items, World world, EntityPlayer player)
    {
		this.ItemDMG = Items.getItemDamage();
		System.out.println(Items.getItemDamage() + " Before item dmg");
			this.playerMaxHP = player.getMaxHealth();
			this.playerHP = player.getHealth();
			player.setHealth(10F);
			if(this.playerHP < this.playerMaxHP){
				SoundHandler.onEntityPlay("ChugThatEstus", world, player, 1, 1);
				player.setHealth((float) (playerHP + (playerMaxHP*0.40)));
				Items.damageItem(1, player);
				this.ChangedItemDMG = Items.getItemDamage();
			}
			if(this.ChangedItemDMG == this.ItemDMG){
				Items.damageItem(1, player);
			}
			System.out.println(Items.getItemDamage() + " After item dmg");
		return Items;
    }
    
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){ // Sets name coloring
		return EnumRarity.rare;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){ // Sets enchanting glow
			return true;
	}
}