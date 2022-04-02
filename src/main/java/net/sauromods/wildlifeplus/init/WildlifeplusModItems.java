
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.sauromods.wildlifeplus.item.AvocadoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WildlifeplusModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item AVOCADO = register(new AvocadoItem());
	public static final Item CAPYBARA = register(
			new SpawnEggItem(WildlifeplusModEntities.CAPYBARA, -6132165, -11126499, new Item.Properties().tab(WildlifeplusModTabs.TAB_WILDLIFE_PLUS))
					.setRegistryName("capybara_spawn_egg"));

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
