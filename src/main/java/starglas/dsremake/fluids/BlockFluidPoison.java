package starglas.dsremake.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModVars;

/**
 * Created by Starlight on 7-7-2015.
 */
public class BlockFluidPoison extends BlockFluidClassic{

    public BlockFluidPoison() {
        super(ModFluids.fluidPoison, Material.water);
        this.setCreativeTab(DSMainCreativeTabs.tabDSFluids);
        this.setBlockTextureName(ModVars.MODID + ":fluidPoisonStill");
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int par1, int par2, int par3, Entity entity) {
        super.onEntityCollidedWithBlock(world, par1, par2, par3, entity);
        if(entity instanceof EntityLivingBase){
            PotionEffect gotPoison = ((EntityLivingBase) entity).getActivePotionEffect(Potion.poison);
            if(gotPoison==null) {
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.getId(), 100, 2));
            }
        }
    }
}
