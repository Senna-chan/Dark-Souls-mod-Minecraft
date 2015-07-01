package starglas.dsremake.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import starglas.dsremake.common.helpers.ModHelper;

import java.util.List;

public class EntityAIRadiusInteractions extends EntityAIBase {
	public final IEntitySelector field_98218_a = new IEntitySelector()
	{
		private static final String __OBFID = "CL_00001575";
		/**
		 * Return whether the specified entity is applicable to this filter.
		 */
		public boolean isEntityApplicable(Entity p_82704_1_)
		{
			return p_82704_1_.isEntityAlive() && EntityAIRadiusInteractions.this.theEntity.getEntitySenses().canSee(p_82704_1_);
		}
	};
	private int potionEffect;
	private int duration;
	private int amplifier;
	private int radius;
	private EntityPlayer closestLivingEntity;
	private EntityCreature theEntity;
	private Class targetEntityClass;

	public EntityAIRadiusInteractions(EntityCreature entity, int potionEffect, int duration, int amplifier, int radius) {
		this.theEntity = entity;
		this.targetEntityClass = EntityPlayer.class;
		this.potionEffect = potionEffect;
		this.duration = duration;
		this.amplifier = amplifier;
		this.radius = radius;
	}

	@Override
	public boolean shouldExecute() {
		if (this.targetEntityClass == EntityPlayer.class)
		{
			if (this.theEntity instanceof EntityTameable && ((EntityTameable)this.theEntity).isTamed())
			{
				return false;
			}

			this.closestLivingEntity = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, (double)this.radius);

			if (this.closestLivingEntity == null)
			{
				return false;
			}
			ModHelper.displayChat(this.closestLivingEntity, "hi");
			this.closestLivingEntity.addPotionEffect(new PotionEffect(this.potionEffect, this.duration, this.amplifier));
		}
		return false;
	}

}
