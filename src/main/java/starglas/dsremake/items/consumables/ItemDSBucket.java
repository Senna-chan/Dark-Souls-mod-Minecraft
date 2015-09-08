package starglas.dsremake.items.consumables;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.fluids.ModFluids;

/**
 * Created by Starlight on 7-7-2015.
 */
public class ItemDSBucket extends ItemBucket {
    private Block liquidBlock;

    public ItemDSBucket(Block block) {
        super(block);
        this.setMaxStackSize(1);
        this.setCreativeTab(DSMainCreativeTabs.tabDSFluids);
        this.setContainerItem(Items.bucket);
        this.liquidBlock = block;
    }

    @Override
    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z) {
        if(!world.isAirBlock(x, y, z) && world.getBlock(x, y, z).isNormalCube())return false;
        else {
            world.setBlock(x, y, z, ModFluids.blockFluidPoison, 0, 3);
            return true;
        }
    }
}
