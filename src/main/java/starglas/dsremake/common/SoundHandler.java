package starglas.dsremake.common;

import starglas.dsremake.common.helpers.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
	
	public static void onEntityPlay(String name, World world, Entity entity, float volume, float pitch){
		world.playSoundAtEntity(entity, (Reference.MODID + ":" + name), (float)volume, (float)pitch);
	}
}
