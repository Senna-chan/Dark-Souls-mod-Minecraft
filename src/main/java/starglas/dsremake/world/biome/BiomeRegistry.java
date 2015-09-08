package starglas.dsremake.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import starglas.dsremake.common.helpers.ModVars;

public class BiomeRegistry {

    public static void init(){
        initializeBiome();
        registerBiome();
    }

    public static BiomeGenBase biomePoison;

    public static void initializeBiome(){
        biomePoison = new BiomeGenPoison(ModVars.BIOME_POISON).setBiomeName("Poison");
    }

    public static void registerBiome(){
        BiomeDictionary.registerBiomeType(biomePoison, BiomeDictionary.Type.PLAINS);
        BiomeDictionary.registerAllBiomesAndGenerateEvents();
        BiomeManager.addSpawnBiome(biomePoison);
    }

}
