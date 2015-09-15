package starglas.dsremake.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import starglas.dsremake.block.ModBlocks;
import starglas.dsremake.entity.mobs.creature.EntityDeadsapsprout;

/**
 * Created by Starlight on 7-7-2015.
 * 7428467300287204440
 * */
public class BiomeGenPoison extends BiomeGenBase{

    public BiomeGenPoison(int id){
        super(id);
        this.theBiomeDecorator.generateLakes=false;
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.deadBushPerChunk = 10;

        this.waterColorMultiplier = 100;

        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDeadsapsprout.class, 1, 1, 1));



        this.topBlock = Blocks.dirt;
        this.fillerBlock = Blocks.dirt;
    }

}