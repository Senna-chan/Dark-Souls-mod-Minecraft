package starglas.dsremake.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import starglas.dsremake.fluids.ModFluids;

import java.util.Random;

/**
 * Created by Starlight on 9-7-2015.
 */
public class ChunkProviderGenerator implements IWorldGenerator{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0: //Overworld
                int x = chunkX * 16 + random.nextInt(16);
                int z = chunkZ * 16 + random.nextInt(16);
                BiomeGenBase b = world.getBiomeGenForCoords(x, z);
                String biomeName = b.biomeName;
                int rarity = 5;
                if (rarity > 0 && biomeName.equals("Poison") && random.nextInt(rarity) == 0) {
                    int lakeX = x - 8 + random.nextInt(16);
                    int lakeY = random.nextInt(world.getActualHeight());
                    int lakeZ = z - 8 + random.nextInt(16);
                    new WorldGenLakes(ModFluids.blockFluidPoison).generate(world, random, lakeX, lakeY, lakeZ);
                }
                break;
            case -1: //Nether

                break;
            case 1: //End

                break;
        }

    }
}
