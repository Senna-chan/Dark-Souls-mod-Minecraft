package starglas.dsremake.items.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import starglas.dsremake.common.helpers.DSMainCreativeTabs;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.entity.projectiles.spells.EntityFireball;
import starglas.dsremake.handler.ExtendedPlayer;

public class fireball extends DSSpells{
    double entityposX;
    double entityposY;
    double entityposZ;


    public fireball(){
        super();
        this.setCreativeTab(DSMainCreativeTabs.tabDSSpells);
        this.setMaxDamage(-1);
    }

    public int getMaxItemUseDuration(ItemStack Items) {
        return 72000;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        float stamina = player.getDataWatcher().getWatchableObjectFloat(ModVars.STAMINA_WATCHER);
        if(stamina >= 20) {
            ModHelper.displayChat(player, "FIREBALL");
            ExtendedPlayer props = ExtendedPlayer.get(player);
            props.consumeStamina(20);
            Vec3 look = player.getLookVec();
            int position = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            if(position == 0){
                entityposZ = player.posZ + 1;
                entityposX = player.posX;
            }
            else if(position == 1){
                entityposZ = player.posZ;
                entityposX = player.posX - 1;
            }
            else if(position == 2){
                entityposZ = player.posZ - 1;
                entityposX = player.posX;
            }
            else if(position == 3){
                entityposZ = player.posZ;
                entityposX = player.posX + 1;
            }
            entityposY = player.posY + 1;
            if(!world.isRemote) {
                System.out.println(1);
                world.spawnEntityInWorld(new EntityFireball(world, entityposX, entityposY, entityposZ, look.xCoord, look.yCoord, look.zCoord, 5));
            }
        }
        else{
            ModHelper.displayChat(player, "Git More Stamina");
        }
        return itemStack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.block;
    }

}
