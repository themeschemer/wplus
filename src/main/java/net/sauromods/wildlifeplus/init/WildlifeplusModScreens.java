
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.sauromods.wildlifeplus.client.gui.WildpediaGUICapybaraScreen;
import net.sauromods.wildlifeplus.client.gui.AnimalBookScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WildlifeplusModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(WildlifeplusModMenus.ANIMAL_BOOK, AnimalBookScreen::new);
			MenuScreens.register(WildlifeplusModMenus.WILDPEDIA_GUI_CAPYBARA, WildpediaGUICapybaraScreen::new);
		});
	}
}
