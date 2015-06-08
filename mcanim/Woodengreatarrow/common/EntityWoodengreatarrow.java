package yourModPackage.common.entities;

import yourModPackage.common.MCACommonLibrary.IMCAnimatedEntity;
import yourModPackage.common.MCACommonLibrary.animation.AnimationHandler;
import yourModPackage.common.animations.Woodengreatarrow.AnimationHandlerWoodengreatarrow;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityWoodengreatarrow extends Entity implements IMCAnimatedEntity {
	protected AnimationHandler animHandler = new AnimationHandlerWoodengreatarrow(this);

	public EntityWoodengreatarrow(World par1World) {
		super(par1World);
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
        }

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
	}
}