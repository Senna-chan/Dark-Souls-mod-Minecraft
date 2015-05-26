package starglas.dsremake.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import starglas.dsremake.common.DSMainCreativeTabs;
import starglas.dsremake.common.SoundHandler;
import starglas.dsremake.common.entity.TileEntityBonfire;
import starglas.dsremake.common.gui.BonFireGui;
import starglas.dsremake.common.helpers.ModReference;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.common.items.consumables.Estus;
import starglas.dsremake.handler.DSPlayerHandler;

public class BlockBonfire extends BlockContainer{

	private int BonFireLevel;

	protected BlockBonfire() {
		super(Material.ground);
		this.setCreativeTab(DSMainCreativeTabs.tabDSBlocks);
		this.setHardness(0.5F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.3F, 1F);
		this.setBlockTextureName(ModReference.MODID + ":bonfire");
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
		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
        t.onPlaced(Minecraft.getMinecraft().thePlayer);
        super.onBlockAdded(world, X, Y, Z);
    }
	
	public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int par6, float par7, float par8, float par9){
		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
		this.BonFireLevel = t.getBonFireLevel();
		
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
		//if(!world.isRemote)
        //{
			//t.processOnActivate(player, world);
			DSPlayerHandler handler = new DSPlayerHandler(player);
			handler.saveLastVisitedBonfire(X, Y, Z);
        //}
		Minecraft.getMinecraft().displayGuiScreen(new BonFireGui(X, Y, Z));
		return false;
	}
	
	/*@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){	
		this.blockIcon = icon.registerIcon(ModBlocks.blockBonfire);
	}*/
	
	
}
