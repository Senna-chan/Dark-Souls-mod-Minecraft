package starglas.dsremake.entity.mobs;

import starglas.dsremake.client.gui.GuiCustomMerchant;
import starglas.dsremake.common.MCACommonLibrary.IMCAnimatedEntity;
import starglas.dsremake.common.MCACommonLibrary.animation.AnimationHandler;
import starglas.dsremake.common.animations.Vilerevenant.AnimationHandlerVilerevenant;
import starglas.dsremake.common.helpers.ModMerchantRecipes;
import starglas.dsremake.items.ModItems;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityVilerevenant extends EntityCreature implements IMCAnimatedEntity, IMerchant, INpc {
	protected AnimationHandler animHandler = new AnimationHandlerVilerevenant(this);
	private EntityPlayer buyingPlayer;
	private MerchantRecipeList buyingList;
	public EntityVilerevenant(World par1World) {
		super(par1World);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 0.8D));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	public AnimationHandler getAnimationHandler() {
		return animHandler;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(!this.getAnimationHandler().isAnimationActive("Idle")) {
	        this.getAnimationHandler().activateAnimation("Idle", 0);
	    }
        
    }

	public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;
        if (!this.worldObj.isRemote)
        {
            this.setCustomer(player);
            player.displayGUIMerchant(this, "Vile Revenant");//(new GuiCustomMerchant(player.inventory, this, player.worldObj, this.getCustomNameTag()));
        }

        return true;
    }
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readEntityFromNBT(nbttagcompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeEntityToNBT(nbttagcompound);
	}
	
	@Override
	public void setCustomer(EntityPlayer player)
    {
        this.buyingPlayer = player;
    }
	
	@Override
    public EntityPlayer getCustomer()
    {
        return this.buyingPlayer;
    }

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer player) {
		return ModMerchantRecipes.getRecipes("poison");
    }
	
	@Override
	public void setRecipes(MerchantRecipeList recipeList) {

	}


	@Override
	public void useRecipe(MerchantRecipe p_70933_1_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void func_110297_a_(ItemStack p_110297_1_) {

	}
}