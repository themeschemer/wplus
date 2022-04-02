
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.sauromods.wildlifeplus.block.BlackberryShrubBlock;
import net.sauromods.wildlifeplus.block.BlackberrySeedlingBlock;
import net.sauromods.wildlifeplus.block.BlackberrySaplingBlock;
import net.sauromods.wildlifeplus.block.BlackberryBushBlock;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WildlifeplusModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block BLACKBERRY_SHRUB = register(new BlackberryShrubBlock());
	public static final Block BLACKBERRY_SAPLING = register(new BlackberrySaplingBlock());
	public static final Block BLACKBERRY_SEEDLING = register(new BlackberrySeedlingBlock());
	public static final Block BLACKBERRY_BUSH = register(new BlackberryBushBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			BlackberryShrubBlock.registerRenderLayer();
			BlackberrySaplingBlock.registerRenderLayer();
			BlackberrySeedlingBlock.registerRenderLayer();
			BlackberryBushBlock.registerRenderLayer();
		}
	}
}
