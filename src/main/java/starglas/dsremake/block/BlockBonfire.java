package starglas.dsremake.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.common.helpers.SoundHandler;
import starglas.dsremake.entity.tileentity.TileEntityBonfire;
import starglas.dsremake.handler.ExtendedPlayer;
import starglas.dsremake.items.ModItems;
import starglas.dsremake.items.consumables.Estus;

public class BlockBonfire extends BlockContainer{

	private int BonFireLevel;

	protected BlockBonfire() {
		super(Material.ground);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setHardness(0.5F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.3F, 1F);
		this.setBlockTextureName(ModReference.MODID + ":bonfireparticle");
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
//	@Override
//	public void onBlockAdded(World world, int X, int Y, int Z)
//    {
//		super.onBlockAdded(world, X, Y, Z);
//		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
//        t.onPlaced(world.getClosestPlayer(5, 5, 5, 5));
//        
//    }
	
	public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int par6, float par7, float par8, float par9){
		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
		this.BonFireLevel = t.getBonFireLevel();
		ModHelper.displayChat(player, this.BonFireLevel+"");
		
		player.heal(player.getMaxHealth());
		if(player.getFoodStats().getFoodLevel()<10){
			player.getFoodStats().setFoodLevel(10);
		}
		SoundHandler.onEntityPlay("BonfireLit", world, player, 1, 1);
		if(player.inventory.hasItem(ModItems.Estus)){
			ItemStack[] playerInventory = player.inventory.mainInventory;

            for(ItemStack itemStack : playerInventory)
            {
                if(itemStack != null && itemStack.getItem() instanceof Estus)
                {
                    ((Estus)itemStack.getItem()).refillEstus(itemStack, BonFireLevel);
                    break;
                }
            }
		}
		else {
			ModHelper.displayChat(player, "Oi what happend to your Estus?");
			player.inventory.addItemStackToInventory(new ItemStack(ModItems.Estus));
		}
		ExtendedPlayer props = ExtendedPlayer.get(player);
		props.saveLastVisitedBonfire(player.posX, player.posY, player.posZ);
		
		//if(!world.isRemote)
        //{
			//t.processOnActivate(player, world);
			//DSPlayerHandler handler = new DSPlayerHandler(player);
			//handler.saveLastVisitedBonfire(X, Y, Z);
        //}
		//Minecraft.getMinecraft().displayGuiScreen(new BonFireGui(X, Y, Z));
		return false;
	}
}