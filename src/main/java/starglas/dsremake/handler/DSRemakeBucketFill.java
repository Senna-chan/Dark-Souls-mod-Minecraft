package starglas.dsremake.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import starglas.dsremake.fluids.ModFluids;

/**
 * Created by Starlight on 7-7-2015.
 */
public class DSRemakeBucketFill {

    @SubscribeEvent
    public void FillBucket(FillBucketEvent event){
        if(event.current.getItem() != Items.bucket ) return;


        ItemStack fullBucket = getLiquid(event.world, event.target);

        if(fullBucket == null) return;

        event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
        event.result = fullBucket;
        event.setResult(Event.Result.ALLOW);
    }

    private ItemStack getLiquid(World world, MovingObjectPosition pos){
        Block theBlock = world.getBlock(pos.blockX,pos.blockY,pos.blockZ);
        if(theBlock == ModFluids.blockFluidPoison) return new ItemStack(ModFluids.PoisonBucket);

        return null;
    }

}
