package starglas.dsremake.common.helpers;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
	
	public static void onEntityPlay(String name, World world, Entity entity, float volume, float pitch){
		world.playSoundAtEntity(entity, (ModVars.MODID + ":" + name), volume, pitch);
	}
}
