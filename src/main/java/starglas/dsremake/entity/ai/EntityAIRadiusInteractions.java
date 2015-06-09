package starglas.dsremake.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;

public class EntityAIRadiusInteractions extends EntityAIBase {

	private Potion potionEffect;
	private int duration;
	private int amplifier;
	private int radius;

	public EntityAIRadiusInteractions(Potion potionEffect, int duration, int amplifier, int radius) {
		this.potionEffect = potionEffect;
		this.duration = duration;
		this.amplifier = amplifier;
		this.radius = radius;
	}

	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		return false;
	}

}
