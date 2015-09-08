package starglas.dsremake.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EntityAIRadiusInteractions extends EntityAIBase {
	public final IEntitySelector field_98218_a = new IEntitySelector()
	{
		/**
		 * Return whether the specified entity is applicable to this filter.
		 */
		public boolean isEntityApplicable(Entity p_82704_1_)
		{
			return p_82704_1_.isEntityAlive() && EntityAIRadiusInteractions.this.theEntity.getEntitySenses().canSee(p_82704_1_);
		}
	};
	private Potion potion;
	private PotionEffect potionEffect;
	private int radius;
	private EntityPlayer closestLivingEntity;
	private EntityCreature theEntity;
	private Class targetEntityClass;

	public EntityAIRadiusInteractions(EntityCreature entity, PotionEffect potionEffect, Potion potion, int radius) {
		this.theEntity = entity;
		this.targetEntityClass = EntityPlayer.class;
		this.potionEffect = potionEffect;
		this.potion = potion;
		this.radius = radius;
	}

	@Override
	public boolean shouldExecute() {
		if (this.targetEntityClass == EntityPlayer.class)
		{
			this.closestLivingEntity = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, (double)this.radius);

			if (this.closestLivingEntity == null)
			{
				return false;
			}
			if(this.closestLivingEntity.getActivePotionEffect(this.potion)==null) {
				this.closestLivingEntity.addPotionEffect(this.potionEffect);
			}
		}
		return false;
	}

}
