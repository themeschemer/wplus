
package net.sauromods.wildlifeplus.world.features.ores;

import net.sauromods.wildlifeplus.init.WildlifeplusModBlocks;

import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import java.util.Set;
import java.util.Random;

public class BlackberrySaplingFeature extends OreFeature {
	public static final BlackberrySaplingFeature FEATURE = (BlackberrySaplingFeature) new BlackberrySaplingFeature()
			.setRegistryName("wildlifeplus:blackberry_sapling");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(
					new OreConfiguration(BlackberrySaplingFeatureRuleTest.INSTANCE, WildlifeplusModBlocks.BLACKBERRY_SAPLING.defaultBlockState(), 16))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(50), VerticalAnchor.absolute(128)))).squared().count(10);
	public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("taiga"), new ResourceLocation("dark_forest"),
			new ResourceLocation("dark_forest_hills"), new ResourceLocation("taiga_hills"), new ResourceLocation("swamp"),
			new ResourceLocation("swamp_hills"));

	public BlackberrySaplingFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;
		if (dimensionType == Level.OVERWORLD)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return false;
		return super.place(context);
	}

	private static class BlackberrySaplingFeatureRuleTest extends RuleTest {
		static final BlackberrySaplingFeatureRuleTest INSTANCE = new BlackberrySaplingFeatureRuleTest();
		static final com.mojang.serialization.Codec<BlackberrySaplingFeatureRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		static final RuleTestType<BlackberrySaplingFeatureRuleTest> CUSTOM_MATCH = Registry.register(Registry.RULE_TEST,
				new ResourceLocation("wildlifeplus:blackberry_sapling_match"), () -> codec);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;
			if (blockAt.getBlock() == Blocks.GRASS)
				blockCriteria = true;
			if (blockAt.getBlock() == Blocks.DANDELION)
				blockCriteria = true;
			if (blockAt.getBlock() == Blocks.BLUE_ORCHID)
				blockCriteria = true;
			if (blockAt.getBlock() == Blocks.ALLIUM)
				blockCriteria = true;
			if (blockAt.getBlock() == Blocks.AZURE_BLUET)
				blockCriteria = true;
			if (blockAt.getBlock() == Blocks.OXEYE_DAISY)
				blockCriteria = true;
			return blockCriteria;
		}

		protected RuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}
	}
}
