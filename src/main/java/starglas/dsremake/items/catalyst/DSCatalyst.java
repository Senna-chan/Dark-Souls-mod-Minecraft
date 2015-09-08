package starglas.dsremake.items.catalyst;

import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import starglas.dsremake.common.helpers.ModHelper;
import starglas.dsremake.common.helpers.ModVars;
import starglas.dsremake.items.ModItems;

/**
 * Created by Starlight on 10-7-2015.
 */
public class DSCatalyst extends ModItems {

    public static float weaponDamage;
    public DSCatalyst(){
        this.setMaxStackSize(1);
        this.setTextureName(ModVars.MODID + ":testtexture");
    }

    public float func_150931_i()
    {
        return weaponDamage;
    }

    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(/*SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()*/ "maxDamage", new AttributeModifier(field_111210_e, "Weapon modifier", (double) weaponDamage, 0));
        return multimap;
    }
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        ModHelper.displayChat(player, "Can't drop this.");
        return false;
    }
}
