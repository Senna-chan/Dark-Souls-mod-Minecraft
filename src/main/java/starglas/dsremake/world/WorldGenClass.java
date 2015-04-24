package starglas.dsremake.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGenClass {
	public static void init(){
		registerWorldGen(new OreGenClass(),1);
	}
	public static void registerWorldGen(IWorldGenerator worldgen, int modGenerationWeight){
		GameRegistry.registerWorldGenerator(worldgen, modGenerationWeight);
	}
}
