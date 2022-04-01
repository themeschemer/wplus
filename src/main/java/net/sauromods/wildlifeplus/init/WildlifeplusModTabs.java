
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class WildlifeplusModTabs {
	public static CreativeModeTab TAB_WILDLIFE_PLUS;

	public static void load() {
		TAB_WILDLIFE_PLUS = new CreativeModeTab("tabwildlife_plus") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(WildlifeplusModItems.AVOCADO);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
