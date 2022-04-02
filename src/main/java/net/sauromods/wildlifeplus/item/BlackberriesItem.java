
package net.sauromods.wildlifeplus.item;

import net.sauromods.wildlifeplus.init.WildlifeplusModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class BlackberriesItem extends Item {
	public BlackberriesItem() {
		super(new Item.Properties().tab(WildlifeplusModTabs.TAB_WILDLIFE_PLUS).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.6f)

						.build()));
		setRegistryName("blackberries");
	}
}
