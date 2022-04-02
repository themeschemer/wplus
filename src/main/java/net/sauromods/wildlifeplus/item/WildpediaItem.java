
package net.sauromods.wildlifeplus.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

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
