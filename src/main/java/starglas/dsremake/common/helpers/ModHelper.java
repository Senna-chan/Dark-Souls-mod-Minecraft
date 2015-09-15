package starglas.dsremake.common.helpers;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import starglas.dsremake.common.DSMain;

public class ModHelper
{
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, ModVars.MODID + block.getUnlocalizedName().substring(5));
	}
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, ModVars.MODID + item.getUnlocalizedName().substring(5));
	}

	public static void registerItemRender(Item item, IItemRenderer toRender){
		MinecraftForgeClient.registerItemRenderer(item, toRender);
	}
	public static void registerItemRender(Block block, IItemRenderer toRender){
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(block), toRender);
	}
	public static void registerBlockRender(Class block, TileEntitySpecialRenderer renderer){
		ClientRegistry.bindTileEntitySpecialRenderer(block, renderer);
	}

	public static void displayChat(EntityPlayer player, Object chatmessage){
		player.addChatMessage(new ChatComponentText((String)chatmessage));
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor, EnumCreatureType mobType, BiomeGenBase biometoSpawnIn) {
		int freeId = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, freeId);
		EntityRegistry.registerModEntity(entityClass, entityName, freeId, DSMain.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 7,mobType , biometoSpawnIn);
		createEgg(freeId, solidColor, spotColor);
	}
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int freeId = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, freeId);
		EntityRegistry.registerModEntity(entityClass, entityName, freeId, DSMain.instance, 64, 1, true);
		createEgg(freeId, solidColor, spotColor);
	}
	private static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
	public static int playerHasItem(EntityPlayer player, Item item) {
		ItemStack[] mainInventory = player.inventory.mainInventory;
		for (int i = 0; i < mainInventory.length; ++i)
		{
			if (mainInventory[i] != null && mainInventory[i].getItem() == item)
			{
				return i;
			}
		}

		return -1;
	}

	public static void removeBadPotions(EntityPlayer player) {
		player.removePotionEffect(Potion.hunger.id);
		player.removePotionEffect(Potion.confusion.id);
		player.removePotionEffect(Potion.poison.id);
		player.removePotionEffect(Potion.weakness.id);
		player.removePotionEffect(Potion.wither.id);
		player.removePotionEffect(Potion.blindness.id);
		player.removePotionEffect(Potion.digSlowdown.id);
		player.removePotionEffect(Potion.moveSlowdown.id);
	}
}