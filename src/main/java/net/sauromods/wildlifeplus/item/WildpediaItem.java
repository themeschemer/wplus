
package net.sauromods.wildlifeplus.item;

import net.sauromods.wildlifeplus.init.WildlifeplusModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class WildpediaItem extends Item {
	public WildpediaItem() {
		super(new Item.Properties().tab(WildlifeplusModTabs.TAB_WILDLIFE_PLUS).stacksTo(64).rarity(Rarity.RARE));
		setRegistryName("wildpedia");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("An ancient book that holds the answers"));
		list.add(new TextComponent("to every known species of wildlife."));
		list.add(new TextComponent("Right-click a species to learn more about it."));
	}
}
