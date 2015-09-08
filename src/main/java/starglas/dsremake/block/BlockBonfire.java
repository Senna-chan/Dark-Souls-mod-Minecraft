package starglas.dsremake.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.common.helpers.SoundHandler;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.gui.BonFireGui;
import starglas.dsremake.handler.ExtendedPlayer;
import starglas.dsremake.items.ModItems;
import starglas.dsremake.items.consumables.Estus;

public class BlockBonfire extends BlockContainer{

	protected BlockBonfire() {
		super(Material.ground);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setHardness(0.5F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.3F, 1F);
		this.setBlockTextureName(ModVars.MODID + ":bonfireparticle");
		this.lightValue = 15;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int inter) {
		return new TileEntityBonfire();
	}
	
	public  
	int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	@Override
	public void onBlockAdded(World world, int X, int Y, int Z)
    {
		super.onBlockAdded(world, X, Y, Z);
		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
        t.onPlaced(world.getClosestPlayer(X, Y, Z, 5), X, Y, Z, "Craftable Bonfire");
    }

	public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int par6, float par7, float par8, float par9){
		ExtendedPlayer props = ExtendedPlayer.get(player);
		// Tile entity stuff
		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
		int bonfireLevel = t.getBonFireLevel();
		String BonfireOwner = t.getOwner();

		// Sets player spawn
		player.setSpawnChunk(new ChunkCoordinates((int) player.posX, (int) player.posY, (int) player.posZ), true);
		// Heals plz
		player.extinguish();
		player.heal(player.getMaxHealth());
		ModHelper.removeBadPotions(player);
		if(player.getFoodStats().getFoodLevel()<10){
			player.getFoodStats().setFoodLevel(10);
		}

		SoundHandler.onEntityPlay("BonfireLit", world, player, 1, 1);
		// Estus code
		if(ModHelper.playerHasItem(player, ModItems.Estus) != -1){
			ItemStack estusStack = player.inventory.getStackInSlot(ModHelper.playerHasItem(player, ModItems.Estus));
			((Estus)estusStack.getItem()).refillEstus(estusStack, bonfireLevel);
		}
		else {
			ModHelper.displayChat(player, "Oi what happend to your Estus?");
			player.inventory.addItemStackToInventory(new ItemStack(ModItems.Estus));
		}
		// Savind the player posision for Homeward bone code
		props.saveLastVisitedBonfire(player.posX, player.posY, player.posZ);
		// Displays the GUI
		ItemStack currentItem = player.inventory.getCurrentItem();
		if(currentItem == null || currentItem.getItem() != ModItems.RadiantOil) {
			BonFireGui.BonFireX = X;
			BonFireGui.BonFireY = Y;
			BonFireGui.BonFireZ = Z;
			player.openGui(ModVars.MODID, ModVars.GUI_BONFIRE, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		else if(currentItem.getItem() == ModItems.RadiantOil) {
			if (t.getBonFireLevel() != 4) {
				int slot = ModHelper.playerHasItem(player, ModItems.RadiantOil);

				if (slot != -1) {
					player.inventory.decrStackSize(slot, 1);
					t.upgradeBonfire();
				}
			} else {
				ModHelper.displayChat(player, "This bonfire is already the highest level");
			}
		}

		ModHelper.displayChat(player, bonfireLevel + " " + BonfireOwner);
		return false;
	}
}