package starglas.dsremake.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.items.consumables.ItemDSBucket;

/**
 * Created by Starlight on 7-7-2015.
 */
public class ModFluids {
    public static Fluid fluidPoison = new Fluid("poison").setGaseous(true);
    public static Material materialPoison = new MaterialLiquid(MapColor.grassColor);
    public static Block blockFluidPoison;

    public static Item PoisonBucket = new ItemDSBucket(ModFluids.blockFluidPoison).setUnlocalizedName("PoisonBucket");
    public static void init(){

        FluidRegistry.registerFluid(fluidPoison);
        blockFluidPoison = new BlockFluidPoison().setBlockName("fluid_poison");
        ModHelper.registerBlock(blockFluidPoison);
        ModHelper.registerItem(PoisonBucket);
    }

}
