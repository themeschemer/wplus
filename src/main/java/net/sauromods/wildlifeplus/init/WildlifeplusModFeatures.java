
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.sauromods.wildlifeplus.world.features.ores.BlackberryShrubFeature;
import net.sauromods.wildlifeplus.world.features.ores.BlackberrySeedlingFeature;
import net.sauromods.wildlifeplus.world.features.ores.BlackberrySaplingFeature;
import net.sauromods.wildlifeplus.world.features.ores.BlackberryBushFeature;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WildlifeplusModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(BlackberryShrubFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				BlackberryShrubFeature.GENERATE_BIOMES, BlackberryShrubFeature.CONFIGURED_FEATURE));
		REGISTRY.put(BlackberrySaplingFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				BlackberrySaplingFeature.GENERATE_BIOMES, BlackberrySaplingFeature.CONFIGURED_FEATURE));
		REGISTRY.put(BlackberrySeedlingFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				BlackberrySeedlingFeature.GENERATE_BIOMES, BlackberrySeedlingFeature.CONFIGURED_FEATURE));
		REGISTRY.put(BlackberryBushFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
				BlackberryBushFeature.GENERATE_BIOMES, BlackberryBushFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
