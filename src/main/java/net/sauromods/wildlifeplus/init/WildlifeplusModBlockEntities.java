
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sauromods.wildlifeplus.init;

import net.sauromods.wildlifeplus.block.entity.BlackberryShrubBlockEntity;
import net.sauromods.wildlifeplus.block.entity.BlackberrySeedlingBlockEntity;
import net.sauromods.wildlifeplus.block.entity.BlackberrySaplingBlockEntity;
import net.sauromods.wildlifeplus.block.entity.BlackberryBushBlockEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WildlifeplusModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> BLACKBERRY_SHRUB = register("wildlifeplus:blackberry_shrub", WildlifeplusModBlocks.BLACKBERRY_SHRUB,
			BlackberryShrubBlockEntity::new);
	public static final BlockEntityType<?> BLACKBERRY_SAPLING = register("wildlifeplus:blackberry_sapling", WildlifeplusModBlocks.BLACKBERRY_SAPLING,
			BlackberrySaplingBlockEntity::new);
	public static final BlockEntityType<?> BLACKBERRY_SEEDLING = register("wildlifeplus:blackberry_seedling",
			WildlifeplusModBlocks.BLACKBERRY_SEEDLING, BlackberrySeedlingBlockEntity::new);
	public static final BlockEntityType<?> BLACKBERRY_BUSH = register("wildlifeplus:blackberry_bush", WildlifeplusModBlocks.BLACKBERRY_BUSH,
			BlackberryBushBlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
