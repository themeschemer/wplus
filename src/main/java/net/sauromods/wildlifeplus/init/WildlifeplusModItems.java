
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.sauromods.wildlifeplus.item.WildpediaItem;
import net.sauromods.wildlifeplus.item.BlackberriesItem;
import net.sauromods.wildlifeplus.item.AvocadoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WildlifeplusModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item AVOCADO = register(new AvocadoItem());
	public static final Item CAPYBARA = register(
			new SpawnEggItem(WildlifeplusModEntities.CAPYBARA, -6132165, -11126499, new Item.Properties().tab(WildlifeplusModTabs.TAB_WILDLIFE_PLUS))
					.setRegistryName("capybara_spawn_egg"));
	public static final Item WILDPEDIA = register(new WildpediaItem());
	public static final Item BLACKBERRIES = register(new BlackberriesItem());
	public static final Item BLACKBERRY_SHRUB = register(WildlifeplusModBlocks.BLACKBERRY_SHRUB, null);
	public static final Item BLACKBERRY_SAPLING = register(WildlifeplusModBlocks.BLACKBERRY_SAPLING, null);
	public static final Item BLACKBERRY_SEEDLING = register(WildlifeplusModBlocks.BLACKBERRY_SEEDLING, null);
	public static final Item BLACKBERRY_BUSH = register(WildlifeplusModBlocks.BLACKBERRY_BUSH, null);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
