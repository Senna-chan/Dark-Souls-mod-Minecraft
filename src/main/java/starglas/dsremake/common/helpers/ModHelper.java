package starglas.dsremake.common.helpers;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.items.ModItems;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModHelper
{
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, ModReference.MODID + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, ModReference.MODID + item.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Item item, IItemRenderer toRender){
		MinecraftForgeClient.registerItemRenderer(item , toRender);
	}
	/*
	 * Register smeling recipe using Item(What to smelt), ItemStack(What to return), float(What XP to gain)
	 */
	public static void registerSmelting(Item item, ItemStack itemstack, float XP){
		GameRegistry.addSmelting(item, itemstack, XP);
	}
	public static void displayChat(EntityPlayer player, String chatmessage){
		player.addChatMessage(new ChatComponentText(chatmessage));
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomId = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, DSMain.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 7,EnumCreatureType.creature, BiomeGenBase.extremeHills.jungle.forest.desert.sky.plains);
		createEgg(randomId, solidColor, spotColor);
	}

	private static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
}