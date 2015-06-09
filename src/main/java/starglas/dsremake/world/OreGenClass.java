package starglas.dsremake.world;

import java.util.Random;

import starglas.dsremake.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGenClass implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
			//generateNether(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 0:
			generateOverworld(random, chunkX * 16, chunkZ * 16, world);
			break;
		case 1:
			break;
		}
	}
	private void addOre(Block block, Block blockspawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVein, int maxVein, int spawnChange){
		for(int i = 0; i < spawnChange; i++){
			int xPos = posX + random.nextInt(16);
			int yPos = minY + random.nextInt(maxY - minY);
			int zPos = posZ + random.nextInt(16);
			
			new WorldGenMinable(block, (minVein + random.nextInt(maxVein - minVein)), blockspawn).generate(world, random, xPos, yPos, zPos);
		}
	}
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
		addOre(ModBlocks.BloodstoneOre, Blocks.stone, random, world, chunkX, chunkZ, 10, 35, 2, 5, 10);
	}
}
