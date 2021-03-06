
package net.sauromods.wildlifeplus.item;

import net.sauromods.wildlifeplus.init.WildlifeplusModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class AvocadoItem extends Item {
	public AvocadoItem() {
		super(new Item.Properties().tab(WildlifeplusModTabs.TAB_WILDLIFE_PLUS).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f)

						.build()));
		setRegistryName("avocado");
	}
}
