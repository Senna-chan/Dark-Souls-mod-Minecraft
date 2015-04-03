package starglas.dsremake.common.items.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.helpers.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Estus extends Item {

	private float playerHP;
	private float playerMaxHP;

	public Estus(){
		super();
		this.setCreativeTab(DSMain.tabDSConsume);
		this.setTextureName(Reference.MODID + ":myFirstItem");
		this.setMaxStackSize(1);
		this.setMaxDamage(19);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
		this.playerMaxHP = player.getMaxHealth();
		this.playerHP = player.getHealth();
		if(this.playerHP < this.playerMaxHP){
			player.setHealth((float) (playerHP + (playerMaxHP*0.40)));
			par1ItemStack.damageItem(1, player);
		}
		return par1ItemStack;
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