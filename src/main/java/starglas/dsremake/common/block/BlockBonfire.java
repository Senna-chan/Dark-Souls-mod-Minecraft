package starglas.dsremake.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.common.SoundHandler;
import starglas.dsremake.common.items.ModItems;
import starglas.dsremake.common.items.consumables.Estus;

public class BlockBonfire extends BlockContainer{

	protected BlockBonfire() {
		super(Material.ground);
		this.setCreativeTab(CreateCreativeTab.tabDSBlocks);
		this.setHardness(0.5F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.3F, 1F);
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
	
	public int onBlockPlaced(World world, int X, int Y, int Z, EntityPlayer player){
		TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
        t.onPlaced(player);
		return 0;
	}
	
	public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int par6, float par7, float par8, float par9){
		System.out.println("Thou has activated thy bonfire");
		player.heal(player.getMaxHealth());
		player.getFoodStats().setFoodLevel(20);
		SoundHandler.onEntityPlay("BonfireLit", world, player, 1, 1);
		if(player.inventory.hasItem(ModItems.Estus)){
			ItemStack[] playerInventory = player.inventory.mainInventory;

            for(ItemStack itemStack : playerInventory)
            {
                if(itemStack != null && itemStack.getItem() instanceof Estus)
                {
                    ((Estus)itemStack.getItem()).refillEstus(itemStack);
                }
            }
		}
		if(!world.isRemote)
        {
			TileEntityBonfire t = (TileEntityBonfire) world.getTileEntity(X, Y, Z);
                t.processActivate(player, world);
        }
		player.addChatMessage(new ChatComponentText("Held item is: " + player.getHeldItem()));
		return false;
	}
	
	/*@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){	
		this.blockIcon = icon.registerIcon(ModBlocks.blockBonfire);
	}*/
	
	
}
