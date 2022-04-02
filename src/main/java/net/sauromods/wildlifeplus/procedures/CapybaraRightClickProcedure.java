package net.sauromods.wildlifeplus.procedures;

import net.minecraftforge.eventbus.api.Event;

public class CapybaraRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof CapybaraEntity && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == WildlifeplusModItems.WILDPEDIA) {
			{
				if (sourceentity instanceof ServerPlayer _ent) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return new TextComponent("WildpediaGUICapybara");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new WildpediaGUICapybaraMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
